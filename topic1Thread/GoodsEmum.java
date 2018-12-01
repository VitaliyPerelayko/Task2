package topic1Thread;

import java.math.BigDecimal;

public enum GoodsEmum {

    BREAD("1.45"), MILK("1.75"), ORANGE("2"), POTATO("0.8"), ICECREAM("1.15"), PIZZA("3.50");

    private BigDecimal prise;

    GoodsEmum(String prise) {
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
