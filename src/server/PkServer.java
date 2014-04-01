package server;

import iface.RmiPkInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * PK Server. Validates Private Key(s) received from client. Designed to be
 * a blocking operation. Stores one session at a time. If PK is valid, make note
 * of the session ID (currentUUID), so it can be retrieved by HashServer later.
 * @author scottflo
 *
 */
public class PkServer extends RmiServerBase implements RmiPkInterface {

	private static final String SECRET_KEY = "FUCK ME IN THE ASS RANDY";
    
	private String currentUUID;
	
	public PkServer(int port, String name) throws RemoteException {
		super(port, name);
	}

	@Override
	public boolean sendKey(String uuid, String key) throws RemoteException {
    	if (key.equals(SECRET_KEY)) {
    		System.out.println("Private Key Match!");
        	currentUUID = uuid;
    		return true;
    	} else {
    		System.err.println("Private Key Mismatch!");
    		currentUUID = null;
    		return false;
    	}
	}

	@Override
	public void startServer() throws RemoteException, MalformedURLException {
		Naming.rebind(name,this);
	}
	
	public String getCurrentUUID() {
		return currentUUID;
	}
}
