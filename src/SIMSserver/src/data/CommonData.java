package SIMSserver.src.data;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

import SIMSserver.src.dataservice.CommonDataService;
import SIMSserver.src.po.PersistObject;

/**     
*  
* @author Lijie 
* @date 2017Äê12ÔÂ4ÈÕ    
*/
public abstract class CommonData<PO extends PersistObject> extends UnicastRemoteObject implements CommonDataService<PO>{

	protected CommonData(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
		super(port, csf, ssf);
	}

}
