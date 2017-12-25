package ClassLoder;

/**
 * Created by adimn on 2017/10/24.
 */
public class ClassLoder  {
    static int a;
    static {
        a = 0;
        System.out.println("parent init");
    }
}


class Son extends ClassLoder{
    static int b;
    static {
        b = 1;
        System.out.println("son init");
    }
}