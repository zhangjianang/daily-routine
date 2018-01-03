package multi.springMulti;

/**
 * Created by ang on 2018/1/3.
 */
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class CountService {
    private static Integer i=0;
    @Async
    public void count() {
        synchronized (i){
            while (i<100){
                i++;
                System.out.println("one "+Thread.currentThread()+" print "+i);
            }
        }

    }

    @Async
    public void countOne() {
        synchronized (i){
            while(i<100){
                i++;
                System.out.println("two "+Thread.currentThread()+" print " + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AsyncConfig.class);
        CountService countService = context.getBean(CountService.class);
        countService.count();
//        countService.countOne();

        CountService countService2 = context.getBean(CountService.class);
        countService2.count();
        System.out.println("main 当前线程"+Thread.currentThread());
        context.close();
    }
}