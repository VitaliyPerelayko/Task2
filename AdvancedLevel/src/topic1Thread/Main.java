package topic1Thread;

public class Main {
    public static void main(String[] args) {

        CashRegister cashRegister = new CashRegister("dg","113");
        Customer customer = new Customer("5765");
        cashRegister.putCustomer(customer);
    }
}
