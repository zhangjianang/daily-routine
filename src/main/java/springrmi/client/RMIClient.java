package springrmi.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by adimn on 2018/1/11.
 */
public class RMIClient {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloRMIService helloRMIService =  applicationContext.getBean("myRMIClient",HelloRMIService.class);
        System.out.println(helloRMIService.getAdd(3, 4));
    }
}
