package pattern.compositeVisitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by adimn on 2018/8/7.
 */
public class Folder extends Entry {
    private List flist;
    private String name;

    public List getFlist() {
        return flist;
    }

    public void setFlist(List flist) {
        this.flist = flist;
    }

    public Folder(String name) {
        this.name = name;
        flist = new ArrayList();
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getSize() {
        Integer size = 0;
        for(Object per:flist){
            size += ((Entry)per).getSize();
        }
        return size;
    }

    public Entry add(Entry data) throws Exception {
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
        Entry rootFolder = new Folder("rootFolder");
        Entry usrFolder = new Folder("usrFolder");
        Entry varFolder = new Folder("varFolder");
        Entry viFile = new File("vi",10);
        Entry profileFile = new File("profile",10);

        rootFolder.add(usrFolder);
        rootFolder.add(varFolder);
        usrFolder.add(viFile);
        usrFolder.add(profileFile);

//        rootFolder.getList();

        ListVisitor lv = new ListVisitor();
        rootFolder.accept(lv);

        SizeVisitor sv  = new SizeVisitor();
        rootFolder.accept(sv);
    }


    public void accept(Visitor v) {
        v.visit(this);
    }
}
