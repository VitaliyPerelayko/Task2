package topic4.task25.main;


/* Типа это магазин и в него приходят данные про карту
*  а магазин эти данные передаёт в банк для проведения операции
*  buySth()
 */
public class Store {

    Owner owner;
    String money;

    public Store(Owner owner, String money) {
        this.owner = owner;
        this.money = money;
    }

    public long[] secretInfo(){
        return owner.closedInfo();
    }
    public String[] openInfo(){
        return new String[]{owner.openInfo()[0],owner.openInfo()[1],money} ;
    }


}
