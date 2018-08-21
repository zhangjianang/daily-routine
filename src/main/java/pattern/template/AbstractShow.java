package pattern.template;

/**
 * Created by adimn on 2018/8/21.
 */
public abstract class AbstractShow {
    public abstract void open();
    public abstract void print();
    public abstract void close();

    public void display(){
        open();
        for(int i = 0; i < 5; i++){
            print();
        }
        close();
    }
}
