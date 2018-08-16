package pattern.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by adimn on 2018/8/14.
 */
public class Hand {
    private int handValue;

    public Hand(int handValue){
        this.handValue = handValue;
    }

    public int fight(Hand h2){
        if( handValue  == h2.handValue ){
            return 0;
        } else if( ( handValue + 1 ) % 3 == h2.handValue ){
            return 1;
        }else {
            return -1;
        }
    }

    public int getHandValue() {
        return handValue;
    }

    public void setHandValue(int handValue) {
        this.handValue = handValue;
    }
}
