package client;
import iface.RmiHashInterface;
import iface.RmiPkInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.UUID;

import common.Names;
import common.Request;

public class Client { 

	private RmiPkInterface pkServerConnection;
	private RmiHashInterface hashServerConnection;
	
	public Client() throws MalformedURLException, RemoteException, NotBoundException {
		pkServerConnection = (RmiPkInterface) Naming.lookup(Names.PK_NAME);
		hashServerConnection = (RmiHashInterface) Naming.lookup(Names.HASH_NAME);
	}

    public static void main(String args[]) throws Exception {
    	Client c = new Client();

    	String uuid = UUID.randomUUID().toString();
    	Request pkRequest = new Request(uuid,"FUCK ME IN THE ASS RANDY");
    	Request hashRequest = new Request(uuid, "xxxxxxfingerprinthashxxxxxxx");
    	
    	//Send the Private Key
    	boolean pkSent = c.sendPrivateKey(pkRequest);
    	System.out.println("PK Accepted" + pkSent);
    	
    	//Then send the Hash
    	boolean hashSent = c.sendHash(hashRequest);
    	System.out.println("Hash Accepted: " + hashSent);
    }
    
    /**
     * 
     * @param request - The private key of the finger print
     * @return true - if the server validated private key.
     * 
     * @author joepeacock
     *
     */
    public boolean sendPrivateKey(Request request) {
    	try {
			return pkServerConnection.sendKey(request.getUUID(), request.getPayload());
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
    }
    
    /**
     * 
     * @param request - the hash of the fingerprint
     * @return true - if server successfully stored fingerprint.
     */
    public boolean sendHash(Request request) {
    	try {
			return hashServerConnection.sendHash(request.getUUID(), request.getPayload());
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
    }
}