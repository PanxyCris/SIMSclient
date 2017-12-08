package SIMSserver.src.data;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import SIMSserver.src.dataenum.ResultMessage;
import SIMSserver.src.dataservice.CommonDataService;
import SIMSserver.src.po.PersistObject;

/**     
*  
* @author Lijie 
* @date 2017Äê12ÔÂ4ÈÕ    
*/
public abstract class CommonData<PO extends PersistObject> extends UnicastRemoteObject implements CommonDataService<PO>{

	private static final long serialVersionUID = 1L;

	public CommonData() throws RemoteException{
		
	}

	@Override
	public ResultMessage createTable() throws RemoteException {
		return null;
	}

	@Override
	public void init() throws RemoteException {
	}

	@Override
	public String getID() throws RemoteException {
		return null;
	}

	@Override
	public PO find(String ID) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage insert(PO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage delete(String ID) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage update(PO po) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<PO> show() throws RemoteException {
		return null;
	}

	
}
