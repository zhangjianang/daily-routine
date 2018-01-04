package com.zk;

/**
 * Created by adimn on 2018/1/4.
 */
import java.io.IOException;
import java.util.UUID;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class AngUpdater implements Watcher{

    private static String hostPort = "localhost:2181";
    private static String zooDataPath = "/MyConfig";
    ZooKeeper zk;

    public AngUpdater() throws IOException {
        try {
            zk = new ZooKeeper(hostPort, 2000, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // updates the znode path /MyConfig every 5 seconds with a new UUID string.
    public void run() throws InterruptedException, KeeperException {
        while (true) {
            String uuid = UUID.randomUUID().toString();
            byte zoo_data[] = uuid.getBytes();
            zk.setData(zooDataPath, zoo_data, -1);
            try {
                Thread.sleep(5000); // Sleep for 5 secs
            } catch(InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        AngUpdater dataUpdater = new AngUpdater();
        dataUpdater.run();
    }

    //@Override
    public void process(WatchedEvent event) {
        System.out.printf("\nEvent Received: %s", event.toString());
    }
}
