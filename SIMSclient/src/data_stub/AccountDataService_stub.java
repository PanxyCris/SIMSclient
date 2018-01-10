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
* @date 2018��1��10��    
*/
public class AccountDataService_stub implements AccountDataService {

	@Override
	public ArrayList<AccountPO> findAccount(String keywords, FindAccountType type) throws RemoteException {
		AccountPO po = new AccountPO("0001", "Lijie", 100.0);
		ArrayList<AccountPO> list = new ArrayList<>();
		list.add(po);
		return list;
	}

	@Override
	public ArrayList<AccountPO> showAccount() throws RemoteException {
		AccountPO po = new AccountPO("0001", "Lijie", 100.0);
		ArrayList<AccountPO> list = new ArrayList<>();
		list.add(po);
		return list;
	}

	@Override
	public ResultMessage insertAccount(AccountPO po) throws RemoteException {
		System.out.println("Insert Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage updateAccount(AccountPO po) throws RemoteException {
		System.out.println("Update Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deleteAccount(String id) throws RemoteException {
		System.out.println("Delete Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage updateMoney(String id, double money) throws RemoteException {
		System.out.println("Insert Succeed!");
		return ResultMessage.SUCCESS;
	}

}
