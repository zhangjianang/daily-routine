package pattern.composite;

/**
 * Created by adimn on 2018/8/7.
 */
public abstract class Entry implements Element{
    private String name;
    private Integer size;
    public Entry(String name,Integer size){
        this.name = name;
        this.size = size;
    }

    public String getName(){
        return name;
    }

    public Integer getSize(){
        return size;
    }
    public void setSize(Integer size){
        this.size = size;
    }

    public Entry add(Entry data) throws Exception {
        throw new Exception("not impliment!");
    }
    public abstract void getList();
}
