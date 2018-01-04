package Observer;

/**
 * Created by adimn on 2017/12/25.
 */
public class AngUser implements IObserver {
    private String name ;
    public AngUser(String name){
        this.name = name;
    }

    public void update(String data) {
        System.out.println(name + " update info is :"+data);
    }
}
