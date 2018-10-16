package pattern.decorator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by adimn on 2018/10/15.
 */

public abstract class Border extends Display {

//    public Display display;
//
//    public Border(Display d){
//        this.display = d;
//    }

    public abstract void setDisplay(Display d);
    public abstract void setChar(Character ch);
}
