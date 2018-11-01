package thread;

import lambda.Hero;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by adimn on 2018/11/1.
 */
public class ConThread {
    /**
     *  通过观看多线程中处理 hero血量的方式，展示多线程带来的同步问题
     * @param args
     */
    public static void main(String[] args) {
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 10000;

        System.out.printf("盖伦的初始血量是 %.0f%n", gareen.hp);

        int num = 10000;

        Thread[] addThread = new Thread[num];
        Thread[] descThread = new Thread[num];

        for(int i = 0; i < num; i++){
            Thread t = new Thread(){
                public void run(){
                    gareen.recover();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThread[i] = t;
        }

        for(int i = 0; i < num; i++){
            Thread t = new Thread(){
                public void run(){
                    gareen.hurt();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            descThread[i] = t;
        }

        for(Thread t : addThread){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(Thread t : descThread){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //但是事实上观察到的是：

        System.out.printf("%d个增加线程和%d个减少线程结束后%n盖伦的血量变成了 %.0f%n", num,num,gareen.hp);

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        Map<Object, Object> objectObjectMap = Collections.synchronizedMap(objectObjectHashMap);
    }

}
