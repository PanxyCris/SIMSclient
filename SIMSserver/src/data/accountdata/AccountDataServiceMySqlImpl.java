package SIMSserver.src.data.accountdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import SIMSserver.src.dataenum.ResultMessage;
import SIMSserver.src.dataenum.findtype.FindAccountType;
import SIMSserver.src.dataservice.accountdataservice.AccountDataService;
import SIMSserver.src.po.AccountPO;
import SIMSserver.src.po.PersistObject;
/**
 * 
 * @author ���Ӳ�
 * @version 2017-12-2
 * 
 */
public class AccountDataServiceMySqlImpl extends UnicastRemoteObject implements AccountDataService{

	private AccountData account = null;
	
	protected AccountDataServiceMySqlImpl() throws RemoteException {
		super();
	}
	
	@Override
	public ResultMessage createTable() throws RemoteException {
		account = new AccountData();
		return account.createTable();
	}
	
	@Override
	public ResultMessage insert(AccountPO po) throws RemoteException {
		account = new AccountData();
		return account.insert(po);
	}

	@Override
	public ResultMessage delete(String ID) throws RemoteException {
		account = new AccountData();
		return account.delete(ID);
	}

	@Override
	public ResultMessage update(AccountPO po) throws RemoteException {
		account = new AccountData();
		return account.update(po);
	}

	@Override
	public ArrayList<AccountPO> show() throws RemoteException {
		account = new AccountData();
		return account.show();
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
		account = new AccountData();
		return account.find(ID);
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