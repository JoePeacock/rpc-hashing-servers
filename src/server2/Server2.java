package server2;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import common.Names;
import server.HashServer;

public class Server2 {
	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException
	{
		HashServer hash = new HashServer(1101, Names.HASH_NAME);
		hash.startServer();
		System.out.println("Server2 Started");
	}

}
