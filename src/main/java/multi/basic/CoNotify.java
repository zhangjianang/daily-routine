package multi.basic;

/**
 * Created by adimn on 2017/12/29.
 */
public class CoNotify {
    public static void main(String[] args) {
        Pepole p  = new Pepole();
        Creator c = new Creator(p);
        Display d = new Display(p);
        Thread tc = new Thread(c);
        Thread td = new Thread(d);
        tc.start();
        td.start();
    }
}


class Creator implements Runnable{
    private Pepole p;
    public Creator(Pepole p){
        this.p = p ;
    }

    public void run() {
        create();
    }

    private void create(){
        int i = 0;
        while(i<40){

            synchronized (p) {
                if(p.show){
                    try {
                        p.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (i % 2 == 0) {
                    p.name = "小翠";
                    p.gender = "nv";
                } else {
                    p.name = "大强";
                    p.gender = "男";
                }
                p.show = true;
                p.notify();
            }
            i++;

        }
    }
}

class Display implements Runnable{
    private Pepole p;
    public Display(Pepole p){
        this.p = p;
    }
    public void run() {
        display();
    }

    private void display(){
        int i = 0;
        while(i<40){

            synchronized (p) {
                if(!p.show){
                    try {
                        p.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(p.name + " --- " + p.gender);
                p.show = false;
                p.notify();
            }
            i++;
        }
    }
}


class Pepole{
    public String name;
    public String gender;
    public boolean show;

    public Pepole(){
        this.show = false;
    }
}