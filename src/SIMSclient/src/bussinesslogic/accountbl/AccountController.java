package SIMSclient.src.bussinesslogic.accountbl;

import java.util.ArrayList;

import SIMSclient.src.bussinesslogicservice.accountblservice.AccountBLService;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.vo.AccountVO;

/**
 * 
 * @author Íõ²Ó²Ó
 * @version 2017-12-1
 * 
 * AccountBLÄ£¿éµÄcontroller
 * 
 */
public class AccountController implements AccountBLService{
	
	AccountBL accountBL=new AccountBL();
	AccountVO accountVO;
	
	public static AccountController accountController=new AccountController();
	
	public AccountController getInstance(){
		return accountController;
	}
	
	public AccountBLService getContoller(){
		return (AccountBLService)accountController;
	}

	@Override
	public ArrayList<AccountVO> find(String message) {
		return accountBL.find(message);
	}

	@Override
	public ResultMessage newBuild(String name, double money) {
		return accountBL.newBuild(name,money);
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
