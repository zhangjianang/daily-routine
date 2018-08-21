package factory;

/**
 * Created by adimn on 2018/8/21.
 */
public class IDCard extends Product {
    private String owner;
    public IDCard(String name){
        this.owner = name;
    }
    @Override
    public void use() {
        System.out.println(owner+" card used !");
    }
}
