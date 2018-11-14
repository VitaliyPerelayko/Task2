package topic4.task25.real;

public class CreditCard extends RealCard{

    public CreditCard(String number, String ovner, int cvvCode,int pinCode, String currencyType) {
        this.number =number;
        this.owner=ovner;
        this.cvvCode=cvvCode;
        this.pinCode=pinCode;
        this.currencyType=currencyType;
    }

}
