package topic1Thread;

import java.math.BigDecimal;

public enum Good {

    BREAD("1.45"),MILK("5");

    private BigDecimal prise;

    Good(String prise) {
        this.prise=new BigDecimal(prise);
    }

    public BigDecimal getPrise() {
        return prise;
    }

    @Override
    public String toString() {
        return super.toString()+"......"+prise.toString();
    }
}
