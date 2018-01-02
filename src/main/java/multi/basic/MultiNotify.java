package multi.basic;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ang on 2017/12/29.
 */
public class MultiNotify {
    public static void main(String[] args) {
        Money m = new Money();
        PoolOne p1 = new PoolOne(m,"奖池1");
        PoolOne p2 = new PoolOne(m,"奖池2");
        new Thread(p1).start();
        new Thread(p2).start();
    }
}

class PoolOne implements Runnable{
    private Money m ;
    private String name;
    public PoolOne(Money m,String name){
        this.m = m;
        this.name = name;
    }
    public void run() {
        while (true){
            System.out.println(name +" pool get"+m.getOne());
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Money{
    private List<Integer> money = new ArrayList<Integer>();
    public Money(){
        money.add(100);
        money.add(10);
        money.add(50);
        money.add(200);
        money.add(800);
        money.add(500);
    }
    public int getOne(){
        synchronized (this) {
            int i = -1;
            while (i<0) {
                i = new Random().nextInt(money.size());
            }
            return money.remove(i);
        }
    }
}
