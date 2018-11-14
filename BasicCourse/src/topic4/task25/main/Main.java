package topic4.task25.main;

import topic4.task23.ATM;
import topic4.task25.real.CreditCard;
import topic4.task25.virtual.VirtualCard;

import java.math.BigDecimal;



public class Main {
    public static void main(String[] args) {

        VirtualCard virtualCard = new VirtualCard("1234-5678-8901","Vitaliy Perelayko",
                512,"EUR");
        virtualCard.putMoney(new BigDecimal("5000"));
        Owner owner = new Owner(virtualCard);
        Store store = new Store(owner,"500");

        System.out.println(virtualCard.buySmth(store));
        System.out.println(virtualCard.getMoney());

        CreditCard creditCard= new CreditCard("1234-5678-8901","Vitaliy Perelayko",
                512, 3456,"EUR");
        creditCard.putMoney(new BigDecimal("579.4324"));
        ATM atm = new ATM();
        atm.putMoney(2,10,2);
        creditCard.getMoneyATM(new BigDecimal("540"),atm);
        atm.printState();
        System.out.println(creditCard.getMoney());
    }
}
