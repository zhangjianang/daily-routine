package thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by adimn on 2018/11/1.
 */
public class MyThreadPool {

    LinkedList<Thread> pools ;

    public MyThreadPool(){
        pools =  new LinkedList();
        for(int i = 0;i<20;i++){
            new ExecuteClass(i+"").start();
        }
    }

    public  void add(Thread r1){
        synchronized(pools) {
            if (pools.size() == 10) {
                try {
                    wait();
                    System.out.println("增加wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                pools.add(r1);
                pools.notifyAll();
                System.out.println("增加 notify");
            }
        }
    }



    public static void main(String[] args) {
        MyThreadPool pool = new MyThreadPool();

        for(int i =0;i<5;i++){
            pool.add(new Thread(){
                public void run(){
                    System.out.println("新进程"+Thread.currentThread().getName()+ " 得到执行");
                }
            });
        }

    }

    class ExecuteClass extends Thread{
        public ExecuteClass(String name){
            super(name);
        }
        private Thread pool;

        public void run(){
            while (true){
                System.out.println(getName()+"启动进程！");
                synchronized (pools){
                    while(pools.isEmpty()){
                        try {
                            pools.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    pool = pools.removeLast();
                }
                pool.start();
                System.out.println(getName()+"获取到任务，并执行！");
            }
        }
    }

}


