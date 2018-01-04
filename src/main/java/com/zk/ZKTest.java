package com.zk;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by adimn on 2017/12/27.
 */
public class ZKTest implements Watcher {
    //zookeeper客户端启动状态 0是没启动 1是正在启动 2是已启动并处理启动事物创建了连接池
    private int isrun = 0;
//    private static final Logger LOG = LoggerFactory.getLogger(ZKTest.class);
    private ZooKeeper zookeeper;

    private Map<String,String> tanentSchemaMap = new HashMap<String, String>();


    private ZKTest() {

        //增加JVM退出时 资源释放##
        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run() {
                System.out.println("释放资源!");
                if (zookeeper != null) {
                    try {
                        zookeeper.close();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });

    }

    public String getSchemaByTanentId(String tanentId){
        synchronized(tanentSchemaMap) {
            for (String per : tanentSchemaMap.keySet()) {
                if (per.equals(tanentId)) {
                    return tanentSchemaMap.get(per);
                }
            }
            return tanentSchemaMap.get("default");
        }
    }

    public void addSchma(String res){
        synchronized (tanentSchemaMap){
            tanentSchemaMap.clear();

        }
    }

    public int getIsrun() {
        return isrun;
    }

    public void setIsrun(int isrun) {
        this.isrun = isrun;
    }

    //获取单节点信息
    public String getZkNodeData(String nodePath,boolean subscribe) throws KeeperException, InterruptedException {
        Stat stat = new Stat();
        byte[] data = zookeeper.getData(nodePath, subscribe, stat);
        if(data ==null){
            return null;
        }else{
            try {
                return new String(data,"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return null;
            }
        }
    }


    //获取某节点子节点组
    public List<String> getZkChildBNodes(String superNodePath, boolean subscribe) throws KeeperException, InterruptedException {
        List<String> children =  zookeeper.getChildren(superNodePath, subscribe);
        return children;
    }


    /**
     * 处理事件
     * @param event
     */
    public void process(WatchedEvent event) {
        {

            System.err.println("zookeeper client Receive watched event:  "+ event.getState());
            //如果当前状态是连接成功
            if (event.getState()== Event.KeeperState.SyncConnected){

                //如果是刚刚连接成功
                if (event.getType()== Event.EventType.None && null==event.getPath()){
                    zookeeperStartInit();
                    //如果是节点产生变化
                }
//                else if(event.getType()== Event.EventType.NodeChildrenChanged){
//                    zookeeperStartInit();
//                    //如果是节点数据产生变化
//                }
                else if(event.getType() == Event.EventType.NodeDataChanged){
                    zookeeperStartInit();
                }
            }else if(event.getState()== Event.KeeperState.Expired){

                try {
                    System.err.println("关闭失效zookeeper连接!");
                    //关闭之前的连接
                    zookeeper.close();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //重新连接
                try {
                    System.err.println("zookeeper重新连接!");
                    initZookeeperClient();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("");
            }
        }
    }

    private void zookeeperStartInit() {

        try {
//            List<String> children =  getZkChildBNodes(ZkConfig.getPath(),true);
            //// TODO: 2017/12/27  获取变化子节点信息，更新缓存

            String zkNodeData = getZkNodeData("/rkhd/servers/paas-bi-service/hosts/host1", true);
            addSchma(zkNodeData);
            setIsrun(2);
            System.out.println("find data:"+zkNodeData);

        } catch (Exception e){
            e.printStackTrace();
            System.err.println("根据zookeeper  初始化连接池失败!"+e);
        }
        System.out.println("do zookeeperStartInit");
    }



    /**
     * 封装单例的静态内部类
     * @author Administrator
     *
     */
    private static class Singleton {

        private static ZKTest instance;

        static {
            instance = new ZKTest();
        }

        public static ZKTest getInstance() {
            return instance;
        }
    }

    /**
     * 获取单例
     * @return
     */
    public static ZKTest getInstance() {
        return Singleton.getInstance();
    }

    /**
     * 初始化单例的便捷方法
     */
    public synchronized void init() {
        if(0==isrun){
            setIsrun(1);
            start();
        }
    }

    private void start() {
        try {
            initZookeeperClient();
            System.out.println(zookeeper.getState());
            Thread.sleep(Integer.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("zookeeper无法连接:"+e);
            Runtime.getRuntime().exit(1);
        }
    }

    private void initZookeeperClient() throws IOException {
        this.zookeeper = new ZooKeeper(
                "zookeeper.ingageapp.com:2181",
                600,
                this);
    }


    public static void main(String args[]){
        getInstance().init();
    }

}