package pattern.decorator;


import org.springframework.stereotype.Component;

/**
 * Created by adimn on 2018/10/15.
 */

@Component
public class SideBorder extends Border {

    private Display display;

    private Character ch;

    public SideBorder() {
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Character getCh() {
        return ch;
    }

    public void setChar(Character ch) {
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
