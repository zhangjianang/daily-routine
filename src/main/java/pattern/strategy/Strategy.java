package pattern.strategy;

/**
 * Created by adimn on 2018/8/14.
 */
public interface Strategy {
     Hand nextHand();
     void study(Boolean win);
}
