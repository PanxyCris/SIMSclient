package SIMSserver.src.data.accountdata;

import java.util.ArrayList;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.po.AccountPO;
import SIMSserver.src.dataservice.accountdataservice.AccountDataService;

/**
 * 
 * @author Íõ²Ó²Ó
 * @version 2017-11-26
 * 
 */
public class AccountDataServiceMySqlImpl implements AccountDataService{
	
	private static AccountDataServiceMySqlImpl accountDataServiceMySqlImpl=new AccountDataServiceMySqlImpl();

	public AccountDataServiceMySqlImpl getInstance(){
		return accountDataServiceMySqlImpl;
	}
	
	public AccountDataServiceMySqlImpl() {
	}
	
	public AccountDataService getService(){
		return (AccountDataService)accountDataServiceMySqlImpl;
	}
	
	@Override
	public ArrayList<AccountPO> find(String message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage newBuild() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(AccountPO accountPO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
