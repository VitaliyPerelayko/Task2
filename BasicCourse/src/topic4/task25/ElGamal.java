package topic4.task25;

import java.io.*;
import java.math.BigInteger;
import java.util.Random;

/** Класс предназначеный для шифрования приванной информации о карте, при расчёте через "интернет".
 *  Я попытался это имитировать в меру моих познаний.
 *
 *  Закрытый ключ ***closedKeys*** должен каждый раз генерироваться разным,
 *  чтобы шифр нельзя было слишком легко взломать (Теоретически этот ключ можно подобрать, зная открытые ключи,
 *  но сделать это очень сложно и долго. Но если всётаки получиться, в следующий раз придётся всё делать по новой
 *  так как ключ будет менятся при каждом вызове шифрования)
 *
 *  Метод ***callKeys*** имитирует запрос некоторым пользователем открытых ключей для шифрования
 *  передаваемой информации. Этот запрос приходит в банк и уже на серверах банка этот метод записывает
 *  открытые ключи в некоторый файл (и по идее должен отправлять по интернету пользователю).
 *  В этом же методе происходит сериализация объекта, для того, чтобы этот объект в дальнейшем и провел расшифровку
 *  отправленной информации.
 *
 *  Метод ***encryption*** есть у пользователя, и согласно открытым ключам зашифровывает необходимую информацию.
 *
 *  Метод ***decryption*** на сервере в банке берёт необходимый объект (который до этого был сериализован и
 *  ждал своего часа) и поизводит дешифровку сообщения.
 *
 *
 */
public class ElGamal implements Serializable {
    private static final long PRIME = 10513;   //Простое число

    private static final long PRIMITIVE_ROOT = 7;     //Первообразный корень (Оно считается ниже согласно определению)
    /**
     * ***closedKeys***
     */
    private final int closedKeys;
    {
        Random random = new Random();
        closedKeys =random.nextInt((int) PRIME -3)+2;
    }
    private final long openKey;
    {
        BigInteger pr = new BigInteger(new Long(PRIMITIVE_ROOT).toString());
        BigInteger prime = new BigInteger(new Long(PRIME).toString());
        openKey=pr.pow(closedKeys).mod(prime).longValue();
    }
    private static long count=0;


    public ElGamal(){
        count++;
    }

    /**
     * ***callKeys***
     * @return Возвращает путь к файлу с открытыми ключами и индексом файла в котором
     * искать сериализованный объект
     */
    public static  String callKeys(){

        ElGamal elGamal = new ElGamal();

        File obj = new File(".\\ser"+elGamal.count+".ser");
        try {
            obj.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(new FileOutputStream(obj)) ) {
            objectOutputStream.writeObject(elGamal);
        } catch (IOException e) {
            e.printStackTrace();
        }


        long[] openKey = elGamal.giveOpenKeys();
        String path="";
        File file = null;
        try {
            file = File.createTempFile("openKey",".dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (DataOutputStream dataOutputStream =new DataOutputStream
                (new BufferedOutputStream(
                        new FileOutputStream(file)))){
            path=file.getCanonicalPath();
            for (int i=0;i<openKey.length;i++) {
                dataOutputStream.writeLong(openKey[i]);
            }
            dataOutputStream.writeLong(elGamal.count);

        } catch (IOException e) {
            System.out.println("Can't do this");
            return path;
        }

        System.out.println(path);
        return path;
    }

    /**
     * ***encryption*** Этот метод по идее должен быть и у пользоавателя
     * @param prime    простое число
     * @param primitiveRoot   первообразный корень этого простого числа
     * @param openKey   открытый ключ
     * @param info    информация которую мы хотим зашифровать
     * @param countEG номер сериализованного объекта, нужен потом для расшифровки
     * @return  Возвращает массив параметров необходимых для расшифровки  info
     */
    public static long[] encryption(long prime,long primitiveRoot,long openKey,int info,long countEG){
        long [] temp = new long[3];
        Random random = new Random();
        int randomK = random.nextInt((int)prime-5)+2;
        BigInteger pr = new BigInteger(new Long(primitiveRoot).toString());
        BigInteger prime1 = new BigInteger(new Long(prime).toString());
        BigInteger ok = new BigInteger(new Long(openKey).toString());
        BigInteger inf = new BigInteger(new Integer(info).toString());

        temp[0]=pr.pow(randomK).mod(prime1).longValue();
        temp[1]=ok.pow(randomK).multiply(inf).mod(prime1).longValue();
        temp[2]= countEG;
        return temp;
    }

    /**
     * ***decryption*** расшифровывает информацию, на основе дессериализованного объекта
     * @param info массив параметров необходимых для расшифровки  сообщения
     * @return сообщение которое передавали
     */
    public static int decryption(long[] info){
        ElGamal elGamal = null;
        File file = new File(".\\ser"+info[2]+".ser");
        try (ObjectInputStream objectInputStream =
                     new ObjectInputStream(new FileInputStream(file))){
            try {
                elGamal = (ElGamal)objectInputStream.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* Я сдесь вызываю PRIME от объекта (хотя он всёравно вызывается от класса)
        *  потомучто в дальнейшем можно добавить больше простых чисел и выбирать их
        *  тогда эта переменная уже не будет статической.
         */
        int pow =(int)(elGamal.PRIME-1-elGamal.closedKeys);
        BigInteger info0 = new BigInteger(new Long(info[0]).toString());
        BigInteger info1 = new BigInteger(new Long(info[1]).toString());
        BigInteger prime1 = new BigInteger(new Long(elGamal.PRIME).toString());
        file.delete();
        return info0.pow(pow).multiply(info1).mod(prime1).intValue();
    }

    private long[] giveOpenKeys() {

        long[] temp = new long[3];
        temp[0] = this.PRIME;
        temp[1] = this.PRIMITIVE_ROOT;
        temp[2] = this.openKey;
        return temp;
    }
    /**
     * Здесь я просто вычислял первообразный корень и проверял как всё работает
     * @param args
     */

    public static void main(String[] args) {                          //Я пытаюсь найти первообразный корень
        /*BigInteger pr = new BigInteger("10513");
        BigInteger i = new BigInteger("2");
        BigInteger add = new BigInteger("1");
        int prRoot = -1;
        int k = (int) Math.sqrt(pr.intValue()) + 1;
        while (((i.intValue()) <=k) && (prRoot == -1)) {
            int j = (int) (Math.log10(pr.intValue()) / Math.log10(i.intValue()));  //j примерно = log по основанию i от pr +1
            while (j <= pr.intValue() - 1) {
                if (i.pow(j).mod(pr).intValue() == 1) {
                    if (j==pr.intValue()-1){
                        prRoot=i.intValue();
                    }
                    break;
                }else {
                    j++;
                }
            }
            i=i.add(add);
        }
        System.out.println(prRoot);*/
    }
}
