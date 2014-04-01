package server1;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import common.RmiInterface1;

public class Server1 extends UnicastRemoteObject implements RmiInterface1 {

    public static final String MESSAGE = "Hello World";
 
    public Server1() throws RemoteException {
        super(0);    // required to avoid the 'rmic' step, see below
    }

    @Override
	public boolean sendKey(String key) throws RemoteException {
    	System.out.println(key);
    	if (key.equals("FUCK ME IN THE ASS RANDY")) {
    		return true;
    	} else {
    		return false;
    	}
	}
    
    public static void main(String args[]) throws Exception {
        try { 
        	//special exception handler for registry creation
            LocateRegistry.createRegistry(1099); 
        } catch (RemoteException e) {
            //do nothing, error means registry already exists
        }
 
        //Instantiate RmiServer
        Server1 obj = new Server1();
 
        // Bind this object instance to the name "RmiServer"
        Naming.rebind("//localhost/fp-private", obj);

        System.out.println("RMI server started");
    }
}
