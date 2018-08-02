package pattern.responsibility;

/**
 * Created by adimn on 2018/8/2.
 */
public interface Handler {
    public void process(int message);
    public void setNext(Handler h1);
}
