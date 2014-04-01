package server;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;

public abstract class RmiServerBase extends UnicastRemoteObject {
	protected int port;
	protected String name;
	
	public RmiServerBase(int port, String name) throws RemoteException {
		super(0);
		this.port = port;
		this.name = name;
		try {
		LocateRegistry.createRegistry(port);
		}
		catch(RemoteException e) {
			//Do nothing, entry already exists.
		}
	}
	
	public abstract void startServer() throws RemoteException, MalformedURLException;
}
