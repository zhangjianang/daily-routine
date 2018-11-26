package pattern.compositeVisitor;

/**
 * Created by adimn on 2018/8/7.
 */
public class File extends Entry {
    private Integer size;
    private String name;

    public File(String name,Integer size){
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getSize() {
        return this.size;
    }

    @Override
    public void getList() {
        System.out.println("name is: "+getName()+"; size is: "+getSize());
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
