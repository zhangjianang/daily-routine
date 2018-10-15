package pattern.decorator;

/**
 * Created by adimn on 2018/10/15.
 */
public class FullBorder extends Border {

    public FullBorder(Display d) {
        super(d);
    }

    protected Integer getColumns() {
        return 1 + display.getColumns() + 1;
    }

    protected Integer getRows() {
        return display.getRows() + 2;
    }

    protected String getRowText(int lnum) {

        if(lnum ==0 || lnum == getRows()-1){
            StringBuilder sb = new StringBuilder("/");
            for(int i=0;i<display.getColumns();i++){
                sb.append('-');
            }
            sb.append('/');
            return sb.toString();
        }else {
            return '/' +display.getRowText(lnum)+'/';
        }
    }

    public static void main(String[] args) {
        Display d1 = new StringDisplay("we are");
        Display d2 = new SideBorder(d1,'*');
        d1.show();
        d2.show();

        Display d3 = new FullBorder(d2);
        d3.show();
        Display d4 = new SideBorder(d3,'!');
        d4.show();

        Display d5 = new FullBorder(d4);
        d5.show();
    }
}
