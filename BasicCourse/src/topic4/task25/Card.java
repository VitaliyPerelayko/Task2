package topic4.task25;


import topic4.task25.main.Store;

import java.math.BigDecimal;

/** Задание 25. Создать мерархию классов, описывающих банковские карточки.
 * Иерархия должна иметь хотябы три уровня.
 *
 * Чтобы программа не получилась такой же унылой как про бытовую технику, я попытался смоделировать
 * шифрование при передаче важных данных владельца карты. Clas ElGamal
 *
 *
 */
public abstract class Card {

    protected String number;
    protected String owner;
    protected int cvvCode;
    protected int pinCode;
    protected String currencyType ; //тип валюты
    protected BigDecimal money=new BigDecimal("0");

    public void putMoney(BigDecimal money){
        this.money=this.money.add(money);
    }


    public boolean buySmth(Store store){
        if (!getConfirmation(store.openInfo(),store.secretInfo())){
            System.out.println("something's wrong");
            return false;
        }
        BigDecimal money = new BigDecimal(store.openInfo()[2]);
        if (this.money.compareTo(money)<0){
            System.out.println("Not enough money");
            return false;
        }
        this.money=this.money.subtract(money);
        return true;
    }


    public String getNumber() {
        return number;
    }

    public String getOwner() {
        return owner;
    }

    public int getCvvCode() {
        return cvvCode;
    }

    public int getPinCode() {
        return pinCode;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public BigDecimal getMoney() {
        return money;
    }

    private boolean getConfirmation(String[] openInfo,long[] closedInfo){
        if ((this.number.equals(openInfo[0]))&&(this.owner.equals(openInfo[1]))){
            int cvvCode = ElGamal.decryption(closedInfo);
            if (cvvCode==this.cvvCode){
                return true;
            }
        }
        return false;
    }
}
