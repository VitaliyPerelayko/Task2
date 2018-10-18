import forest.Animals;

import java.time.Period;
import java.util.Iterator;
import java.util.List;

public class Predstor extends Animals {

    public Predstor(String type,String sex){
        super(type,sex);
    }

    @Override
    public  Predstor childBirth() {
        this.setPregnancy(false);
        String sex;
        if (Math.random() > 0.5) {
            sex = "male";
        } else {
            sex = "female";
        }
        Predstor temp = new Predstor(this.getTypeofAnimals().name(), sex);
        temp.setWeight(temp.getTypeofAnimals().getMinWeight());
        temp.setSpeed(temp.getTypeofAnimals().getMinSpeed());
        return temp;
    }

    //метод питания хищников
    @Override
    public double eat(double quantityOfFood,List<Animals> deadAnimals, List<Animals> otherAnimals){

        double mass=0;                                 // масса съеденого

            Iterator<Animals> iteratorDead = deadAnimals.iterator();
            Iterator<Animals> iteratorOther = otherAnimals.iterator();

        while (iteratorDead.hasNext()){         // сначала хищник поедает мёртвых животных
            mass+=iteratorDead.next().getWeight();
            iteratorDead.remove();
            if (mass>0.5*this.getWeight()){
                this.setFull(true);
                this.setIll(false);
                break;
            }
        }

        if (this.isFull()) return quantityOfFood;                // если хищник наелся метод завершается

        while (iteratorOther.hasNext()){               // затем хищник охотится на животных
            if (hunting(iteratorOther.next())!=0){
                mass+=hunting(iteratorOther.next());
                iteratorOther.remove();
            }
            if (mass>0.5*this.getWeight()){
                this.setFull(true);
                this.setIll(false);
                break;
            }
        }

        if (this.isFull()) {                                      //если хищник был болен и не наелся, он умрёт
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
