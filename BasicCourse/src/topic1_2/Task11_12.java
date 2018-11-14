package topic1_2;

public class Task11_12 {
    public static void main(String[] args) {
        /*Задание 11. Имеется целое число, определить является ли это число простым,
        * т.е. делится без остатка только на 1 и на себя.
        * (Двойку я не учитывал, легко определить что 2 это простое число)
         */
        int number = 167;//45363407;
        boolean check=true;
        if (number%2==0){
            check=false;
        }else{
            for (int i=3;i<=number/i;i+=2){
                if (number%i==0){
                    check=false;
                    break;
                }
            }
        }
        if (check){
            System.out.println("Number: "+number+" is prime");
        }else {
            System.out.println("Number: "+number+" isn't prime");
        }



        /*Задание 12. Имеется целое число, следует вывесли его в бухгалтерском формате.
        * Т.е начиная справа каждые три позиции отделяются пробелом. Например число
        * 52454556 должно быть выведено как 52 454 556.
        * (Это задание в тетради до массивов)
         */
        int money = 1645476;
        if (money<0) {
            System.out.print("-");
            money=-money;
        }
        for (int i = 1000000000; i!=0;i/=1000){  //i=1000000000 потомучто максимальное целое 2 147 483 647
            int temp=money/i;
            money=money%i;
            if (temp!=0) {
                System.out.print(temp + " ");
            }
        }
    }
}
