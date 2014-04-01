package server1;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import common.Names;
import server.Hash2Server;
import server.PkServer;

public class Server1 {
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		PkServer pk = new PkServer(1099, Names.PK_NAME);
		pk.startServer();
		System.out.println("PK Server started!");
		
		Hash2Server hash2 = new Hash2Server(pk,1100, Names.HASH2_NAME);
		hash2.startServer();
		System.out.println("Hash2 Server started");
	}
}
