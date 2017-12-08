package SIMSserver.src.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import SIMSserver.src.dataenum.ResultMessage;
import SIMSserver.src.po.PersistObject;


/**     
*  
* @author Lijie 
* @date 2017Äê12ÔÂ2ÈÕ    
*/
public interface DataService<PO extends PersistObject> extends Remote {

	public ResultMessage createTable() throws RemoteException;
	public void init() throws RemoteException;
	public String getID() throws RemoteException;
}
