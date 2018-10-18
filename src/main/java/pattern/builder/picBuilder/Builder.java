package pattern.builder.picBuilder;

/**
 * Created by adimn on 2018/10/17.
 */
public abstract class Builder {
    public abstract void makeTitle(String title);
    public abstract void makeString(String str);
    public abstract void makeItems(String[] items);
    public abstract void close();
}
