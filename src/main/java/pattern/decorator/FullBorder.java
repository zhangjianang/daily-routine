package pattern.decorator;

import jdk.nashorn.internal.objects.annotations.Constructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by adimn on 2018/10/15.
 */
@Component
public class FullBorder extends Border {

    private Display display;

    private static final  Character SIDE_CHR = '+';

    public FullBorder() {
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    @Override
    public void setChar(Character ch) {

    }

    protected Integer getColumns() {
        return 1 + display.getColumns() + 1;
    }

    protected Integer getRows() {
        return display.getRows() + 2;
    }

    protected String getRowText(int lnum) {

        if(lnum ==0 || lnum == getRows()-1){
            return genHead(display.getColumns());
        }else  {
//            为什么减一，采用 的是递归调用， 调取包装类 下一层数据。 ！！！！
            return SIDE_CHR +display.getRowText(lnum-1)+SIDE_CHR;
        }
    }

    private  String genHead(int n){
        StringBuilder sb = new StringBuilder(SIDE_CHR + "");
        for(int i=0; i <n ; i++){
            sb.append('-');
        }
        sb.append(SIDE_CHR);
        return sb.toString();
    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        StringDisplay d1 = ac.getBean(StringDisplay.class);
        d1.setStr("we are");

//        Border d2 = ac.getBean(SideBorder.class);
//        d2.setDisplay(d1);
//        d2.setChar('*');
//        d2.show();

        Border d3 = ac.getBean(FullBorder.class);
        d3.setDisplay(d1);
        d3.show();

        Border d4 = ac.getBean(SideBorder.class);
        d4.setDisplay(d3);
        d4.setChar('!');
        d4.show();

//        Display d5 = new FullBorder(d4);
//        d5.show();
//
//        System.out.println();
//
//        Display d6 = new FullBorder(d5);
//        d6.show();
//
//        Display d7  =  new UpdownBorder(d6,'#');
//        d7.show();
//
//        System.out.println();
//
//        Display d8 = new FullBorder(d7);
//        d8.show();
    }
}
