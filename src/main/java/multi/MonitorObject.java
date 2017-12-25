package multi;

/**
 * Created by adimn on 2017/10/23.
 */
public class MonitorObject {

    public void run(){

    }

    public void method1(){
        for(int i =0;i < 10 ;i++){
            System.out.println(Thread.currentThread().getName()+"--"+ i);
        }
    }

    public void method2(){
        for(int i =0;i < 10 ;i++){
            System.out.println(Thread.currentThread().getName()+"--"+ i);
        }
    }

}
