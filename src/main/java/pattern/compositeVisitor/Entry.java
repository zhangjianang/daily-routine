package pattern.compositeVisitor;

/**
 * Created by adimn on 2018/8/7.
 */
public abstract class Entry implements Element{

    public abstract String getName();

    public abstract Integer getSize();

    public Entry add(Entry data) throws Exception {
        throw new Exception("not impliment!");
    }
    public abstract void getList();
}
