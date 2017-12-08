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
import SIMSserver.src.po.PersistObject;

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

	public void initServer() {
		UserDataService dataRemoteObject;
		try {
			dataRemoteObject = new UserDataServiceImpl();
			LocateRegistry.createRegistry(9999);
			Naming.bind("rmi://localhost:9999/DataRemoteObject", dataRemoteObject);

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
