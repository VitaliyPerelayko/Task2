package other;
import java.time.LocalDate;
import java.time.Period;

public class MyPeriod {
    private Period period;

    public Period getPeriod() {
        return period;
    }

    public static Period correctPeriod(Period period){
        LocalDate temp = LocalDate.of(0,1,1);
        temp=temp.plus(period);
        return Period.of(temp.getYear(),temp.getMonthValue()-1,temp.getDayOfMonth()-1);
    }

    public MyPeriod (Period period){
        this.period=correctPeriod(period);
    }

    public boolean isBigger(MyPeriod p1){
        LocalDate temp1= LocalDate.of(0,1,1);
        LocalDate temp2= temp1;
        temp1 = temp1.plus(this.period);
        temp2 = temp2.plus(p1.period);
        if (temp1.isAfter(temp2)){
            return true;
        }
        return false;
    }

    public MyPeriod plus(Period period){
        this.period = correctPeriod(this.period.plus(period));
        return this;
    }

    public MyPeriod minus(Period period){
        this.period = correctPeriod(this.period.minus(period));
        return this;
    }


}
