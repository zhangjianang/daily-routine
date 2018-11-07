package thread;

import java.text.SimpleDateFormat;

/**
 * Created by adimn on 2018/11/7.
 */
public class LockThread {
    public static String now(){
        return new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis());
    }

    public static void main(String[] args) {

        Thread t1 =  new Thread(){
          public void run(){
              System.out.println(getName()+"启动");
              System.out.println(getName()+"视图占有资源");
              synchronized (this){
                  System.out.println(getName()+"占有资源");
                  try {
                      Thread.sleep(5000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  System.out.println(getName()+"释放资源");
              }
              System.out.println(getName()+"结束");
          }
        };
        t1.setName("t1");
        t1.start();

        Thread t2 =  new Thread(){
            public void run(){
                synchronized (this){
                    System.out.println(getName()+"获取资源");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName()+"执行完成");
                }
            }
        };
        t2.setName("t2");
        t2.start();

    }
}
