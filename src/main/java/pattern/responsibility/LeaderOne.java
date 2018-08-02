package pattern.responsibility;

/**
 * Created by adimn on 2018/8/2.
 */
public class LeaderOne implements Handler {

    Handler next;
    String name;

    public LeaderOne(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void process(int message) {
        if(message>0 && message<10){
            System.out.println(name+" deal it !");
        }else if(next!=null) {
            next.process(message);

        }
    }

    @Override
    public void setNext(Handler h1) {
        this.next = h1;
    }
}
