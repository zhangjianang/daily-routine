package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by adimn on 2017/5/27.
 */
public class ReadPropertyTool {
    public static Properties p = new Properties();
    static{
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("categoryCodeNew.properties");
        try {
            p.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getPropertyByParam(String filename,String colum){
        Properties rp=new Properties();
        String rstr=null;
        if(filename!=null&&colum!=null) {
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
            try {
                rp.load(is);
                rstr = rp.getProperty(colum);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return rstr;
    }

    public static void main(String[] args) {
     //  System.out.println(getIndustryModelMap());
        System.out.println(ReadPropertyTool.p.get("651"));
        System.out.println(getPropertyByParam("categoryCodeNew.properties","651"));
    }
}
