package pattern.strategy;

import java.util.Random;

/**
 * Created by adimn on 2018/8/14.
 */
public class WinStrategy implements Strategy {
    private Hand nextHand;

    private int[] stat;

    private int num;

    public WinStrategy(){
        nextHand =  new Hand(new Random().nextInt(3));
        num = 1;
        stat = new int[3];
    }

    @Override
    public Hand nextHand() {
        int nextkey = 0;
        int max = stat[0];
        for(int i = 1;i<3;i++) {
            if (stat[i] > max) {
                max = stat[i];
                nextkey = i;
            }
        }
        return  new Hand(nextkey);
    }

    @Override
    public void study(Boolean win) {
        num++;
        if(win){
            stat[nextHand.getHandValue()] ++ ;
        }
    }
}
