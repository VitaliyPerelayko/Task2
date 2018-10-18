import java.time.Period;
import java.util.*;


import  forest.Animals;
/*Я почемуто сначала придумывал классы, кто кого будет наследовать, поля, методы. И это было моей ошибкой, я не придумал точно как всё это будет
*соотносится в главном классе. Поэтому тут всё так криво реализованно.
*
 */
public class Forest {


    public static void main(String[] args){

        List<Animals> animals =new ArrayList();  //список для всех животных
        /*animals.add(new Predstor("VOLFE","male"));
        Iterator<Animals> iterator = animals.iterator();
        Animals animal = iterator.next();
        System.out.println(animal.getClass()); //ВЫВОДИТ ХИЩНИК
        System.out.println(animals.get(0).getClass());  //ВЫВОДИТ ХИЩНИК
        for (Animals animals1:animals){
            System.out.println(animals1.getClass());    //ВЫВОДИТ ХИЩНИКА
        }*/

        List deadAnimal =new ArrayList();  // список мёртвых животных
        List otherAnimal =new ArrayList();  //остальные животные

        for(int i=0; i<4;i++){      // создаю животных

            animals.add(new Predstor("VOLFE","male"));
            animals.add(new Predstor("VOLFE", "female"));
            animals.add(new Predstor("FERRET", "male"));
            animals.add(new Predstor("FERRET", "female"));



            animals.add(new Herbivorous("DEER", "male"));
            animals.add(new Herbivorous("DEER", "female"));
            animals.add(new Herbivorous("RABBIT", "male"));
            animals.add(new Herbivorous("RABBIT", "female"));



            animals.add(new Omnivorous("BEAR", "male"));
            animals.add(new Omnivorous("BEAR", "female"));

        }
        // Задание первоначальных параметров для животных

        for (Animals animal:animals){
            animal.setWeight(animal.getTypeofAnimals().getMinWeight());
            animal.setSpeed(animal.getTypeofAnimals().getMinSpeed());
        }


        while (true){                                   // основная часть программы
            Scanner typed = new Scanner(System.in);     // вводим целое число количество пищи
            int press = typed.nextInt();                // если ввели 0 программа прекращает работу
            if (press==0){
                break;
            }
            double qualityOfFood =press;
            ListIterator<Animals> iterator = animals.listIterator();
            while (iterator.hasNext()){

                Animals animal = iterator.next();

                // животные стареют, умирают и становятся старше на месяц
                animal.stateOverTime();

                //заполняем списки мёртвых и остальных животных
                for (Animals animal1 : animals) {

                    if (!(animal.isAlive())) {
                        deadAnimal.add(animal1);
                    } else {
                        otherAnimal.add(animal1);
                    }
                }

                // животные едят

                qualityOfFood = animal.eat(qualityOfFood, deadAnimal, otherAnimal);

                //Животные размножаются
                if (animal.isPuberty()){
                    animal.lookFor(animals);
                }else{
                    if (animal.getAge().isBigger(animal.getTypeofAnimals().getAgeOfPuberty())){
                        animal.setPuberty(true);
                    }
                }


                //роды новых животных
                if (animal.isPregnancy()){
                    iterator.add(animal.childBirth());
                }

                // очищаем списки мёртвых other
                deadAnimal.clear();
                otherAnimal.clear();


                //выводим состояние фауны
                System.out.println("Name      Age       Alive        Ill");

                System.out.println(animal.getTypeofAnimals().name() + "     " + animal.getAge().getPeriod().toString() + "      " + animal.isAlive() + "     " + animal.isIll());
                System.out.println("=====================================");

                }


        }



    }
}
