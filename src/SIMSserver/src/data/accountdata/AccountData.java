package SIMSserver.src.data.accountdata;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.util.ArrayList;

import SIMSserver.src.data.CommonData;
import SIMSserver.src.dataenum.ResultMessage;
import SIMSserver.src.dataenum.findtype.FindAccountType;
import SIMSserver.src.dataservice.accountdataservice.AccountDataService;
import SIMSserver.src.po.AccountPO;
import SIMSserver.src.po.PersistObject;

/**     
*  
* @author Lijie 
* @date 2017Äê12ÔÂ3ÈÕ    
*/
public class AccountData extends CommonData<AccountPO> implements AccountDataService{

	private static final long serialVersionUID = 1L;
	
	public AccountData() throws RemoteException{
		super();
	}

	@Override
	public ResultMessage insert(AccountPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage delete(String ID) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage update(AccountPO po) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<AccountPO> show() throws RemoteException {
		return null;
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
	public AccountPO find(String ID) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<AccountPO> find(String keywords, FindAccountType type) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<AccountPO> getAccountList() {
		return null;
	}

	@Override
	public ResultMessage enterItem(ArrayList<String> idList, ArrayList<String> moneyList) {
		return null;
	}

	@Override
	public ResultMessage newBuild(PersistObject po) {
		return null;
	}

	@Override
	public ResultMessage saveChange(ArrayList<PersistObject> persistObjects) {
		return null;
	}
	
}
