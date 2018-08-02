package split;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by adimn on 2018/3/20.
 */
public class MySplit {
    public static void main(String[] args) {
        readtest();
    }

    public static void readtest(){
        File file = new File(MySplit.class.getClassLoader().getResource("20180301.txt").getFile());
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader(file));
            String tempString=null;
            while ((tempString = bf.readLine()) != null) {
                Pattern pattern=Pattern.compile("\\),\\(");
                String []items=pattern.split(tempString);
                for(String item:items) {
                    System.out.println(item);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

}
