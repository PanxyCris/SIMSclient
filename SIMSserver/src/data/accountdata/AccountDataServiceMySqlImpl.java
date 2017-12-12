package data.accountdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindAccountType;
import dataservice.accountdataservice.AccountDataService;
import po.AccountPO;
import po.PersistObject;

/**
 * 
 * @author Íõ²Ó²Ó
 * @version 2017-12-2
 * 
 */
public class AccountDataServiceMySqlImpl  implements AccountDataService{

	private AccountData account;

	@Override
	public ArrayList<AccountPO> findAccount(String keywords, FindAccountType type) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<AccountPO> showAccount() throws RemoteException {
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

	@Override
	public ResultMessage enterItem(ArrayList<String> idList, ArrayList<Double> moneyList, String memberID) {
		return null;
	}
	
	
}
