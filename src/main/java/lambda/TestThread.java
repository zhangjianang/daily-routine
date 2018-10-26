package lambda;

/**
 * Created by adimn on 2018/10/26.
 */
public class TestThread {

    public static void main(String[] args) {

        Hero boundkiller = new Hero("bound killer",100,50);
        Hero darksoul = new Hero("darksoul",130,60);
        Hero treeman = new Hero("treeman",150,30);
        Hero monkey = new Hero("monkey",80,40);
//        单线程执行。
//        boundkiller.attackHero(monkey);
//        darksoul.attackHero(treeman);

        KillerThread k1 = new KillerThread(boundkiller,monkey);
        new Thread(k1).start();

        KillerThread k2 = new KillerThread(darksoul,treeman);
        new Thread(k2).start();
    }
}
