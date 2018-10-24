package topic3;

import java.util.Random;

public class Task14_15_16 {
    public static void main(String[] args) {
        //Задание 14. Вывести индекс максимального элемента массива
        Random random = new Random();
        int [] array1 = new int[20];
        for (int i=0;i<array1.length;i++){
            array1[i]=random.nextInt(50);
            System.out.println(i+" "+array1[i]);
        }
        int maxind=0;
        for (int i=1;i<array1.length;i++) {
            if (array1[maxind]<array1[i]){
                maxind=i;
            }
        }
        System.out.println("Max element has index: "+maxind);

        //Задание 15. Определить сумму элементов массмва расположенных между минимальным и максимальным значениями.
        int [] array2 = new int[20];
        System.out.println("index number");
        for (int i=0;i<array2.length;i++){
            array2[i]=random.nextInt(50);
            System.out.println(i+"      "+array2[i]);
        }
        int maxind1=0, minind1=0;
        for (int i=1;i<array2.length;i++) {
            if (array2[maxind1]<array2[i]){
                maxind1=i;
            }
            if (array2[minind1]>array2[i]){
                minind1=i;
            }
        }
        int summ=0;
        if (maxind1>minind1){
            for (int i=minind1;i<=maxind1;i++){
                summ+=array2[i];
            }
        }else{
            for (int i=maxind1;i<=minind1;i++){
                summ+=array2[i];
            }
        }
        System.out.println("Sum of numbers between "+minind1+"th element of array and "+maxind1+"th element = "+summ);


        /*Задание 16. Создать массив, заполнить случайными эдементами, распечатать, перевернуть, и снова распечатать
         * (при переворачивании нежелательно создавать ещё один массив).(Я взял массив из 15-го задания)
         */
        for (int i=0;i<array2.length/2;i++){           // Переворачиваем массив
            int temp=array2[i];
            array2[i]=array2[array2.length-i-1];
            array2[array2.length-i-1]=temp;
        }
        System.out.println("index number");                 //Выводим его
        for (int i=0;i<array2.length;i++){
            System.out.println(i+"      "+array2[i]);
        }

    }
}
