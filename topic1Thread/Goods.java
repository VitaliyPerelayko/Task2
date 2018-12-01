package topic1Thread;

import java.util.HashMap;

public class Goods  {

    public static final HashMap<Integer, GoodsEmum> GOODS = new HashMap<>();

    static {
        GOODS.put(0, GoodsEmum.BREAD);
        GOODS.put(1, GoodsEmum.MILK);
        GOODS.put(2,GoodsEmum.ORANGE);
        GOODS.put(3,GoodsEmum.ICECREAM);
        GOODS.put(4,GoodsEmum.POTATO);
        GOODS.put(5,GoodsEmum.PIZZA);

    }

}

