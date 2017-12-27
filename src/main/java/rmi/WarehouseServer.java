package rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Created by adimn on 2017/12/26.
 */
public class WarehouseServer {
    public static void main(String[] args) throws Exception{
            System.out.println("Constructing server implementation");
            WarehouseImpl centralWarehouse = new WarehouseImpl();

            System.out.println("Binding server implementation to registry");
            LocateRegistry.createRegistry(1099);
            Naming.bind("rmi://localhost:1099/central_warehoues",centralWarehouse);

            System.out.println("Waiting for invocations from clients ...");
        }
}
