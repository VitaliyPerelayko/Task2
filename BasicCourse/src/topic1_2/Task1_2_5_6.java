package topic1_2;


public class Task1_2_5_6 {
    // Для задания№6 метод определения високосный год или нет
    public static boolean isLeapYar(int year) {
        if (year % 4 == 0) {
            if (year % 100 != 0) {
                return true;
            } else {
                if (year % 400 == 0) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        //Задание 1. Набрать и запустить свою первую программу
        System.out.println("Hello World");

        //Задание 2. Продолжить пример расчёта едениц времени и добавить сутки и недели
        int s = 99359778;
        int sec = s%60;
        s = (s-sec)/60;
        int min = s%60;
        s = (s-min)/60;
        int hours = s%60;
        s = (s-hours)/60;
        int days = s%24;
        int weeks = (s-days)/60;
        System.out.println(weeks+" weeks "+days+" days "+hours+" hours "+min+" minutes "+sec+" seconds" );

        //Задание 5. Имеется целое число. Вывести это число, добавив к нему слово "рублей" в правильном падеже.
        int money = 65473;
        int lastDigit = money%10;
        if (lastDigit==1){
            System.out.println(money+" рубль");
        }
        if ((lastDigit>=2)&&(lastDigit<=4)){
            System.out.println(money+" рубля");
        }
        if ((lastDigit>=5)||(lastDigit==0)){
            System.out.println(money+" рублей");
        }

        //Задание 6. Имеются три числа - день, месяц и год. Вывести в виде трёх чисел дату следующего дня
        //(проще всего конечно через LocalDate ..... plusDays(1), но я так понимаю от нас хотели не это.
        int year = 2045, month = 2, day = 29;

        if ((month>12)||(month<1)){                             //проверка корректности месяца
            System.out.println("Incorrect Date");
        }else {
            //февраль
            if (month == 2) {
                if (day > 29) {                                     //проверка корректности дня
                    System.out.println("Incorrect Date");
                } else {
                    if (day + 1 > 28) {                 //если есть подозрение что завтра будет другой месяц
                        if (isLeapYar(year)) {          // проверяем какой год
                            if (day + 1 > 29) {         // если год високосный проверяем поменяется ли месяц
                                System.out.println("Next day: " + 1 + "." + (month + 1) + "." + year);
                            } else {
                                System.out.println("Next day: " + (day + 1) + "." + month + "." + year);
                            }
                        } else {                        //если год не високосный и дата корректная будет записан следующий месяц
                            if (day>28){
                                System.out.println("Incorrect Date");
                            }else {
                                System.out.println("Next day: " + 1 + "." + (month + 1) + "." + year);
                            }
                        }
                    } else {                //если дата не пограничная для месяца просто добавляем день
                        System.out.println("Next day: " + (day + 1) + "." + month + "." + year);
                    }
                }
            }
            //декабрь
            if (month == 12) {
                if (day > 31) {
                    System.out.println("Incorrect Date");
                } else {
                    if (day + 1 > 31) {
                        System.out.println("Next day: " + 1 + "." + 1 + "." + (year + 1));
                    } else {
                        System.out.println("Next day: " + (day + 1) + "." + month + "." + year);
                    }
                }
            }
            //остальные месяцы
            if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
                if (day > 30) {
                    System.out.println("Incorrect Date");
                } else {
                    if (day + 1 > 30) {
                        System.out.println("Next day: " + 1 + "." + (month + 1) + "." + year);
                    } else {
                        System.out.println("Next day: " + (day + 1) + "." + month + "." + year);
                    }
                }
            } else{
                if ((month != 12)&&(month!=2)) {
                    if (day>31) {
                        System.out.println("Incorrect Date");
                    }else{
                        if (day + 1 > 31) {
                            System.out.println("Next day: " + 1 + "." + (month + 1) + "." + year);
                        } else {
                            System.out.println("Next day: " + (day + 1) + "." + month + "." + year);
                        }
                    }
                }
            }
        }


    }
}
