package topic1Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Customer extends Thread {

    private List<GoodsEmum> goodsOfCastomer = new ArrayList<>();

    public List<GoodsEmum> getGoodsOfCastomer() {
        return goodsOfCastomer;
    }

    @Override
    public void run() {
        //Набираем продукты
        Random random = new Random();
        int mum = random.nextInt(4)+1;
        for (int i=0;i<mum;i++){
            int temp=random.nextInt(Goods.GOODS.size());
            goodsOfCastomer.add(Goods.GOODS.get(temp));
        }
        //Становимся в очередь
        CashRegister [] cr = Store.cashRegisters;
        int min = cr[0].getSizeOfQueue();
        int numberOfQueue=0;
        for (int i=0;i<cr.length;i++){
            int size = cr[i].getSizeOfQueue();
            if (size==0){
                cr[i].putCustomer(this);
                break;
            }else if(min>size){
                min = size;
                numberOfQueue=i;
            }
        }
        cr[numberOfQueue].putCustomer(this);
    }
}
