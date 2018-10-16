package pattern.decorator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by adimn on 2018/10/15.
 */

@Component
@Scope("prototype")

public class UpdownBorder extends Border {

    private Display display;

    private Character udchar;

    public UpdownBorder() {

    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Character getUdchar() {
        return udchar;
    }

    public void setChar(Character udchar) {
        this.udchar = udchar;
    }

    @Override
    protected Integer getColumns() {
        return display.getColumns();
    }

    @Override
    protected Integer getRows() {
        return 1 +  display.getRows() + 1;
    }

    @Override
    protected String getRowText(int lnum) {
        if(lnum == 0 || lnum == getRows()-1){
            return genUpDown(getColumns());
        }else {
            return display.getRowText(lnum-1);
        }
    }

    private String genUpDown(int n){
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < n ; i++){
            sb.append(udchar+"");
        }
        return  sb.toString();
    }
}
