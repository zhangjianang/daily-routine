package Observer;

/**
 * Created by adimn on 2017/12/25.
 */
public interface ISubject {
    public void addObj(IObserver Obj);
    public void rmoveObj(IObserver Obj);
    public void mynotify(String info);
}
