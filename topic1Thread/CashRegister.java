package topic1Thread;


import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.concurrent.*;

public class CashRegister extends Thread  {

    private BigDecimal money = new BigDecimal("0");
    private String cashier;
    private static int count;
    private final int id=++count;
    private int numberOfCustomersServed;
    private LinkedBlockingQueue<Customer> queue = new LinkedBlockingQueue<>();

    private File receipt;


    public CashRegister(String cashier) {
        //файл где хранятся чеки
        receipt = new File(".\\register#"+id+".txt");

        try {
            receipt.createNewFile();
        } catch (IOException e) {
        //если произошла ошибка записываем её в ЛогФайл
            Store.LOG_REGISTER.aadInfo("CashRegister# "+id+"are not created\n");
            Store.LOG_REGISTER.aadInfo(LogRegister.ExceptionToString(e));
            return;
        }
        this.cashier= cashier;

    }


    public int getNumberOfCustomersServed() {
        return numberOfCustomersServed;
    }

    public String getPathToReceipr() throws IOException {
        return receipt.getCanonicalPath();
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

    public int getIdOfCashRegister() {
        return id;
    }


    public void putCustomer(Customer customer){
        try {
            queue.put(customer);
        } catch (InterruptedException e) {
            Store.LOG_REGISTER.aadInfo("The buyer can not get in line to cash register #"+id+"\n");
            Store.LOG_REGISTER.aadInfo(LogRegister.ExceptionToString(e));
        }
    }

    public synchronized int getSizeOfQueue(){
        return queue.size();
    }

    public static CashRegister[] setCashRegisters(String[] cashiers){
        CashRegister [] cashRegisters = new CashRegister[cashiers.length];
        for (int i=0;i<cashiers.length;i++){
            cashRegisters[i]=new CashRegister(cashiers[i]);
        }
        return cashRegisters;
    }

    @Override
    public void run() {
        while (Store.flag) {
            //Если очередь пуста передаём ресурсы другому потоку
            if (queue.isEmpty()) {
                yield();
            }
            //иначе берём покупателя
            else {
                Customer customer = queue.poll();
                // Увеличиваем счётчик клиентов
                numberOfCustomersServed++;
                // Печатаем чек и
                //ложим деньги в кассу
                money=money.add(writeReceipt(customer));
            }
        }
    }

    private BigDecimal writeReceipt(Customer customer){
        BigDecimal sum = new BigDecimal("0");
        try (PrintWriter printWriter =new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(receipt,true)))) {

            printWriter.println("Cashier: "+cashier+"\n----------------\nCashRegister №"+id+"\n");
            for (GoodsEmum goods: customer.getGoodsOfCastomer()) {
                printWriter.println(goods);
                sum=sum.add(goods.getPrise());
            }
                printWriter.println("In total: "+sum);
            printWriter.println(LocalDateTime.now());
            printWriter.println("\n=============================================\n");

        } catch (FileNotFoundException e) {
            Store.LOG_REGISTER.aadInfo("Unable to save check to memory");
            Store.LOG_REGISTER.aadInfo(LogRegister.ExceptionToString(e));
        }
        return sum;
    }

}
