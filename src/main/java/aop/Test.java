package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Created by adimn on 2018/11/22.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:beans.xml");
//        ApplicationContext  ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        BraveKnight br = (BraveKnight) ac.getBean("knight");
        br.saying();
    }
}
