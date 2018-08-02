package pattern.responsibility;

/**
 * Created by adimn on 2018/8/2.
 */
public class LeaderTwo implements Handler {
    Handler next;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public LeaderTwo(String name) {
        this.name = name;
    }

    @Override
    public void process(int message) {
        if(message>10 && message<100){
            System.out.println(name+" deal it !");
        }else if(next !=null) {
            next.process(message);
        }
    }

    @Override
    public void setNext(Handler h1) {
        this.next = h1;
    }
}
