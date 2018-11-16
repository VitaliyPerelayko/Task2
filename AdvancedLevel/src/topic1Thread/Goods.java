package topic1Thread;

import java.util.HashMap;

public class Goods  {

    public static final HashMap<Integer,Good> GOODS = new HashMap<>();

    static {
        GOODS.put(1,Good.BREAD);
        GOODS.put(2,Good.MILK);

    }

}

