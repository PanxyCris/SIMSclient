package SIMSclient.src.bussinesslogic.accountbl;

import SIMSclient.src.bussinesslogicservice.accountblservice.AccountBLService;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.dataservice.accountdataservice.AccountDataService;
import SIMSclient.src.po.AccountPO;
import SIMSclient.src.vo.AccountVO;

/**
 * 
 * @author Íõ²Ó²Ó
 * @version 2017-10-26
 *
 */
public class AccountBL implements AccountBLService{
	
	private static AccountBL accountBL=new AccountBL();
	
	public AccountBL getInstance(){
		return accountBL;
	}
	
	public 
	
	AccountVO accountVO=new AccountVO("",0);
	AccountDataService accountDataService;
	
	public AccountVO find(String message) {
		
		accountVO
		
	
		
		return accountVO;
	}

	public ResultMessage newBuild() {
		return null;
	}

	public ResultMessage delete(AccountVO accountVO) {
		return null;
	}

	public ResultMessage modify(String name) {
		return null;
	}

}
