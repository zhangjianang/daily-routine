package pattern.compositeVisitor;

/**
 * Created by ang on 2018/11/24.
 */
public class SizeVisitor extends Visitor {
    private  int size;
    public SizeVisitor(){
        this.size = 0;
    }

    public Integer getSize(){
        return size;
    }

    @Override
    public void visit(File f) {
        this.size += f.getSize();
//        System.out.println(f.getName()+" size is "+this.size);
    }

    @Override
    public void visit(Folder f) {
        for(Object per:f.getFlist()){
            ((Entry)per).accept(this);
        }
//        System.out.println(f.getName()+" size is "+this.size);
    }



}
