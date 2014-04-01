package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import iface.RmiHash2Interface;

/**
 * Hash2 code. This runs on Server1 and stores the doubly-hashed fingerprint, assuming
 * the current session is valid (ie PK from the Client request earlier matched successfully).
 * @author scottflo
 *
 */
public class Hash2Server extends RmiServerBase implements RmiHash2Interface{

	private PkServer pkServer;
	
	public Hash2Server(PkServer pkServer, int port, String name) throws RemoteException {
		super(port, name);
		this.pkServer = pkServer;
	}

	@Override
	public boolean sendDoubleHash(String uuid, String doubleHash) throws RemoteException{
		if(pkServer.getCurrentUUID().equals(uuid)) {
			System.out.println("Fingerprint Stored!");
			//TODO STORE FINGERPRINT
			return true;
		}
		System.err.println("Fingerprint not stored");
		return false;
	}

	@Override
	public void startServer() throws RemoteException, MalformedURLException {
		Naming.rebind(name,this);
	}

}
