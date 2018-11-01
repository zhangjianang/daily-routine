package thread;

import lambda.Hero;

/**
 * Created by adimn on 2018/11/1.
 */
public class DeadThread {

    /**
     *  显示死锁出现问题。
     * @param args
     */
    public static void main(String[] args) {
        Hero treeman  = new Hero("treeman",100,10);
        Hero darksoul  = new Hero("darksoul",150,20);
        Hero monkey  = new Hero("monkey",100,15);
        Thread t1 = new Thread(){
            public void run(){
                synchronized (treeman){
                    try {
                        System.out.println(Thread.currentThread().getName()+ " get "+ treeman.name);
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" wating to get " +darksoul.name);
                    synchronized (darksoul){
                        System.out.println(Thread.currentThread().getName()+ " get "+ darksoul.name);
                    }
                }
            }
        };
        t1.start();

        Thread t2 = new Thread(){
            public void run(){
                synchronized (darksoul){
                    try {
                        System.out.println(Thread.currentThread().getName()+ " get "+ darksoul.name);
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" wating to get " +monkey.name);
                    synchronized (monkey){
                        System.out.println(Thread.currentThread().getName()+ " get "+ monkey.name);
                    }
                }
            }
        };
        t2.start();

        Thread t3 = new Thread(){
            public void run(){
                synchronized (monkey){
                    System.out.println(Thread.currentThread().getName()+ " get "+ monkey.name);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" wait to get "+ treeman.name);
                    synchronized (treeman){
                        System.out.println(Thread.currentThread().getName()+" get "+ treeman.name);
                    }
                }
            }
        };
        t3.start();
    }
}
