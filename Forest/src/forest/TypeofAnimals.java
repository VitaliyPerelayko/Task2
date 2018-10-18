package forest;

import other.MyPeriod;

import java.time.Period;

public enum TypeofAnimals {
    VOLFE(20,2,6,2,50,20,60),FERRET(8,1,4,1,3,10,20) ,DEER(20,2,6,3,50,30,75), RABBIT(10,1,4,1,2,10,20),
    BEAR(35,2,10,5,200,15,60);

    private MyPeriod ageOfDeath;             //длительность жизни
    private MyPeriod ageOfPuberty;            //возраст половозрелости
    private MyPeriod periodOfGestation;       //период вынашивания
    private int minWeight;                  //масса при рождении
    private int maxWeight;                  //максимальная масса
    private int minSpeed;                   //
    private int maxSpeed;                   //максимальная скорость

    TypeofAnimals(int ageOfDeath, int ageOfPuberty, int periodOfGestation,int minWeight,
                  int maxWeight,int minSpeed, int maxSpeed) {
        this.ageOfDeath = new MyPeriod(Period.of(ageOfDeath,0,0));
        this.ageOfPuberty = new MyPeriod(Period.of(ageOfPuberty,0,0));
        this.periodOfGestation = new MyPeriod(Period.of(0,periodOfGestation,0)) ;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
    }

    public MyPeriod getAgeOfDeath() {
        return ageOfDeath;
    }

    public MyPeriod getAgeOfPuberty() {
        return ageOfPuberty;
    }

    public MyPeriod getPeriodOfGestation() {
        return periodOfGestation;
    }

    public int getMinWeight() {
        return minWeight;
    }

    public int getMaxWeight(){return maxWeight; }

    public int getMinSpeed() {return minSpeed; }

    public int getMaxSpeed() {return maxSpeed; }
}
