package lambda;

/**
 * Created by adimn on 2018/10/26.
 */
public class TestThread {

    public static void main(String[] args) {

        Hero boundkiller = new Hero("bound killer",100,50);
        Hero darksoul = new Hero("darksoul",130,60);
        Hero treeman = new Hero("treeman",350,30);
        Hero monkey = new Hero("monkey",280,40);
//        单线程执行。
//        boundkiller.attackHero(monkey);
//        darksoul.attackHero(treeman);




//        Runnable r1 = new Runnable() {
//            @Override
//            public void run() {
//                int seconds =0;
//
//                while(true){
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                    System.out.printf("已经玩了LOL %d 秒%n", seconds++);
//
//                }
//            }
//        };
//        Thread d1 = new Thread( r1);
//        d1.setDaemon(true);
//        d1.start();

        Thread d2= new Thread(){
            public void run(){
                int seconds =0;

                while(seconds <10){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.printf("已经玩了LOL %d 秒%n", seconds++);

                }
            }
        };
        d2.setDaemon(true);
        d2.start();


        KillerThread k2 = new KillerThread(darksoul,treeman);
//        k2.setIsYeild(10);
        Thread t2 = new Thread(k2);
        t2.setPriority(Thread.MAX_PRIORITY);
        t2.start();

        KillerThread k1 = new KillerThread(boundkiller,monkey);
        Thread t1 = new Thread(k1);
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();

    }
}
