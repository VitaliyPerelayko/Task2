package topic4.task25.real;

/** Карта покупок с кашбэком.
 *
 */

import topic4.task25.main.Store;

import java.math.BigDecimal;

public class ShopingCard extends RealCard {

    private double cashBack;

    public ShopingCard(String number, String ovner, int cvvCode, int pinCode, String currencyType,double cashBack) {
        this.number =number;
        this.owner=ovner;
        this.cvvCode=cvvCode;
        this.pinCode=pinCode;
        this.currencyType=currencyType;
        this.cashBack=cashBack;
    }

    //кашбэк с покупок
    @Override
    public boolean buySmth(Store store){
        if (super.buySmth(store)){
            String cost = store.openInfo()[2];
            Double turnBack = new Double(cost)*this.cashBack;
            this.putMoney(new BigDecimal(turnBack.toString()));
            return true;
        }
        return false;
    }
}
