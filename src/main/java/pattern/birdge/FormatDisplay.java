package pattern.birdge;

/**
 * Created by adimn on 2018/8/9.
 */
public class FormatDisplay  extends Display{

    public FormatDisplay(DisplayImpl disImpl) {
        super(disImpl);
    }
    public void display(int n){
        open();
        for (int i=0;i<n;i++){
            print();
        }
        close();
    }

    public void formatDisplay(int n){
        for(int i=0;i<n;i++){
            display(i);
        }

    }

    public static void main(String[] args) {
        FormatDisplay fd = new FormatDisplay(new FormatDisplayImpl("*"));
        fd.formatDisplay(10);
    }
}
