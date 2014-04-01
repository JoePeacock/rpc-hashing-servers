package iface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * An RMI Interface for the first Client request.
 * Sends PK and UUID from Client to Server1
 * @author scottflo
 *
 */
public interface RmiPkInterface extends Remote {
    public boolean sendKey(String uuid, String key) throws RemoteException;
    
}
