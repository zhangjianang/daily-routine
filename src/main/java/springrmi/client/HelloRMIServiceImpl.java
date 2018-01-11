package springrmi.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by adimn on 2018/1/11.
 */
public class HelloRMIServiceImpl implements HelloRMIService {
    @Override
    public int getAdd(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {

        new ClassPathXmlApplicationContext("applicationContext.xml");

    }
}
