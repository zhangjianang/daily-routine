package pattern.compositeVisitor;

import java.util.ArrayList;
import java.util.Iterator;
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

    public List getFoundFiles(){
        return this.files;
    }

    @Override
    public void visit(File file) {
        if(file.getName().endsWith(surffix)){
            files.add(file);
        }
    }

    @Override
    public void visit(Folder f) {
        if(f.getName().endsWith(surffix)){
            files.add(f);
        }
        for(Object per : f.getFlist()){
            ((Entry) per).accept(this);
        }
    }

    public static void main(String[] args) throws Exception {
        Entry rootdir  = new Folder("root");
        Entry bindir  = new Folder("bin");
        Entry tmpdir  = new Folder("tmp");
        Entry usrdir  = new Folder("usr");
        rootdir.add(bindir);
        rootdir.add(tmpdir);
        rootdir.add(usrdir);
        bindir.add(new File("vi",1000));
        bindir.add(new File("latex",2000));

        Entry yuki  = new Folder("yuki");
        Entry hanako  = new Folder("hanako");
        Entry tomura  = new Folder("tomura");

        usrdir.add(yuki);
        usrdir.add(hanako);
        usrdir.add(tomura);

        yuki.add(new File("diary.html",100));
        yuki.add(new File("composite.java",200));
        hanako.add(new File("memo.tex",300));
        hanako.add(new File("index.html",350));
        tomura.add(new File("game.doc",400));
        tomura.add(new File("junk.mail",500));

        FileFindVisitor ffv = new FileFindVisitor(".html");
        rootdir.accept(ffv);
        System.out.println("html files are:");

        List foundFiles = ffv.getFoundFiles();
        for(Object per:foundFiles){
            ((Entry)per).getList();
        }

    }


}
