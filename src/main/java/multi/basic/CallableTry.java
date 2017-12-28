package multi.basic;

import java.util.concurrent.*;

/**
 * Created by adimn on 2017/12/28.
 */
public class CallableTry implements Callable<String> {
    public String call() throws Exception {
        return "ang";
    }

    public static void main(String[] args) {
        old();
    }

    public static void old() {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<String> res = es.submit(new CallableTry());
        try {
            System.out.println(res.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
