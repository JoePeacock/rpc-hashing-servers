package client;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import common.RmiInterface1;

public class Client { 

	private RmiInterface1 pk;
	private RmiInterface1 hfp;
	
	public Client() {
    	try {
    		pk = (RmiInterface1)Naming.lookup("//localhost/fp-private");
			hfp = (RmiInterface1)Naming.lookup("//localhost/fp-private");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    public static void main(String args[]) throws Exception {
    	Client c = new Client();

    	boolean pkSent = c.sendPrivateKey("FUCK IN THE ASS RANDY");
    	System.out.println(pkSent);
    }
    
    /**
     * 
     * @param key - The private key of the finger print
     * @return true - if the server successfully got the private key.
     * 
     * @author joepeacock
     *
     */
    public boolean sendPrivateKey(String key) {
    	try {
			return pk.sendKey(key);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
    }
}