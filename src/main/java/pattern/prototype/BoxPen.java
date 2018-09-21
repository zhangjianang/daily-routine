package pattern.prototype;

/**
 * Created by adimn on 2018/9/21.
 */
public class BoxPen extends Product {
    private Character ch;

    public BoxPen(Character ch){
        this.ch = ch;
    }

    @Override
    public void use(String s) {
        for(int i=0;i<s.length()+10;i++){
            System.out.print(ch);
        }
        System.out.println();
        System.out.println(ch+"    "+s+"    "+ch);
        for(int i=0;i<s.length()+10;i++){
            System.out.print(ch);
        }
        System.out.println();
    }

//    @Override
//    public Product createClone() {
//        Product p = null;
//        try {
//            p = (Product) clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        return p;
//    }
}
