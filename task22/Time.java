package topic4.task22;
/* Задание 22. Создать класс и объекты описывающие промежуток времени. Сам промежуток в классе должен задаваться
*  тремя свойствами: секундами, минутами, часами.(1 пункт)Сделать методы для получения полного количества секунд в
*  одъекте (2 пункт), сравнения двух объектов (метод должен работать аналогично compareTo в строках). (3 пункт)
*  Создать два конструктора: получающий общее количество секунд (4 пункт) , и часы минуты секунды по
*  отдельности (5 пункт). Сделать метод для вывода данных (6 пункт). Прочее на ваше усмотрение.
*
 */

import com.sun.istack.internal.NotNull;

/**
 * @author Vitaliy Perelayko
 */

public class Time implements Comparable<Time>,WorkWithTime {
    private int hours;   //1 пункт
    private int minute;
    private int second;

    public Time(int hours, int minute, int second) {     //5 пункт
        if ((minute>59)||(minute<0)||(second<0)||(second>59)){
            throw new IllegalArgumentException("# number of minute and second must be between 0 and 59");
        }
        this.hours = hours;
        this.minute = minute;
        this.second = second;
    }

    public Time(int second){
        this(second/3600,(second/60)%60,second%60);   //4 пункт
    }

    public static final Time ZERO = new Time(0);

    @Override
    public int getSecond(){                                           //  2 пункт
        return this.hours*3600+this.minute*60+this.second;
    }

    @Override
    public int compareTo(Time o) {                          // 3 пункт
        return (this.getSecond()-o.getSecond());
    }

    @Override
    public void printTime(){                                // 6 пункт
        System.out.println(this.hours+" hours "+this.minute+" minutes "+this.second+" seconds");
    }

    @Override
    public void toCorrectTime() throws IllegalArgumentException {
        if (this.compareTo(ZERO)<0){
            throw new IllegalArgumentException("# Time can't be negative");
        }
        this.hours = this.getSecond()/3600;
        this.minute = (this.getSecond()/60)%60;
        this.second = this.getSecond()%60;
    }

    @Override
    public void plusTime(Time t) {
        this.hours += t.hours;
        this.minute += t.minute;
        this.second += t.second;
        this.toCorrectTime();
    }

    @Override
    public void minusTime(Time t) {
        this.hours -= t.hours;
        this.minute -= t.minute;
        this.second -= t.second;
        this.toCorrectTime();

    }

    @Override
    public void plusSecond(int s) {
        this.second += s;
        this.toCorrectTime();

    }

    @Override
    public void minusSecond(int s) {
        this.second -= s;
        this.toCorrectTime();
    }

    @Override
    public void plusMinute(int m) {
        this.minute += m;
        this.toCorrectTime();
    }

    @Override
    public void minusMinute(int m) {
        this.minute -= m;
        this.toCorrectTime();
    }

    @Override
    public void plusHour(int h) {
        this.hours += h;
        this.toCorrectTime();
    }

    @Override
    public void minusHour(int h) {
        this.hours -= h;
        this.toCorrectTime();
    }


}
