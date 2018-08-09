package pattern.birdge;

/**
 * Created by adimn on 2018/8/9.
 */
public class StringDisplayImpl extends DisplayImpl {
    String name;

    public StringDisplayImpl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void rawOpen() {
        System.out.println("+-------——————+");
    }

    @Override
    public void rawPrint() {
        System.out.println(name+"  spring pint ");
    }

    @Override
    public void rawClose() {
        System.out.println("+-------——————+");
    }
}
