package pattern.prototype;

/**
 * Created by adimn on 2018/9/21.
 */
public class UnderLinePen extends Product{
    private Character ch;

    public UnderLinePen(Character ch){
        this.ch = ch;
    }

    @Override
    public void use(String s) {
        System.out.println(s);
        for(int i=0; i < s.length(); i++){
            System.out.print(ch);
        }
        System.out.println();
    }

}
