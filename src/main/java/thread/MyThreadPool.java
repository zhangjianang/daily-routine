package thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by adimn on 2018/11/1.
 */
public class MyThreadPool {

    private LinkedList<Runnable> pools ;

    public MyThreadPool(){
        pools =  new LinkedList();
    }

    public synchronized void add(Runnable r1){
        if(pools.size() == 5){
            try {
                this.wait();
                System.out.println("增加wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            pools.add(r1);
            System.out.println("增加 notify");
        }
    }

    public synchronized void execute(){
        if(pools.size() ==0 ){
            try {
                this.wait();
                System.out.println("执行wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            for( int i=0;i<pools.size();i++){
                System.out.println("thread-"+i +" 开始执行");
                new Thread(pools.get(i)).start();
                System.out.println("thread-"+i +" 执行完成");
                pools.remove(i);
                this.notifyAll();
                System.out.println("执行 notify");
            }
        }
    }

    public static void main(String[] args) {
        MyThreadPool pool = new MyThreadPool();
        for(int i=0 ;i<10 ;i++){
            pool.add(()->{
                System.out.println("新建-"+ Thread.currentThread().getName()+"-线程");
            });
        }
        new Thread(){
            public void run(){
                while (true) {
                    pool.execute();
                }
            }
        }.start();

    }
}
