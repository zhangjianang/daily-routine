package multi.basic;

/**
 * Created by ang on 2017/12/28.
 */
public class DeadLock implements Runnable{
    private int i = 0 ;
    public void run() {
        while(true){
            if (i%2 == 0){
                synchronized (ThreadA.getA){
                    System.out.println(Thread.currentThread().getName()+"a in");
                    synchronized (ThreadB.getB){
                        System.out.println(Thread.currentThread().getName()+" b in");

                    }
                }
            }else {
                synchronized (ThreadB.getB){
                    System.out.println(Thread.currentThread().getName()+"b in");
                    synchronized (ThreadA.getA){
                        System.out.println(Thread.currentThread().getName()+"a in");
                    }
                }
            }
            i++;
        }
    }

    public static void main(String[] args) {
        DeadLock d = new DeadLock();
        Thread t1 = new Thread(d);
        Thread t2 = new Thread(d);
        t1.start();
        t2.start();
    }
}


class ThreadA{
    private ThreadA(){}
    public static  ThreadA getA = new ThreadA();
}

class ThreadB{
    private ThreadB(){}
    public static  ThreadB  getB =new ThreadB();
}