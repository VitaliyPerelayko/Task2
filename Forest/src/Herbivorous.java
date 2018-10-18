import java.time.Period;
import java.util.List;
import forest.Animals;
public class Herbivorous extends Animals {

    public Herbivorous(String type,String sex){
        super(type,sex);
    }

    @Override
    public Herbivorous childBirth() {
        this.setPregnancy(false);
        String sex;
        if (Math.random() > 0.5) {
            sex = "male";
        } else {
            sex = "female";
        }
        Herbivorous temp = new Herbivorous(this.getTypeofAnimals().name(), sex);
        temp.setWeight(temp.getTypeofAnimals().getMinWeight());
        temp.setSpeed(temp.getTypeofAnimals().getMinSpeed());
        return temp;
    }

    //метод питания травоядных
    @Override
    public double eat(double quantityOfFood, List<Animals> deadAnimals, List<Animals> otherAnimals ){
        if (quantityOfFood>0.3*this.getWeight()){
            this.setIll(false);
            this.setFull(true);
            quantityOfFood -=0.3*this.getWeight();                // они должны съесть 0,3 массы своего тела
        }else {
            if (this.isIll()){                                    // если животное не наелось и оно больно оно умирает
                this.setAlive(false);
            }else {
                this.setIll(true);                                // а если здорово, оно заболевает
            }
        }
        return quantityOfFood;
    }
}
