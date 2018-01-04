package multi.springMulti;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


/**
 * Created by adimn on 2018/1/4.
 */
@Service
public class MyThreadLocal {
    private static ThreadLocal<Integer> i = new ThreadLocal<Integer>();
    @Async
    public void mystart(){
        i.set(100);
        System.out.println(Thread.currentThread().getName()+" print "+ i.get());
    }

    @Async
    public void mysecond(){
        System.out.println(Thread.currentThread().getName()+" show "+i.get());
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AsyncConfig.class);
        MyThreadLocal mt  = context.getBean(MyThreadLocal.class);
        mt.mystart();
        mt.mysecond();

        MyThreadLocal mt2  = context.getBean(MyThreadLocal.class);
        mt2.mysecond();
    }
}
