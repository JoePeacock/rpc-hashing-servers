package server;

import iface.RmiHash2Interface;
import iface.RmiHashInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import common.Names;

/**
 * Hash code. This runs on Server2 and rehashes the fingerprint hash received by 
 * the client and then makes a request to Server1 to store the hashed fingerprint.
 * @author scottflo
 *
 */
public class HashServer extends RmiServerBase implements RmiHashInterface {
	
	private RmiHash2Interface hash2ServerConnecton;
	
	public HashServer(int port, String name) throws RemoteException, MalformedURLException, NotBoundException {
		super(port, name);
		hash2ServerConnecton = (RmiHash2Interface) Naming.lookup(Names.HASH2_NAME);
	}
	
	@Override
	public void startServer() throws RemoteException, MalformedURLException {
		Naming.rebind(name,this);
		
	}

	@Override
	public boolean sendHash(String uuid, String hash) throws RemoteException {
		return hash2ServerConnecton.sendDoubleHash(uuid, reHash(hash));
	}
	
	private String reHash(String hash) {
		//TODO actually hash it
		return hash;
	}

}
