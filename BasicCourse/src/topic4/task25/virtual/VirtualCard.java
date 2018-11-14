package topic4.task25.virtual;

import topic4.task25.Card;

public class VirtualCard extends Card {

    public VirtualCard(String number, String ovner, int cvvCode, String currencyType) {
        this.number =number;
        this.owner=ovner;
        this.cvvCode=cvvCode;
        this.currencyType=currencyType;
    }
}
