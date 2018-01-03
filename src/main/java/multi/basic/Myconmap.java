package multi.basic;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by adimn on 2018/1/3.
 */
public class Myconmap {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            int count =0;
            public void run() {
                while(count < 10000){
                    System.out.println("con map num is " + ConMapIncrease.conIncrease("ang"));
                    count++;
                }
            }
        }).start();
        new Thread(new Runnable() {
            int count =0;
            public void run() {
                while(count < 10000){
                    System.out.println("con map num is " + ConMapIncrease.conIncrease("ang"));
                    count++;
                }
            }
        }).start();
        new Thread(new Runnable() {
            int count =0;
            public void run() {
                while(count < 10000){
                    System.out.println("con map num is " + ConMapIncrease.conIncrease("ang"));
                    count++;
                }
            }
        }).start();
    }
}


class ConMapIncrease{
    private static ConcurrentMap<String,Integer> conmap  = new ConcurrentHashMap<String,Integer>();
    public static Integer conIncrease(String key){
        Integer newvalue,oldvalue;
        while(true){
             oldvalue =  conmap.get(key);
            if(oldvalue == null) {
                newvalue =1;
                if (conmap.putIfAbsent(key, newvalue) == null) {
                    break;
                }
            }else{
                newvalue = oldvalue + 1;
                if(conmap.replace(key,oldvalue,newvalue)){
                    break;
                }
            }
        }
        return newvalue;
    }
}
