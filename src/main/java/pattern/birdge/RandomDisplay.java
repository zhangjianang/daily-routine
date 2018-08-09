package pattern.birdge;

import java.util.Random;

/**
 * Created by adimn on 2018/8/9.
 */
public class RandomDisplay extends Display {
    public RandomDisplay(DisplayImpl disImpl) {
        super(disImpl);
    }

    public void randomDisplay(int n){
        int num = new Random().nextInt(n);
        System.out.println(num);
        for(int i = 0;i < num;i++){
            display();
        }
    }

    public static void main(String[] args) {
        DisplayImpl str = new StringDisplayImpl("harry potter");
        RandomDisplay d = new RandomDisplay(str);
        d.randomDisplay(10);

        RandomDisplay d2 = new RandomDisplay(new TextDispalyImpl("the history of text"));
        d2.randomDisplay(10);
    }
}
