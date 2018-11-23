package pattern.compositeVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adimn on 2018/11/23.
 */
public class FileFindVisitor extends Visitor {

    private String surffix;
    private List files;

    public FileFindVisitor(String suffix){
        this.surffix = suffix;
        this.files = new ArrayList();
    }

    public Iterable<Entry> getFoundFiles(){
        return this.files;
    }

    @Override
    public void visit(File f) {
        if(f.getName().endsWith(".html")){
            files.add(f);
        }
    }

    @Override
    public void visit(Folder f) {
//        for()
    }
}
