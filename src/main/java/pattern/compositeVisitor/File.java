package pattern.compositeVisitor;

/**
 * Created by adimn on 2018/8/7.
 */
public class File extends Entry {
    private Integer size;

    public File(String name,Integer size){
        super(name,size);
    }

    @Override
    public void getList() {
        System.out.println("name is: "+getName()+"; size is: "+getSize());
    }

    public void toSring(){
        System.out.println("name is: "+getName()+"; size is: "+getSize());
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
