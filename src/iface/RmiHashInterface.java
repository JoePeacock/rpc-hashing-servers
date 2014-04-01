package iface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * An RMI interface for the second client request.
 * Sends Fingerprint from Hash and UUID from Client to Server2.
 * @author scottflo
 *
 */
public interface RmiHashInterface extends Remote{
	public boolean sendHash(String uuid, String hash) throws RemoteException;
}
