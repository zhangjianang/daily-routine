package pattern.builder.picBuilder;

import org.springframework.stereotype.Component;

/**
 * Created by adimn on 2018/10/17.
 */
@Component
public class TextBuilder extends Builder {
    private String str;
    private String title;
    private String[] items;


    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public TextBuilder(){}

    @Override
    public void makeTitle(String title) {
        this.title = title;
    }

    @Override
    public void makeString(String str) {
        this.str = str ;
    }

    @Override
    public void makeItems(String[] items) {
        this.items = items;
    }

    @Override
    public void close() {

    }

    public void getResult(){
        System.out.println(title);
        System.out.println(str);
        for(String item:items){
            System.out.println(item);
        }
    }
}
