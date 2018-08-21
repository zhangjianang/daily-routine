package factory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adimn on 2018/8/21.
 */
public class IDCardFactory extends Factory {
    private List owners;

    public IDCardFactory(){
        owners = new ArrayList();
    }
    @Override
    public Product createProduct(String name) {
        return new IDCard(name);
    }

    @Override
    public void registerProduct(Product p) {
        owners.add(p);
    }

    public static void main(String[] args) {
        Factory f1 = new IDCardFactory();
        Product p1 = f1.create("lily");
        Product p2 = f1.create("harry");
        Product p3 = f1.create("john");
        p1.use();
        p2.use();
        p3.use();
    }
}
