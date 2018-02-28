package com.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adimn on 2018/1/9.
 */
public class JedisTry {
    public Jedis jedisCli;
    public JedisTry(){
        jedisCli = new Jedis("127.0.0.1", 6379); //新建Jedis对象
    }

    public void testClient() {

        jedisCli.select(2); //切换Redis数据库

        Pipeline pl = jedisCli.pipelined();
        pl.lpush("chamopion","we");
        pl.lpush("chamopion","are");
        pl.lpush("chamopion","the");
        pl.sync();
        jedisCli.disconnect();
    }

    public void testMap() {
        jedisCli.select(2);
        jedisCli.hset("family", "lbq", "65"); //同Redis命令行中的hset操作，如名为family的set不存在，则创建set并放入名为lbq的元素，值为65
        jedisCli.hset("family", "zjz", "62"); //Redis不支持int类型，如不传String则会报错。
        System.out.println(jedisCli.hmget("family","lbq","zjz"));

        Map testMap1 = new HashMap();
        testMap1.put("num1", "1"); //此处同上面，不能传非String型
        testMap1.put("num2", "15");
        testMap1.put("num3", "606");
        testMap1.put("num4", "1024");
        jedisCli.hmset("testMap1", testMap1); //传入整个map对象入redis
        System.out.println(jedisCli.hmget("testMap1", "num1","num2","num3","num4"));
    }

    public void testList(){
        jedisCli.del("mypath");
        String ipstr = "192.168.0.1,192.168.0.104";
        String[] ips = ipstr.split(",");
        jedisCli.lpush("mypath",ips);
        List<String> find = jedisCli.lrange("mypath", 0, -1);
        if(find.contains("192.168.0.104")){
            System.out.println("token has the 104");
        }else {
            System.out.println("token does not has the 104");
        }
    }

    public static void main(String[] args) {
        JedisTry jd = new JedisTry();
        jd.testList();
    }
}
