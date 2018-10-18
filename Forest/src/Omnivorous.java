import forest.Animals;

import java.time.Period;
import java.util.Iterator;
import java.util.List;

public class Omnivorous extends Animals {

    public Omnivorous(String type, String sex){
        super(type,sex);
    }
    @Override
    public Omnivorous childBirth() {
        this.setPregnancy(false);
        String sex;
        if (Math.random() > 0.5) {
            sex = "male";
        } else {
            sex = "female";
        }
        Omnivorous temp = new Omnivorous(this.getTypeofAnimals().name(), sex);
        temp.setWeight(temp.getTypeofAnimals().getMinWeight());
        temp.setSpeed(temp.getTypeofAnimals().getMinSpeed());
        return temp;
    }

    //метод питания всеядного
    @Override
    public double eat(double quantityOfFood, List<Animals> deadAnimals, List<Animals> otherAnimals ) {
        if (quantityOfFood > 0.4 * this.getWeight()) {
            this.setIll(false);
            this.setFull(true);
            quantityOfFood -= 0.4 * this.getWeight();                   // они должны съесть 0,4 массы своего тела
        }
        if (this.isFull()) return quantityOfFood;                // если всеядное наелся метод завершается


        double mass=0;                                 // масса съеденого

        Iterator<Animals> iteratorDead = deadAnimals.iterator();
        Iterator<Animals> iteratorOther = otherAnimals.iterator();

        while (iteratorDead.hasNext()){         // сначала всеядное поедает мёртвых животных
            mass+=iteratorDead.next().getWeight();
            iteratorDead.remove();
            if (mass>0.4*this.getWeight()){
                this.setFull(true);
                this.setIll(false);
                break;
            }
        }

        if (this.isFull()) return quantityOfFood;                // если всеядное наелoсb метод завершается

        while (iteratorOther.hasNext()){               // затем всеядное охотится на животных
            mass+=hunting(iteratorOther.next());
            iteratorOther.remove();
            if (mass>0.4*this.getWeight()){
                this.setFull(true);
                this.setIll(false);
                break;
            }
        }

        if (this.isFull()) {                                 //если всеядное былo болbнo и не наелoсb, онo умрёт
            return quantityOfFood;
        }else{
            if (this.isIll()){
                this.setAlive(false);
            }else{
                this.setIll(true);
            }
        }
        return quantityOfFood;
    }
}
