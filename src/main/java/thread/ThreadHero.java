package thread;

/**
 * Created by adimn on 2018/11/1.
 */
public class ThreadHero {

    public String name;
    public float hp;


    public ThreadHero(String name, float hp) {
        this.name = name;
        this.hp = hp;
    }

    //回血
    public void recover(){
        synchronized (this) {

            if(hp == 1){
                 hp ++;
                this.notifyAll();
                System.out.println(Thread.currentThread().getName() + " 恢复一点，血量为 ：" + hp);
            } else if(hp == 200){
                System.out.println(Thread.currentThread().getName()+ "等待减血，血量为 ：" + hp);
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                hp ++;
                System.out.println(Thread.currentThread().getName() + " 恢复一点，血量为 ：" + hp);
            }



        }
    }

    //掉血
    public void hurt(){
        synchronized (this) {

            if(!isDead()) {
                if(hp < 2){
                    System.out.println(Thread.currentThread().getName()+ "等待回血，血量为 ：" + hp);
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                } else if(hp ==200){
                    hp = hp - 1;
                    this.notifyAll();
                    System.out.println(Thread.currentThread().getName()+ "减少一点，血量为 ：" + hp);
                }else {
                    hp = hp - 1;
                    System.out.println(Thread.currentThread().getName()+ "减少一点，血量为 ：" + hp);
                }

            }else {
                System.out.println( name + " dead !");
            }
        }
    }

    public boolean isDead(){
        return this.hp == 0 ? true:false;
    }
}
