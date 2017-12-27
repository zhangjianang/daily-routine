package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by adimn on 2017/12/26.
 */
public interface Warehouse extends Remote{
    double getPrice(String description) throws RemoteException;
}
