package pattern.decorator;

/**
 * Created by adimn on 2018/10/15.
 */
public class UpdownBorder extends Border {


    private Character udchar;

    public UpdownBorder(Display d,Character udchar) {
        super(d);
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
