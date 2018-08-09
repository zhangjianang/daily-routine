package pattern.birdge;

/**
 * Created by adimn on 2018/8/9.
 */
public class FormatDisplayImpl extends DisplayImpl  {
    private String name;
    public FormatDisplayImpl(String name) {
        this.name = name;
    }

    @Override
    public void rawOpen() {
        System.out.print("<");
    }

    @Override
    public void rawPrint() {
        System.out.print(name);
    }

    @Override
    public void rawClose() {
        System.out.print(">\n");
    }
}
