package multi.basic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by adimn on 2018/1/4.
 */
public class AngAtomicReference {

//    private static AtomicInteger at = new AtomicInteger();
    private static AtomicInteger at = new AtomicInteger();


    public static void getAll() throws InterruptedException {
        int t = 10;
        final int c = 10;
        final CountDownLatch cd  = new CountDownLatch(t);
        for(int i =0 ;i <t;i++){
            new Thread(new Runnable() {
                public void run() {
                    for(int i =0;i<c; i ++) {
                        while(true) {
                            Integer old = at.get();
                            if (at.compareAndSet(old, old + 1)) {
                                System.out.println(Thread.currentThread().getName() + " print " + old);
                                break;
                            }
                        }
                    }
                    cd.countDown();
                }
            }).start();
        }
        cd.await();
        System.out.println("final data is :"+at.get());
    }

    public static void main(String[] args) throws InterruptedException {
        AngAtomicReference aa = new AngAtomicReference();
        aa.getAll();
    }
}


class Person{
    private int age;
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public Person(){
        this.age = 0;
    }
}


 class TS {
//    public static void main(String[] args) throws InterruptedException {
//        dfasd111();
//    }

    private static AtomicReference<Integer> ar = new AtomicReference<Integer>(0);

    public static void dfasd111() throws InterruptedException {
        int t = 100;
        final int c = 100;
        final CountDownLatch latch = new CountDownLatch(t);
        for (int i = 0; i < t; i++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < c; i++) {
                        //取值一定要放在循环里面，出错的话，可以再次赋值
                        while (true) {
                            Integer temp = ar.get();
                            if (ar.compareAndSet(temp, temp + 1)) {
                                System.out.println(Thread.currentThread().getName()+" "+temp);
                                break;
                            }
                        }
                    }
                    latch.countDown();
                }
            }).start();
        }
        latch.await();
        System.out.println(ar.get()); //10000
    }

    public final void test() {
        System.out.println(this.getClass());
    }
}
