package topic4.task25.real;

import topic4.task23.ATM;
import topic4.task25.Card;

import java.math.BigDecimal;

public abstract class RealCard extends Card {


    public boolean getMoneyATM(BigDecimal money, ATM atm){
        if ((!atm.isEmpty())&&(this.money.compareTo(money)>0)) {
            if (atm.giveMoney(money.intValue())) {
                this.money=this.money.subtract(money);
                return true;
            }
        }
        return false;
    }




}
