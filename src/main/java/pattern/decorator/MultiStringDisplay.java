package pattern.decorator;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by adimn on 2018/10/15.
 */
public class MultiStringDisplay extends Display {
    private List<String> strs;

    public MultiStringDisplay(){
        strs = new LinkedList<>();
    }

    public void add(String str){
        strs.add(str);
    }

    @Override
    protected Integer getColumns() {
        int max = 0;
        for(String per:strs){
            if(per.length() > max){
                max = per.length();
            }
        }
        return max;
    }

    @Override
    protected Integer getRows() {
        return strs.size();
    }

    @Override
    protected String getRowText(int lnum) {
        Integer num = getColumns();
        if(lnum < strs.size() && lnum >= 0 ){
            StringBuilder sb = new StringBuilder( strs.get(lnum) );
            for(int j=sb.length();j<num;j++){
                sb.append(" ");
            }
            return sb.toString();
        }
        return null;
    }

    public static void main(String[] args) {
        MultiStringDisplay d1 = new MultiStringDisplay();
        d1.add("i am first");
        d1.add("i am the second");

        Display d2 = new UpdownBorder(d1,'#');

        d2.show();

        Display d3 = new FullBorder(d2);
        d3.show();

        Display d4  = new SideBorder(d3,'@');

        d4.show();

        Display d5 = new FullBorder(d4);

        d5.show();
    }
}
