package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static lambda.TestLambda.lambdaFilter;

/** 测试聚合操作
 * Created by adimn on 2018/10/26.
 */

public class TestAggregate {
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(500), r.nextInt(100)));
        }

        System.out.println("初始化后的集合：");
        System.out.println(heros);
        System.out.println("查询条件：hp>100 && damage<50");
        System.out.println("通过传统操作方式找出满足条件的数据：");
        lambdaFilter(heros,h->h.hp>100 && h.damage<50);

        System.out.println("管道的概念，collocation机会中才有的。");

//        heros.stream().forEach(hero -> System.out.println(hero.toString()));
        heros.stream().filter(hero -> hero.hp>100&& hero.damage<50).forEach(hero -> System.out.println(hero.toString()));
    }
}
