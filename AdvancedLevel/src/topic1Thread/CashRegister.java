package topic1Thread;

import java.math.BigDecimal;
import java.util.SortedMap;
import java.util.concurrent.*;

public class CashRegister extends ThreadPoolExecutor {

    private BigDecimal money;
    private String cashier;
    private static int count;
    private final int id=++count;


    // Кассы я унваследовал от ThreadPoolExecutor, а констрктор взял из фабрики newFixedThreadPool
    public CashRegister(String cashier,String money) {
        super(1, 1, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());//,Executors.defaultThreadFactory());
        this.money= new BigDecimal(money);
        this.cashier= cashier;

    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getCashier() {
        return cashier;
    }

    public int getId() {
        return id;
    }

    public void putCustomer(Customer customer){
        System.out.println("Thanks for your purchase");
        Future<BigDecimal> money = this.submit(customer);
        if (money.isDone()) {
            try {
                this.money.add(money.get());
                System.out.println("Cashier: "+cashier+"\nCashRegister №"+id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Cashier: "+cashier+"\nCashRegister №"+id);
        this.shutdown();
    }
}
