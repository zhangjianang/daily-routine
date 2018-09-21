package pattern.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by adimn on 2018/9/21.
 */
public class Manager  {

    private Map showcase;

    public Manager(){
        showcase =  new HashMap();
    }

    public void register(String s,Product p){
        showcase.put(s,p);
    }
    public Product create(String s){
        Product p = (Product)showcase.get(s);
        return p.createClone();
    }

    public static void main(String[] args) {
        Manager m = new Manager();
        m.register("under",new UnderLinePen('_'));
        m.register("box",new BoxPen('*'));

        Product box = m.create("box");
        box.use("we are box");

        box = m.create("under");
        box.use("under line ");
    }
}
