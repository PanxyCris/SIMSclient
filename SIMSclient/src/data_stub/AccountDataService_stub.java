package data_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindAccountType;
import dataservice.accountdataservice.AccountDataService;
import po.AccountPO;

/**     
*  
* @author Lijie 
* @date 2018Äê1ÔÂ10ÈÕ    
*/
public class AccountDataService_stub implements AccountDataService {

	@Override
	public ArrayList<AccountPO> findAccount(String keywords, FindAccountType type) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<AccountPO> showAccount() throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage insertAccount(AccountPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updateAccount(AccountPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage deleteAccount(String id) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updateMoney(String id, double money) throws RemoteException {
		return null;
	}

}
