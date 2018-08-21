package pattern.template;

/**
 * Created by adimn on 2018/8/21.
 */
public class CharShow extends AbstractShow {
    private String name;

    public CharShow(String name) {
        this.name = name;
    }

    @Override
    public void open() {
        System.out.println("------------------");
    }

    @Override
    public void print() {
        System.out.println(name);
    }

    @Override
    public void close() {
        System.out.println("------------------");
    }
}
