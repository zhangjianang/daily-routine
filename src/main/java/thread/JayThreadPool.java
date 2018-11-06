package thread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by adimn on 2018/11/6.
 */
public class JayThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10,15,60, TimeUnit.MINUTES,new LinkedBlockingDeque<>());
//        pool.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName()+" 启动了！ ");
//            }
//        });

        pool.execute(new Thread(){
            public void run(){
                System.out.println(Thread.currentThread().getName()+" 启动了！ ");
            }
        });
    }
}
