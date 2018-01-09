package com.jedis;

import org.msgpack.MessagePack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.Date;

/**
 * Created by adimn on 2018/1/9.
 */
public class ArticlesDAOImpl implements  ArticlesDAO {
    @Autowired
    private Jedis myjid;

    private static final String POSTS_ID = "posts:id";

    private static final String POSTS_DATA = "posts:%s:data";


    public Long putArticles(Articles articles) {
        Long id = myjid.incr(POSTS_ID);

        String key = String.format(POSTS_DATA, id);
        // 序列化value
        MessagePack pack = new MessagePack();
        byte[] value;
        try {
            value = pack.write(articles);
        } catch (IOException e) {
            value = new byte[0];
        }

        String result = myjid.set(key.getBytes(), value);
        if (!result.equals("OK")) {
            id = -1L;
            myjid.decr(POSTS_ID);
        }
        return id;
    }

    public Articles getArticles(Long id) {
        String key = String.format(POSTS_DATA, id);
        byte[] value = myjid.get(key.getBytes());
        // 反序列化
        MessagePack message = new MessagePack();
        try {
            return message.read(value, Articles.class);
        } catch (IOException e) {
            return new Articles();
        }
    }

    public static void main(String[] args) {

        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        ArticlesDAOImpl adm=(ArticlesDAOImpl)context.getBean("articlesDAOImpl");

        Articles a1 =  new Articles();
        a1.setTitle("test");
        a1.setAuthor("ang");
        a1.setContent("a new day has come");
        a1.setTime(new Date());
        adm.putArticles(a1);
    }

    public void setMyjid(Jedis myjid) {
        this.myjid = myjid;
    }

    public Jedis getMyjid() {
        return myjid;
    }
}
