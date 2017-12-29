package multi.basic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by adimn on 2017/12/29.
 */
public class SafeLock implements  Runnable{
    private int sum =100;
    private Lock lock = new ReentrantLock();
    public void run() {
        lock.lock();

            while(sum > 0){
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                    sum--;
                System.out.println(Thread.currentThread().getName()+" "+ sum);
            }
        lock.unlock();

    }

    public static void main(String[] args) {
        SafeLock sf = new SafeLock();
        Thread t1 = new Thread(sf);
        Thread t2 = new Thread(sf);
        Thread t3 = new Thread(sf);
        t1.start();
        t2.start();
        t3.start();
    }
}
