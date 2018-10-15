package pattern.decorator;

/**
 * Created by adimn on 2018/10/15.
 */
public abstract class Border extends Display {

    public Display display;

    public Border(Display d){
        this.display = d;
    }
}
