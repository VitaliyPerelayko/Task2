package forest;
import java.sql.Array;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import other.MyPeriod;

public abstract   class Animals  {

    private TypeofAnimals typeofAnimals;  // название животного

    public TypeofAnimals getTypeofAnimals() {
        return typeofAnimals;
    }

    private  String sex;                 //пол животного

    public String getSex() {
        return sex;
    }

    private boolean ill=false;         // болен или нет

    public boolean isIll() {
        return ill;
    }
    public void setIll(boolean ill) {
        this.ill = ill;
    }

    private double weight;              //масса животного

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    private int speed;                  // скорость передвижения

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    private boolean alive = true;         // жив или нет

    public boolean isAlive() {
        return alive;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    private MyPeriod age=new  MyPeriod(Period.of(0,0,0));                //возраст животного

    public MyPeriod getAge() {
        return age;
    }
    public void setAge(MyPeriod age) {
        this.age =age;
    }

    private boolean pregnancy=false;             //беременно животное или нет

    public boolean isPregnancy() {
        return pregnancy;
    }
    public void setPregnancy(boolean pregnancy) {
        this.pregnancy = pregnancy;
    }

    private boolean full=true;       // Сыт или нет

    public boolean isFull() {
        return full;
    }
    public void setFull(boolean full) {
        this.full = full;
    }

    private MyPeriod periodOfGestation;            // период вынашивания

    public MyPeriod getPeriodOfGestation() {
        return periodOfGestation;
    }
    public void setPeriodOfGestation(MyPeriod periodOfGestation){this.periodOfGestation=periodOfGestation;};

    private boolean puberty = false;

    public boolean isPuberty() {
        return puberty;
    }

    public void setPuberty(boolean puberty) {
        this.puberty = puberty;
    }

    //Конструктор животного
    public Animals(String type, String sex){
        this.typeofAnimals=TypeofAnimals.valueOf(type);
        this.sex = sex;
    }


    //Метод изменения состояния животноко через определённый промежуток времени
    public void stateOverTime(){
        this.setAge(this.getAge().plus(Period.of(0,1,0)));
        if (this.getAge().isBigger(this.getTypeofAnimals().getAgeOfDeath())){           //если животное умерло,
            this.setAlive(false);                                                       //то дальнейшие изменения бессмысленны
            return;
        }
        if (this.getWeight()<this.getTypeofAnimals().getMaxWeight()){                   //животное взрослеет
            this.setWeight(this.getWeight()+0.2*this.getWeight());                      //и больше весит
        }
        if (this.getSpeed()<this.getTypeofAnimals().getMaxSpeed()){                     //животное взрослеет
            this.setSpeed(this.getSpeed()+2);                                           //и быстрее бегает
        }
        if (this.isPregnancy()){                                                        //период беременности уменьшается на месяц
            this.setPeriodOfGestation(this.getPeriodOfGestation().minus(Period.of(0,1,0)));
        }
        this.setFull(false);                                                            //становиться голодным

    }

    public abstract Animals childBirth();

    //метод питания
    public abstract double eat(double quantityOfFood, List<Animals> deadAnimals, List<Animals> otherAnimals);

    // Метод охота (Для Вмталика важно, что здесь сравнение объектов по ссылке, не создавать новый объект жертв)
    public double hunting(Animals prey){
        if (this.equals(prey)){
            return 0;
        }
        double correction=0;
        if (this.isIll()!=prey.isIll()){
            if (this.isIll()){
                correction=-0.2;
            }else {
                correction=0.2;
            }
        }
        // шанс поймать добычу зависит от удачи, скоростей хищника и добычм, сотояния здоровья
        double chanse = (this.getSpeed()-prey.getSpeed())*0.1+Math.random()+correction;
        if (chanse>0.8){
            return prey.getWeight();
        }
        return 0;
    }
    // Метод спаривание
    public void mating(Animals female){
        female.setPregnancy(true);
        female.setPeriodOfGestation(female.getTypeofAnimals().getPeriodOfGestation());
    }

    //метод поск партнёра для спаривания
    public void lookFor (List<Animals> animals){
        if (("male".equals(this.getSex()))&&(!this.isIll())){
            for(Animals animals1:animals){
                if (("female".equals(animals1.getSex()))&&(!animals1.isIll())
                        &&(this.getTypeofAnimals().name()==animals1.getTypeofAnimals().name())){
                    this.mating(animals1);
                    break;
                }
            }
        }
    }



}


