package topic7;

/* Задание 32. Записать в двоичный файл 20 случайных чисел. Прочитать
 * записанный файл, распечатать числа и их среднее арифметическое.
 */

import java.io.*;
import java.util.Random;

public class Task32 {
    public static void main(String[] args) {

        File file = null;
        try {
            file = File.createTempFile("numbers",".dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (DataOutputStream dataOutputStream =new DataOutputStream
                        (new BufferedOutputStream(
                                new FileOutputStream(file)))){
            Random random = new Random();
            for (int i=0;i<20;i++) {
                dataOutputStream.writeInt(random.nextInt(200));
            }

        } catch (IOException e) {
            System.out.println("Can't do this");

        }
        try (DataInputStream dataInputStream =new DataInputStream
                (new BufferedInputStream(
                        new FileInputStream(file)))){
            double sum = 0;
            int a=0;
            for (int i=0;i<20;i++) {
                a=dataInputStream.readInt();
                sum+=a;
                System.out.println("number"+(i+1)+" = "+a);
            }
            System.out.println("the arithmetic mean of the numbers= "+sum/20);


        } catch (IOException e) {
            System.out.println("Can't do this");

        }

        file.delete();
    }
}
