package multi.basic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by adimn on 2017/12/28.
 */
public class MultiAdd implements Callable<Integer> {
    private  Integer sum = 0;
    private Integer end = 0;
    public MultiAdd(Integer inadd){
        this.end = inadd;
    }
    public Integer call() throws Exception {
        for(int i = 0; i<end;i++){
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
//        es.submit(new )
    }
}
