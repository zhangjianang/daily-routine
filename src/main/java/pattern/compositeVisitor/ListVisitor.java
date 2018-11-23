package pattern.compositeVisitor;

/**
 * Created by adimn on 2018/11/23.
 */
public class ListVisitor extends Visitor {

    @Override
    public void visit(File f) {
        System.out.println(f.getName() + ", size is "+f.getSize());
    }

    @Override
    public void visit(Folder f) {
        for(Object entry:f.getFlist()){
            ( (Entry) entry ).accept(this);
        }
        System.out.println(f.getName() + ", size is "+f.getSize());
    }


    public static void main(String[] args) {
        String curRelation = "M3/(sum(day_diff(s1-s2))+avg(s2  + s3 ))";
        String[] split = curRelation.split("\\-|\\+|\\*|\\/|\\(|\\)");
        for(int i=0;i<split.length;i++){
            System.out.println(i+" is : "+split[i]);
        }
    }

}
