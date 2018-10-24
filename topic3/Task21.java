package topic3;
/* Напишите два цикла выполняющих многократное сложение строк, один с помощью оператора сложения и , а другой
* с помощью  и метода . Сравните скорость их выполнения.
*
 */
public class Task21 {
    public static void main(String[] args) {

        String test1 = "";
        StringBuilder test2 = new StringBuilder();

        long time1 = System.nanoTime();
        for (int i=0;i<1500;i++){
            test1 += (char)i;
        }
        System.out.println(System.nanoTime()-time1);

        time1 = System.nanoTime();
        for (int i=0;i<1500;i++){
            test2.append((char)i);
        }
        System.out.println(System.nanoTime()-time1);

    }
}
