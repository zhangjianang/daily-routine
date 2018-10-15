package pattern.decorator;

/**
 * Created by adimn on 2018/10/15.
 */
public class FullBorder extends Border {

    private static final  Character SIDE_CHR = '+';

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
            return genHead(display.getColumns());
        }else  {
//            为什么减一，采用 的是递归调用， 调取包装类 下一层数据。 ！！！！
            return SIDE_CHR +display.getRowText(lnum-1)+SIDE_CHR;
        }
    }

    private  String genHead(int n){
        StringBuilder sb = new StringBuilder(SIDE_CHR + "");
        for(int i=0; i <n ; i++){
            sb.append('-');
        }
        sb.append(SIDE_CHR);
        return sb.toString();
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

        System.out.println();

        Display d6 = new FullBorder(d5);
        d6.show();

        Display d7  =  new UpdownBorder(d6,'#');
        d7.show();

        System.out.println();

        Display d8 = new FullBorder(d7);
        d8.show();
    }
}
