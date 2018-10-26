package topic4.task23;
/* Задание 23. Создать класс и объекты описывающте банкомат.
*  Набор купюр находящихся в банкомате должен задаваться тремя свойствами: количеством купюр
*  номиналом 20 50 и 100.  (1 пункт)
*  Сделать метод для добавления денег в банкомат. (2 пункт)
*  Сделать метод снимающий деньги. на вход передаётся сумма денег. на выход - булевское значение
*  (операция удалась или нет) (3 пункт)
*  При снятии денег функция должна распечатывать каким количеством купюр какого номинала выдаётся сумма.
*  Создать конструктор с тремя параметрами - количеством купюр. (4 пункт)
*  Прочее на ваше усмотрение.
*
 */

public class ATM {
    private int count100;       // 1 пункт
    private int count50;
    private int count20;

    private boolean empty;

    public boolean isEmpty(){
        return this.empty;
    }

    public ATM(int count100,int count50, int count20){       //4 пункт
        if ((count100<0)||(count50<0)||(count20<0)){
            throw new IllegalArgumentException("# The sum of money must be positive");
        }
        this.count100=count100;
        this.count50=count50;
        this.count20=count20;
        if ((count100>0)||(count50>0)||(count20>0)){
            this.empty=false;
        }else {
            this.empty=true;
        }
    }

    public ATM(){
        this(0,0,0);
    }

    public void putMoney(int count100,int count50, int count20){     //2 пункт
        if ((count100<0)||(count50<0)||(count20<0)){
            throw new IllegalArgumentException("# The sum of money must be positive");
        }
        this.count100+=count100;
        this.count50+=count50;
        this.count20+=count20;
        if (this.empty){
            if ((count100>0)||(count50>0)||(count20>0)){
                this.empty=false;
            }
        }
    }

    public boolean giveMoney(int money){     //3 пункт
        if (money<0){
            System.out.println("The entered amount is not valid. Amount must be positive");
            return false;
        }

        int check = money%100;
        if ((check==10)||(check==30)||(money%10!=0)){
            System.out.println("Sorry! Impossible to provide required amount.\n The ATM only provides banknotes 20 50 100\n Type another amount");
            return  false;
        }

        if (money>(this.count100*100+this.count50*50+this.count20*20)){
            System.out.println("Sorry! Impossible to provide required amount.\n The ATM has only "+
                    (this.count100*100+this.count50*50+this.count20*20)+" money\n Type the lower amount");
            return false;
        }

        boolean isSuccess=false;
        if (check==60){
            if (this.count20<3){
                System.out.println("Sorry! Impossible to provide required amount.\n The ATM only provides "+this.count20+
                        " banknotes 20 \n Type another amount");
                return false;
            }else {
                this.count20-=3;
                money-=60;
                isSuccess=this.countingMoney(money,check);
                if (isSuccess){
                    return true;
                }else {               //По идее такого никогда не случиться, но пусть пока будет
                    this.count20+=3;
                    return false;
                }
            }
        }

        if (check==80){
            if (this.count20<4){
                System.out.println("Sorry! Unable to provide required amount.\n The ATM only provides "+this.count20+
                        " banknotes 20 \n Type another amount");
                return false;
            }else {
                this.count20-=4;
                money-=80;
                isSuccess=this.countingMoney(money,check);
                if (isSuccess){
                    return true;
                }else {                             //По идее такого никогда не случиться, но пусть пока будет
                    this.count20 += 4;
                    return false;
                }
            }
        }

        isSuccess = this.countingMoney(money,check);
        if (!isSuccess){
            return false;
        }
        return true;

    }

    private boolean countingMoney(int money,int check){
        int temp100 = this.count100;
        int temp50 = this.count50;
        int temp20 = this.count20;
        while ((money/100!=0)&&(temp100!=0)){
            money-=100;
            temp100--;
        }
        while ((money/50!=0)&&(temp50!=0)){
            money-=50;
            temp50--;
        }
        while ((money/20!=0)&&(temp20!=0)){
            money-=20;
            temp20--;
        }

        if (money!=0){
            System.out.println("Sorry! The ATM only provides " + this.count100 + " 100 "
                    + this.count50 + " 50 " + this.count20 + " 20\n Type another amount");
            return false;
        }
        if (check==60){
            System.out.println("Sun has been given by "+(this.count100-temp100)+
                    " 100; "+(this.count50-temp50)+" 50; "+(this.count20-temp20+3)+" 20" );
        }else {
            if (check == 80) {
                System.out.println("Sun has been given by " + (this.count100 - temp100) +
                        " 100; " + (this.count50 - temp50) + " 50; " + (this.count20 - temp20 + 4) + " 20");
            } else {
                System.out.println("Sun has been given by " + (this.count100 - temp100) +
                        " 100; " + (this.count50 - temp50) + " 50; " + (this.count20 - temp20) + " 20");
            }
        }
        this.count100=temp100;
        this.count50=temp50;
        this.count20=temp20;
        if ((this.count100+this.count50+this.count20)==0){
            this.empty=true;
        }
        return true;
    }
//////////////////////
    public void printState(){
        System.out.println("ATM has:\n"+this.count100 + " 100\n"
                + this.count50 + " 50\n" + this.count20 + " 20");
    }
}
