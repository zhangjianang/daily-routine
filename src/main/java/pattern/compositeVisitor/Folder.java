package pattern.compositeVisitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by adimn on 2018/8/7.
 */
public class Folder extends Entry {
    private List flist;

    public List getFlist() {
        return flist;
    }

    public void setFlist(List flist) {
        this.flist = flist;
    }

    public Folder(String name, Integer size) {
        super(name, size);
        flist = new ArrayList();
    }

    public Entry add(Entry data) throws Exception {
        Integer cur = getSize();
        cur += data.getSize();
        setSize(cur);
        flist.add(data);
        return this;
    }

    @Override
    public void getList() {
        Iterator it = flist.iterator();
        System.out.println("fname:"+getName()+";fsize:"+getSize());
        while (it.hasNext()){
            Entry next = (Entry) it.next();
            next.getList();
        }
    }


    public static void main(String[] args) throws Exception {
        Entry rootFolder = new Folder("rootFolder",1);
        Entry usrFolder = new Folder("usrFolder",1);
        Entry varFolder = new Folder("varFolder",1);
        Entry viFile = new File("vi",10);
        Entry profileFile = new File("profile",10);

        rootFolder.add(usrFolder);
        rootFolder.add(varFolder);
        usrFolder.add(viFile);
        usrFolder.add(profileFile);

//        rootFolder.getList();

        ListVisitor lv = new ListVisitor();
        rootFolder.accept(lv);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
