package pattern.command;

import javassist.ClassPath;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by adimn on 2018/10/25.
 */
@Component
public class Invoker {

    private Command command;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void invoke(){
        this.command.execute();
    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Recevior re = ac.getBean(Recevior.class);
        Command cm = ac.getBean(ConcrteCommand.class);
        cm.setRecevior(re);
        Invoker invoker = ac.getBean(Invoker.class);
        invoker.setCommand(cm);
        invoker.invoke();
    }
}
