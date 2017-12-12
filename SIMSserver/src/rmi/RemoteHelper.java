package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


/**
 *
 * @author ���Ӳ�
 * @version 2017-11-28
 *
 */
public class RemoteHelper {
	public RemoteHelper() {
		initServer();
	}
	
	public static void main(String[] args) throws RemoteException {
		DataRemoteObject dataRemoteObject = new DataRemoteObject();
		System.out.println(dataRemoteObject.login("002", "admin"));
	}
	
	public void initServer() {
		DataRemoteObject dataRemoteObject;
		try {
			dataRemoteObject = new DataRemoteObject();
			LocateRegistry.createRegistry(8887);
			Naming.bind("rmi://127.0.0.1:8887/DataRemoteObject", dataRemoteObject);

			System.out.println("server������󶨳ɹ�");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
}
