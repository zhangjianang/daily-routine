package rmi;

import java.rmi.Naming;

/**
 * Created by adimn on 2017/12/26.
 */
public class WarehouseClient {
    public static void main(String[] args) throws Exception {
        System.out.println("RMI registry binding:");
        String url = "rmi://10.10.20.33:1099/central_warehoues";
        Warehouse centralWarehouse = (Warehouse) Naming.lookup(url);
        String descr = "mate7";
        double price = centralWarehouse.getPrice(descr);
        System.out.println(descr + ":" + price);
    }
}
