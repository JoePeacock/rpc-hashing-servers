package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
 
public interface RmiInterface1 extends Remote {
    public boolean sendKey(String key) throws RemoteException;
}
