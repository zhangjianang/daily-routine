package lambda;

import org.springframework.stereotype.Component;

/**
 * Created by adimn on 2018/10/25.
 */

public class Hero implements Comparable<Hero>{
    public String name;
    public float hp;

    public int damage;

    public Hero(){

    }

    public Hero(String name) {
        this.name =name;

    }

    //初始化name,hp,damage的构造方法
    public Hero(String name,float hp, int damage) {
        this.name =name;
        this.hp = hp;
        this.damage = damage;
    }

    @Override
    public int compareTo(Hero anotherHero) {
        if(damage<anotherHero.damage)
            return 1;
        else
            return -1;
    }

    //回血
    public void recover(){
        synchronized (this) {
            hp = hp + 1;
        }
    }

    //掉血
    public void hurt(){
        synchronized (this) {
            hp = hp - 1;
        }
    }

    @Override
    public String toString() {
        return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]\r\n";
    }

    public void attackHero(Hero h) {
        try {
            //为了表示攻击需要时间，每次攻击暂停1000毫秒
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        h.hp-=damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);

        if(h.isDead())
            System.out.println(h.name +"死了！");
    }

    public boolean isDead() {
        return 0>=hp?true:false;
    }

    public static Boolean testHero(Hero hero){
        return  hero.hp>100 && hero.damage <50 ;
    }


    public void bodong(){
        int num =3;
        while(num-- >0){
            System.out.println(this.name +" 发波 "+ num);
        }
        try {
            System.out.println(this.name +" 正在充能！");
            Thread.sleep(5000);
            num = 3;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}