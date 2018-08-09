package pattern.birdge;

/**
 * Created by adimn on 2018/8/9.
 */
public class CountDisplay extends Display {

    public CountDisplay(DisplayImpl disImpl) {
        super(disImpl);
    }

    public void multiDisplay(int num){
        for(int i=0; i < num; i++){
            display();
        }
    }

}
