package pattern.birdge;

/**
 * Created by adimn on 2018/8/9.
 */
public class Display {
    private DisplayImpl disImpl;

    public Display(DisplayImpl disImpl) {
        this.disImpl = disImpl;
    }

    public void open(){
        disImpl.rawOpen();
    }
    public void print(){
        disImpl.rawPrint();
    }
    public void close(){
        disImpl.rawClose();
    }
    public void display(){
        open();
        print();
        close();
    }


    public static void main(String[] args) {
        DisplayImpl strImpl =  new StringDisplayImpl("Chinese");
        Display d1 = new Display(strImpl);
        Display d2 = new Display(new StringDisplayImpl("English"));
        CountDisplay ct1 = new CountDisplay(strImpl);
        d1.display();
        d2.display();
        ct1.multiDisplay(4);


    }
}
