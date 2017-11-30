package SIMSclient.src.bussinesslogic.accountbl;

import SIMSclient.src.bussinesslogicservice.accountblservice.AccountBLService;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.vo.AccountVO;

/**
 * 
 * @author Íõ²Ó²Ó
 *
 */
public class AccountController implements AccountBLService{
	
	AccountBL accountBL=new AccountBL();
	AccountVO accountVO;
	
	public static AccountController accountController=new AccountController();
	
	public static AccountController getInstance(){
		return accountController;
	}
	
	public AccountBLService getContoller(){
		return (AccountBLService)accountController;
	}

	@Override
	public AccountVO find(String message) {
		return accountBL.find(message);
	}

	@Override
	public ResultMessage newBuild() {
		return accountBL.newBuild();
	}

	@Override
	public ResultMessage delete(AccountVO accountVO) {
		return accountBL.delete(accountVO);
	}

	@Override
	public ResultMessage modify(String name) {
		return accountBL.modify(name);
	}
	
	
}
