package pattern.decorator;

/**
 * Created by adimn on 2018/10/15.
 */
public class SideBorder extends Border {

    private Character ch;

    public SideBorder(Display d,Character ch) {
        super(d);
        this.ch = ch;
    }

    protected Integer getColumns() {
        return 1 + display.getColumns() + 1 ;
    }

    protected Integer getRows() {
        return display.getRows();
    }

    protected String getRowText(int lnum) {
        return ch + display.getRowText(lnum) + ch;
    }
}
