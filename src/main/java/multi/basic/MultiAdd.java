package multi.basic;

import java.util.concurrent.*;

/**
 * Created by adimn on 2017/12/28.
 */
public class MultiAdd implements Callable<Integer> {
    private Integer end = 0;
    public MultiAdd(Integer inadd){
        this.end = inadd;
    }
    public Integer call() throws Exception {
        int sum = 0;
        for(int i = 1; i<=end;i++){
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Integer> f1 = es.submit(new MultiAdd(100));
        Future<Integer> f2 = es.submit(new MultiAdd(200));
        System.out.println(f1.get());
        System.out.println(f2.get());
    }
}
