package lambda;

/**
 * Created by adimn on 2018/10/25.
 */
public class HeroBean {

    public String name;
    public float hp;

    public int damage;

    public HeroBean(){

    }

    public HeroBean(String name) {
        this.name =name;

    }

    //初始化name,hp,damage的构造方法
    public HeroBean(String name,float hp, int damage) {
        this.name =name;
        this.hp = hp;
        this.damage = damage;
    }
    @Override
    public String toString() {
        return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]\r\n";
    }

}
