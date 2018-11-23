package pattern.compositeVisitor;

/**
 * Created by adimn on 2018/11/23.
 */
public abstract class Visitor {
    public abstract void visit(File f);
    public abstract void visit(Folder f);
}
