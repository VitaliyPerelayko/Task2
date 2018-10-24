package topic3;
//Найти в строке все знаки препинания. Посчитать их количество.

public class Task18 {
    public static void main(String[] args) {
        String text="Здесь мы использовали '0', потому что символы фактически представлены значениями ASCII."+
                "'0' - это char и представлен значением 48."+"!!!!!?????-------";

        char[][] punctuationCharacter = {{'.',0},{',',0},{':',0},{';',0},{'-',0},{'?',0}
        ,{'!',0},{'(',0},{')',0},{'"',0}};
        for (int i=0;i<punctuationCharacter.length;i++){
            int p = 0;
            int n= 0;
            while (p!=-1){
                p=text.indexOf(punctuationCharacter[i][0],p);
                if (p!=-1){
                    p++;
                    n++;
                }
            }
            punctuationCharacter[i][1]=(char)(n+'0');  //n+48
        }
        for (int i=0;i<punctuationCharacter.length;i++){
            System.out.println("Symbol "+punctuationCharacter[i][0]+" found "+punctuationCharacter[i][1]+" times");
        }
    }
}
