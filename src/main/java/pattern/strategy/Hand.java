package pattern.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by adimn on 2018/8/14.
 */
public class Hand {
    private int handValue;

    private int[] handInfo;

    private int num = 0;

    public Hand(int handValue){
        this.handValue = handValue;
        handInfo = new int[3];
    }

    public int fight(Hand h2){
        if( handValue  == h2.handValue ){
            return 0;
        } else if( ( handValue + 1 ) % 3 == h2.handValue ){
            handInfo[handValue] = handInfo[handValue]+1;
            return 1;
        }else {
            return -1;
        }
    }



}
