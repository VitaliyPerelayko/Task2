package topic4.task24;

/* Задание 24. Создать иерархиюклассов, описывающих бытовую технику. Создать несколько объектов описанных классов,
*  часть из них включить в розетку.
*  Иерархия должна иметь хотябы три уровня.
 */


import topic4.task24.audiovideo.TV;
import topic4.task24.kitchen.KitchenElectronics;
import topic4.task24.kitchen.Refrigerator;

public class Main {
    public static void main(String[] args) {
        HomeElectronics tv= new TV("W34f6","Samsung",25);
        tv.on();
        System.out.println(tv.isIsWork());
        KitchenElectronics refrig= new Refrigerator("R6993Y6","INDEsIT");
        refrig.on();
    }
}
