package pattern.decorator;

import javafx.geometry.Side;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by adimn on 2018/10/15.
 */
@Component("iocStringDisplay")
public class IocStringDisplay extends Display {

    private String str;

    public IocStringDisplay(){

    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    protected Integer getColumns() {
        if(str != null) {
            return str.length();
        }
        return  0;
    }

    @Override
    protected Integer getRows() {
        if(str != null) {
            return 1;
        }
        return 0;
    }

    @Override
    protected String getRowText(int lnum) {
        return str;
    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        IocStringDisplay iocbean = ac.getBean(IocStringDisplay.class);

        iocbean.setStr("i am ioc");
        iocbean.show();

        Border sideBorder = ac.getBean(SideBorder.class);
        sideBorder.setChar('|');
        sideBorder.setDisplay(iocbean);
        sideBorder.show();

        Border f1 = ac.getBean(FullBorder.class);
        f1.setDisplay(sideBorder);
        f1.show();
    }
}
