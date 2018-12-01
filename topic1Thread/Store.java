package topic1Thread;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Store {
    public static boolean flag=true;

    public static final LogRegister LOG_REGISTER = LogRegister.getLogRegister();

    //Список кассиров
    private final static String[] CASHIER = {"Stalin", "Trotsky", "Khrushchev", "Lenin", "Brezhnev"};
    //Создаём кассы
    public static CashRegister[] cashRegisters = CashRegister.setCashRegisters(CASHIER);

    public static void main(String[] args) {

        Random random = new Random();
        //Исполнитель для касс
        ExecutorService poolForCashier = Executors.newFixedThreadPool(cashRegisters.length);

        for (CashRegister cr:cashRegisters) {
            poolForCashier.execute(cr);
        }

        //Исплнители для покупателей
        ExecutorService poolForCustomers = Executors.newCachedThreadPool();

        //Постепенно добавляем покупателей
        for (int i = 0; i < 10; i++) {
            //количество новых покyпателей
            int numOfCastomers = random.nextInt(20);
            for (int j=0;j<numOfCastomers;j++){
                poolForCustomers.execute(new Customer());
            }
        }
        poolForCustomers.shutdown();

        //Проверяем есть ли ещё не обслуженные покупатнли и закрываем магазин
        while (true) {
            int i=0;
            for (CashRegister cr:cashRegisters){
                i+=cr.getSizeOfQueue();
            }
            if (i==0){
                flag=false;
                break;
            }else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
        poolForCashier.shutdown();

        //Выводим и логируем итоговую информацию
        System.out.println("Path to LogFile: "+LogRegister.getPath()+"\n");

        for (CashRegister cr:cashRegisters){
            String temp;
            StringBuilder result = new StringBuilder();
            try {
                temp="Cash Register №: "+cr.getIdOfCashRegister();
                System.out.println(temp);
                result.append(temp+"\n");
                temp="Cashier: "+cr.getCashier();
                System.out.println(temp);
                result.append(temp+"\n");
                temp=cr.getPathToReceipr();
                System.out.println(temp);
                result.append(temp+"\n");
                temp="Customers served "+cr.getNumberOfCustomersServed();
                System.out.println(temp);
                result.append(temp+"\n");
                temp="The total amount of cash "+cr.getMoney();
                System.out.println(temp);
                result.append(temp+"\n");
                LOG_REGISTER.aadInfo(result.toString());
                System.out.println("\n==============================\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}