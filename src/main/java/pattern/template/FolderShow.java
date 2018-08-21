package pattern.template;

/**
 * Created by adimn on 2018/8/21.
 */
class FolderShow extends AbstractShow {
    private String name;

    public FolderShow(String name) {
        this.name = name;
    }

    @Override
    public void open() {
        System.out.println("***********************");
    }

    @Override
    public void print() {
        System.out.println("*"+name+"*");
    }

    @Override
    public void close() {
        System.out.println("***********************");
    }

    public static void main(String[] args) {
        AbstractShow a1 = new CharShow("i am a char");
        AbstractShow a2 = new FolderShow("i am a folder");
        a1.display();
        a2.display();
    }
}
