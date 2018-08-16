package pattern.strategy;

/**
 * Created by adimn on 2018/8/14.
 */
public class Player {
    private String name;
    private Strategy strategy;

    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public Hand nextHand(){

        return strategy.nextHand();
    }

    public void win(){
        strategy.study(true);
    }

    public void notWin(){
        strategy.study(false);
    }

    public static void main(String[] args) {
        Player p1 = new Player("ang",new ProbStrategy());
        Player p2 = new Player("potter",new WinStrategy());

        int p1winNum = 0;
        int p2winNum = 0;

        for( int i = 0; i < 100; i++ ){
            Hand h1 = p1.nextHand();
            Hand h2 = p2.nextHand();
            int res = h1.fight(h2);
            if(res==1){
                p1winNum++;
                p1.win();
                p2.notWin();
            }else {
                p2winNum++;
                p1.notWin();
                p2.win();
            }
        }
        System.out.println("p1 win num : " + p1winNum);
        System.out.println("p2 win num : " + p2winNum);
    }
}
