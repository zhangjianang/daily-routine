package arefactor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by adimn on 2018/1/8.
 */
public class MyRefactor {
    private CountDownLatch cd = new CountDownLatch(3);
    private static int i = 0;
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class c = Class.forName("arefactor.MyRefactor");
        Constructor[] c1 = c.getConstructors();
        for(Constructor cc : c1) {
            System.out.println(cc);
        }

        Constructor c3 = c.getConstructor();
        Object o = c3.newInstance();
        System.out.println(o.toString());

        //要有默认构造函数，并且有public方法，可以不用构造函数，
        Object o1 = c.newInstance();
        System.out.println(o1.toString());


        Constructor[] call = c.getDeclaredConstructors();
        for(Constructor cper : call){
            System.out.println(cper);
        }
    }

    public MyRefactor(){

    }

    public MyRefactor(String name){

    }

    private MyRefactor(String name,int age){

    }

    public void myGetClass() throws ClassNotFoundException {
//        获取一个类的class文件的三种方式
//        1、对象获取 2、类名获取 3、class静态方法获取
        MyRefactor m = new MyRefactor();
        Class cm  = m.getClass();
        System.out.println(cm.getName());

        Class c2 = MyRefactor.class;
        System.out.println(c2);
        System.out.println(cm.equals(c2));
        System.out.println(cm == c2);




        //采用包名+类名方式
//        Class c3 = Class.forName("refactor.MyRefactor");
//        System.out.println(c3);
    }

    public String toString(){
        return "we are champion";
    }

    public static  void checkThread(){
        for(; i<10 ;i ++){
            new Thread(){
                public void run(){
                    System.out.println(Thread.currentThread().getName()+"start");
                    if (i == 3){
                        try {
                            Thread.sleep(3000);
                            System.out.println(Thread.currentThread().getName()+"end");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }
        System.out.println("main finish");
    }
}
