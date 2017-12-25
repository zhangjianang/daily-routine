package Observer;

/**
 * Created by adimn on 2017/12/25.
 */
public class AngUser implements IObserver {

    public void update(String data) {
        System.out.println("update info is :"+data);
    }
}
