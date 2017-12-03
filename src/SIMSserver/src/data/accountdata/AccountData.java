package SIMSserver.src.data.accountdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import SIMSserver.src.dataenum.ResultMessage;
import SIMSserver.src.dataenum.findtype.FindAccountType;
import SIMSserver.src.dataservice.accountdataservice.AccountDataService;
import SIMSserver.src.po.AccountPO;

/**     
*  
* @author Lijie 
* @date 2017Äê12ÔÂ3ÈÕ    
*/
public class AccountData implements AccountDataService{

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

}
