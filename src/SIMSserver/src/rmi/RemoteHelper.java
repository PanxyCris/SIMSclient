package SIMSserver.src.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import SIMSserver.src.data.salesdata.SalesDataServiceImpl;
import SIMSserver.src.data.userdata.UserDataServiceImpl;
import SIMSserver.src.dataservice.salesdataservice.SalesDataService;
import SIMSserver.src.dataservice.userdataservice.UserDataService;

/**
 * 
 * @author Íõ²Ó²Ó
 * @version 2017-11-28
 * 
 */
public class RemoteHelper {
	public RemoteHelper() {
		initServer();
	}

	public void initServer() {
		UserDataService dataRemoteObject;
		try {
			dataRemoteObject = new UserDataServiceImpl();
			LocateRegistry.createRegistry(8887);
			Naming.bind("rmi://127.0.0.1:8887/DataRemoteObject", dataRemoteObject);

		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
}
