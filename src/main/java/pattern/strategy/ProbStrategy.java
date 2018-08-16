package pattern.strategy;

import java.util.Random;

/**
 * Created by adimn on 2018/8/14.
 */
public class ProbStrategy implements Strategy {
    private Hand hand;
    public ProbStrategy(){
        this.hand = new Hand(new Random().nextInt(3));
    }

    @Override
    public Hand nextHand() {
        return hand;
    }

    @Override
    public void study(Boolean win) {
        if(win){

        }
        hand = new Hand(new Random().nextInt(3));
    }
}
