package factory;

/**
 * Created by adimn on 2018/8/21.
 */
public abstract class Factory {
    public final Product create(String owner){
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }
    public abstract Product createProduct(String owner);
    public abstract void registerProduct(Product p);
}
