package pattern.decorator;

import org.springframework.stereotype.Component;

/**
 * Created by adimn on 2018/10/13.
 */

@Component
public class StringDisplay extends Display{

    private String str;

    public StringDisplay(){
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    protected Integer getColumns() {
        if(str != null) {
            return str.length();
        }
        return  0;
    }

    protected Integer getRows() {
        if(str != null){
            return 1;
        }
        return 0;
    }

    protected String getRowText(int lnum) {
        return str;
    }
}
