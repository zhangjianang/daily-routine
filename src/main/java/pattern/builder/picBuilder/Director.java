package pattern.builder.picBuilder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by adimn on 2018/10/17.
 */
@Component
public class Director {
    private Builder builder;

    public Builder getBuilder() {
        return builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public Director(){}

    public Director makeTitle(String title){
        builder.makeTitle(title);
        return this;
    }

    public Director makeString(String str){
        builder.makeString(str);
        return this;
    }

    public Director makeItems(String[] items){
        builder.makeItems(items);
        return this;
    }

    public Builder construct(){
        return builder;
    };


    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Director d = ac.getBean(Director.class);
        TextBuilder b = ac.getBean(TextBuilder.class);
        d.setBuilder(b);

        d.makeTitle("page1")
                .makeString("早上")
                .makeItems(new String[]{"嗨","早上好"})
                .construct();
        b.getResult();

    }

}
