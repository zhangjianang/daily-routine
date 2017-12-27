package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by adimn on 2017/12/26.
 */
public class WarehouseImpl extends UnicastRemoteObject implements Warehouse {
    private static final long serialVersionUID = 1L;
    private Map<String,Double> prices;
    protected WarehouseImpl() throws RemoteException
    {
        prices = new HashMap<String,Double>();
        prices.put("mate7",3700.00);

    }
    public double getPrice(String description) throws RemoteException
    {
        Double price = prices.get(description);
        return price == null? 0 : price;
    }

}
