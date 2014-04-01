package iface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * An RMI interface for server-to-server requests.
 * Server2 sends the (doubly) hashed fingerprint and UUID from Server2 to Server1.
 * @author scottflo
 *
 */
public interface RmiHash2Interface extends Remote{
	public boolean sendDoubleHash(String uuid, String doubleHash) throws RemoteException;
}
