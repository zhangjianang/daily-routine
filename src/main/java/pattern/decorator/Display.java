package pattern.decorator;

/**
 * Created by adimn on 2018/10/13.
 */
public abstract class Display {
    protected abstract Integer getColumns();
    protected abstract Integer getRows();
    protected abstract String getRowText(int lnum);
    public  void show(){
        for(int i=0;i<getRows();i++){
            System.out.println(getRowText(i));
        }
    }
}
