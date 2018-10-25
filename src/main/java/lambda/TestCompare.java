package lambda;

import java.util.*;

/**
 * Created by adimn on 2018/10/25.
 */
public class TestCompare {
    public static void main(String[] args) {
        Random random = new Random();
        List heros = new ArrayList<HeroBean>();
        for (int i = 0; i < 50; i++) {
            HeroBean hero = new HeroBean("h" + i, random.nextInt(300), random.nextInt(100));
            heros.add(hero);
        }
        show(heros);
        System.out.println("------------------------------");
        Collections.sort(heros,( h1, h2)-> ((HeroBean)h1).damage > ((HeroBean) h2).damage?1:-1);
        show(heros);

    }
    public static void show(List<HeroBean> heros){
        for(HeroBean h:heros){
            System.out.println(h.toString());
        }
    }

}
