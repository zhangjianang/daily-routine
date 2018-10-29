package lambda;

/**
 * Created by adimn on 2018/10/26.
 */
public class KillerThread implements Runnable {
    private  Hero h1;
    private  Hero h2;

    private int isYeild = 0;

    public KillerThread (Hero h1,Hero h2){
        this.h1 = h1;
        this.h2 = h2;
    }

    @Override
    public void run() {
        startKill();
    }

    public void startKill(){
        while (!h2.isDead()){
            while(isYeild-- > 0){
                Thread.yield();
            }
            h1.attackHero(h2);
        }
    }




    public int getIsYeild() {
        return isYeild;
    }

    public void setIsYeild(int isYeild) {
        this.isYeild = isYeild;
    }
}
