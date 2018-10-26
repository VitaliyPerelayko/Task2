package topic4.task23;

public class DemonstrationATM {
    public static void main(String[] args) {
        ATM a1 = new ATM();
        System.out.println(a1.isEmpty());
        a1.putMoney(5,10,10);
        System.out.println(a1.isEmpty());

        if (!a1.isEmpty()){
            a1.giveMoney(430);
            a1.giveMoney(450);
        }
        a1.printState();
        a1.giveMoney(480);
        System.out.println();
        a1.printState();
        a1.giveMoney(460);
        a1.giveMoney(160);

    }
}
