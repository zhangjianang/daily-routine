package Observer;

import java.util.ArrayList;

/**
 * Created by adimn on 2017/12/25.
 */
public class ConcSubject implements ISubject{
     ArrayList<IObserver> myobj = new ArrayList<IObserver>();

    public void addObj(IObserver obj) {
        myobj.add(obj);
    }

    public void rmoveObj(IObserver obj) {
        myobj.remove(obj);
    }

    public void mynotify(String info) {
        for(IObserver per : myobj){
            per.update("change info"+info);
        }
    }

    public static void main(String[] args) {
        AngUser a =  new AngUser();
        ConcSubject c = new ConcSubject();
        c.addObj(a);
        c.mynotify("you change");
    }
}
