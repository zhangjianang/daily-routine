package pattern.birdge;

/**
 * Created by adimn on 2018/8/9.
 */
public class TextDispalyImpl extends DisplayImpl {
    private String name;

    public TextDispalyImpl(String name) {
        this.name = name;
    }

    @Override
    public void rawOpen() {
        System.out.println("+***********************+");
    }

    @Override
    public void rawPrint() {
        System.out.println(name + " text print");
    }

    @Override
    public void rawClose() {
        System.out.println("+***********************+");
    }
}
