package thread;

import lambda.Hero;

/**
 * Created by adimn on 2018/11/1.
 */
public class CommThread {

    /**
     *  展示线程通信问题，只有 血量大于一时候，才能继续减血
     * @param args
     */
    public static void main(String[] args) {
        ThreadHero deadman = new ThreadHero("deadman",10);



        for(int i=0 ;i<2;i++){
            new DamangeThread(deadman).start();
        }


        HelpThread h1 = new HelpThread(deadman);
        h1.start();

    }
}

class DamangeThread extends Thread{
    private ThreadHero hero;
    public DamangeThread(ThreadHero hero){
        this.hero = hero;
    }
    public void run(){
        while (true) {
            hero.hurt();
            try {
                Thread.sleep(20);
//                Thread.yield();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


class HelpThread extends Thread{
    private  ThreadHero hero;

    public HelpThread(ThreadHero hero){
        this.hero = hero;
    }

    public void run(){
        while (true) {
            hero.recover();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}