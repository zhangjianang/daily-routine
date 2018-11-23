package pattern.composite;

/**
 * Created by adimn on 2018/11/23.
 */
public interface Element {
    public void accept(Visitor v);
}
