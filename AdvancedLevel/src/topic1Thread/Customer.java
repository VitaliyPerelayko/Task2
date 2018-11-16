package topic1Thread;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class Customer implements Callable {

    private BigDecimal money;
    private List<Good> goods = new  ArrayList<Good>();

    public Customer(String money) {
        Random random = new Random();
        int mum = random.nextInt(4)+1;
        for (int i=0;i<mum;i++){
            this.goods.add(Goods.GOODS.get(1));//random.nextInt(Goods.GOODS.size()-1)));
        }
        this.money = new BigDecimal(money);
    }

    public BigDecimal getMoney() {
        return money;
    }

    public List<Good> getGoods() {
        return goods;
    }

    @Override
    public BigDecimal call() {
        BigDecimal sum = new BigDecimal("0");
        // Печатаем чек
        for (Good good: goods){
            if (this.money.compareTo(good.getPrise())>0) {
                System.out.println(good);
                sum.add(good.getPrise());
                this.money.subtract(good.getPrise());
            }else {
                break;
            }
        }
        System.out.println("In total: "+sum);
        return sum;
    }
}
