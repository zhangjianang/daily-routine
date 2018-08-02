package pattern.responsibility;

/**
 * Created by adimn on 2018/8/2.
 */
public class LeaderThree implements Handler {
    Handler next;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LeaderThree(String name) {
        this.name = name;
    }


    @Override
    public void process(int message) {
        if(message>100 ){
            System.out.println(name+" deal it !");
        }else if(next!=null) {
            next.process(message);
        }
    }

    @Override
    public void setNext(Handler h1) {
        this.next=h1;
    }

    public static void main(String[] args) {
        Handler h1 = new LeaderOne("xiaotoutou");
        Handler h2 = new LeaderTwo("ertoutou");
        Handler h3 = new LeaderThree("santoutou");
        h1.setNext(h2);
        h2.setNext(h3);
        for(int i=0;i<102;i++){
            h1.process(i);
        }
    }
}
