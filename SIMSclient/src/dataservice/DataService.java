package dataservice;
import java.rmi.Remote;

import java.rmi.RemoteException;

import po.PersistObject;

/**
*
* @author Lijie
* @date 2017��12��2��
*/
public interface DataService<PO extends PersistObject> extends Remote {

	public void createTable() throws RemoteException;
	public void init() throws RemoteException;
	public String getID() throws RemoteException;
	public PO find(String ID) throws RemoteException;

}
