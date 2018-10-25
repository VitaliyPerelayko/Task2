package topic4.task22;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Demonstration {
    public static void main(String[] args) {
        Time time = new Time(354);
        //Time time1 = new Time(1,70,7);
        //time = null;
        //time.printTime();
        time.printTime();
        //time.minusMinute(70);
        time.plusHour(2);
        time.printTime();
        System.out.println();

        Time time1 = Time.ZERO;
        time1.plusHour(1);
        time1.printTime();
        System.out.println();

        List<Time> times = new ArrayList<>();
        Random random =new Random();
        for (int i=0;i<10;i++){
            times.add(new Time(random.nextInt(50000)));
        }
        times.sort(Time::compareTo);
        times.forEach(Time::printTime);
    }
}