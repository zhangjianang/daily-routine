package multi.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by adimn on 2017/12/28.
 */
public class MultiTry{


    public static void main(String[] args) {

        new Thread(new Runnable() {

            public void run() {
                Thread.currentThread().setName("忘词");
                for(int i = 0; i < 10; i++){

                    System.out.println(Thread.currentThread().getName()+" "+i);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread() {
             public void run(){
                 Thread.currentThread().setName("小强");
                 for(int i =0; i< 10;i ++){
                     System.out.println(Thread.currentThread().getName()+" "+i);

                 }
             }
        }.start();


        ExecutorService es = Executors.newFixedThreadPool(1);
        es.submit(new Runnable() {
            public void run() {
                Thread.currentThread().setName("小崔");
                for(int i = 0; i<10 ;i++){
                    System.out.println(Thread.currentThread().getName()+""+i);
                }
            }
        });
    }
}
