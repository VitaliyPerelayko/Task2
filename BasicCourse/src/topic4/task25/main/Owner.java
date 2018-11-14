package topic4.task25.main;

/** Владелец карты, который при покупке передаёт в магазин, зашифрованные данные о своей карте.
 *  А уже магазин дередаёт их в банк и получает согласие на транзакцию
 *
 */

import topic4.task25.Card;
import topic4.task25.ElGamal;

import java.io.*;

public class Owner {
    private Card card;
    public Owner(Card card){
        this.card=card;
    }

    public long[] closedInfo(){
        String path = ElGamal.callKeys();
        if ("".equals(path)){
            return new long[]{0,0};
        }
        File file = new File(path);
        long[] temp = new  long[4];
        try (DataInputStream dataInputStream = new DataInputStream(
                new BufferedInputStream(new FileInputStream(file)))){
            for (int i=0;i<temp.length;i++) {
                temp[i] = dataInputStream.readLong();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Something is wrong.=(");
        }
        //  Сразу удаляем файл с открытыми ключами в целях безопасности =)
        file.delete();
        return ElGamal.encryption(temp[0],temp[1],temp[2],card.getCvvCode(),temp[3]);
    }


    public String[] openInfo(){
        return  new String[]{card.getNumber(),card.getOwner()};
    }

}
