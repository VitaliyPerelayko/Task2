package topic7;

/*  Задание 30. Создать файл с текстом, прочитать, подсчитать в тексте количество знаков препинания и слов.
*
 */

import com.sun.javafx.UnmodifiableArrayList;

import java.io.*;

public class Task30 {

    public static final String PATH = "E:\\Работа\\Віталюга\\It-academi\\BasicCourse\\src\\topic7\\text.txt";

    private static final UnmodifiableArrayList<Character> PUNCTU;
    static {
        Character [] a ={'.',',',':',';','-','?','!','(',')','"'};
        PUNCTU=new UnmodifiableArrayList<>(a,a.length);

    }

    public static int[] plus (int[] a,int[] b){
        return new int[] {a[0]+b[0],a[1]+b[1]};
    }

    public static int[] punctuationANDwords (char[] line){
        int [] pANDw = {0,0};
        for (int i=0;((i<line.length)&&(line[i]!='\u0000'));i++){
            //System.out.println((int) line[i]);
            if ((line[i] == ' ') ||
                    ((line[i] == '\n')&&(line[i-2]!='\n'))
            ) {
                //System.out.println((int) line[i-1]);
                pANDw[1] += 1;
            }
            if (PUNCTU.contains(line[i])) {
                pANDw[0] += 1;
            }
        }

        return pANDw;
    }

    public static void main(String[] args) {
        int[] pANDw = {0,1};
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH))) {

            while (true){
                char[] line = new char[1000];
                if ((bufferedReader.read(line))!=-1) {
                    pANDw = plus(pANDw, punctuationANDwords(line));
                }else {
                    break;
                }
            }


        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("=((((");
            e.printStackTrace();
        }
        System.out.println("punctuations ||  words");
        System.out.println(pANDw[0]+"           "+"||"+"   "+pANDw[1]);
        //System.out.println((int)'\n');
    }
}
