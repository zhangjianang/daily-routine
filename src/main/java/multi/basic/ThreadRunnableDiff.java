package multi.basic;

/**
 * Created by adimn on 2018/1/3.
 */
public class ThreadRunnableDiff {
    public static void main(String[] args) {
        MyThread m1 = new MyThread("t1");
        MyThread m2 = new MyThread("t2");
//        Thread t1 = new Thread(m1);
//        Thread t2 = new Thread(m1);
        m1.start();
        m2.start();

        MyRunnable r1 = new MyRunnable("run1");
        MyRunnable r2 = new MyRunnable("run2");
        Thread t3 = new Thread(r1);
        Thread t4 = new Thread(r2);
        t3.start();
        t4.start();
    }
}

class MyThread extends  Thread{
    private String name ;
    private  static int i = 0;

    public MyThread(String name){
        this.name = name;
    }
    public void run(){
        Thread.currentThread().setName(name);
        synchronized (this) {
            while (i++ < 100) {
                try {
                    this.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " print " + i);
            }
        }
    }
}

class MyRunnable implements Runnable{
    private static int i =0;
    private String name;
    public MyRunnable(String name){
        this.name = name;
    }
    public void run() {
        Thread.currentThread().setName(name);
        synchronized (this) {
            while (i++ < 100) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " print " + i);
            }
        }
    }
}