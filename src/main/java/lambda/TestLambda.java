package lambda;

import pattern.strategy.Hand;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by adimn on 2018/10/25.
 */
public class TestLambda {

    public static void main(String[] args) {
        Random random = new Random();
        List heros = new ArrayList<Hero>();
        for(int i =0 ; i<50 ; i++){
            Hero hero = new Hero("h"+i,random.nextInt(300),random.nextInt(100));
            heros.add(hero);
        }
//        filter(heros);
        anonymousClassFilter(heros);

//        lambda 表达式就是实现接口。单数去掉输入参数 类型，和返回参数类型，因为在接口中已经制定输入参数类型，和返回参数类型了。
//       括号在只有一个参数时候，也可以省略不用。
//        lambdaFilter(heros, (h )-> h.hp > 100 && h.damage< 50);
//        lambdaFilter(heros,TestLambda::staticHero );
        lambdaFilter(heros,Hero::testHero );
    }

    public static void filter(List<Hero> heros){
        for(Hero hero:heros) {
            if (hero.hp > 100 && hero.damage < 50) {
                System.out.println(hero.toString());
            }
        }
    }

    public static void anonymousClassFilter(List<Hero> heros){
        HeroChecker heroChecker = new HeroChecker() {
            @Override
            public Boolean check(Hero hero) {
                if(hero.hp>100 && hero.damage<50){
                    return true;
                }else {
                    return false;
                }
            }
        };
        for(Hero hero:heros){
            if(heroChecker.check(hero)){
                System.out.println(hero.toString());
            }
        }
    }

    public static void lambdaFilter(List<Hero> heros,HeroChecker hc){

        for(Hero hero:heros){
            if(hc.check(hero)){
                System.out.println(hero.toString());
            }
        }
    }

//    lambda 表达式引用静态函数。
    public static Boolean staticHero(Hero h){
        return h.hp>100 && h.damage<50;
    }

}
