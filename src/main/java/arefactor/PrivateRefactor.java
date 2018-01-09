package arefactor;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by adimn on 2018/1/8.
 */
public class PrivateRefactor {

    private String name = "ang";

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class c = Class.forName("arefactor.PrivateRefactor");
        Object o = c.newInstance();
        Field f =  c.getDeclaredField("name");
        f.setAccessible(true);
        f.set(o,"we");
        System.out.println(f);

        //调用带参数方法
        Method m = c.getMethod("getName", String.class, Integer.class);
        m.invoke(o,"age",18);


        //类型擦除  class 中 没有类型检查
        ArrayList<String> l  = new ArrayList<String>();
        l.add("a");
        Class  lc = l.getClass();
        Method ml = lc.getMethod("add", Object.class);
        ml.invoke(l,19);
        ml.invoke(l,20);
        System.out.println(l);
    }

    public PrivateRefactor(){
    }

    public void getName(String name,Integer age){
        System.out.println("name is "+ name +", age is "+age );
    }
}
