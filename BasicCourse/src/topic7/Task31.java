package topic7;

/*  Задание 31. Имеется файл с текстом в котором присутствуют числа. Найти все числа,
 *  распечатать, посчитать сумму, убрать вск=е повторяющиеся числа и снова распечатать.
 *
 */


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Task31 {

    public static final String PATH = "E:\\Работа\\Віталюга\\It-academi\\BasicCourse\\src\\topic7\\text.txt";


    public static boolean isDigit (char a){
        if ((a>='0')&&(a<='9')){
            return true;
        }
        return false;
    }

    public static ArrayList<Double> numbersInText(char[] line){
        ArrayList<Double> result = new ArrayList<>();
        for (int i=0;((i<line.length)&&(line[i]!='\u0000'));i++){

            if ( isDigit(line[i])){
                StringBuilder temp = new StringBuilder();
                temp.append(line[i]);
                while (i+1<line.length){
                    if (isDigit(line[i+1])){
                        temp.append(line[i+1]);
                        i++;
                        continue;
                    }
                    if (line[i+1]==' '){
                        i++;
                        continue;
                    }
                    if ((line[i+1]==',')||(line[i+1]=='.')){
                        temp.append('.');
                        i++;
                        continue;
                    }
                    break;
                }
                result.add(new Double(temp.toString()));
            }

        }

        return result;
    }

    public static void main(String[] args) {
        List<Double> num = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH))) {

            while (true){
                char[] line = new char[1000];
                if ((bufferedReader.read(line))!=-1) {
                    num.addAll(numbersInText(line));
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
        System.out.println("numbers in text");
        System.out.println(num);
        System.out.println("sum of numbers");
        double sum=0;
        for (Double a:num){
            sum+=a;
        }
        System.out.println(sum);
        System.out.println(new TreeSet(num));
    }
}
