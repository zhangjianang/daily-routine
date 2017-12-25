package multi;

/**
 * Created by adimn on 2017/10/23.
 */
public class Multi extends Thread{
    private  Account acc ;

    public Multi(Account a, String name){
        super(name);
        acc = a;
    }

    public void run(){
        try {
            sleep(1);
            synchronized (acc) {
                acc.draw(80);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  static void main(String[] args) {
        Account a = new Account(100);
        Multi m1 = new Multi(a,"现场1");
        Multi m2 = new Multi(a,"现场2");

        m1.start();
        m2.start();
        System.out.println(Account.class);
    }
}

class Account{
    private int account;

    public Account(int num){
        this.account = num;
    }
    public  void  draw(int drawNum){

            if (account > drawNum) {
                System.out.println(Thread.currentThread().getName() + " 取出 " + drawNum);
                account -= drawNum;
                System.out.println(Thread.currentThread().getName() + " 剩余 " + account);
            }

    }
}
