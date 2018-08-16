package pattern.strategy;

/**
 * Created by adimn on 2018/8/14.
 */
public class Player {
    private String name;
    private Strategy strategy;

    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }


    public void win(){
        strategy.study(true);
    }

    public void lose(){
        strategy.study(false);
    }

    public Hand nextHand(Boolean win){
        if(win){
            win();
        }else {
            lose();
        }
        return strategy.nextHand();
    }
}
