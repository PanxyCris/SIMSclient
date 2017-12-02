package SIMSclient.src.bussinesslogic.accountbl;

import java.util.ArrayList;

import SIMSclient.src.bussinesslogicservice.accountblservice.AccountBLService;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.vo.AccountVO;
import SIMSclient.src.vo.makefinancialdoc.FinancialDocVO;

/**
 *
 * @author ���Ӳ�
 * @version 2017-12-2
 *
 * AccountBLģ���controller
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
	public ArrayList<AccountVO> find(String message) {
		return accountBL.find(message);
	}

	@Override
	public ResultMessage newBuild(String name, String money) {
		return accountBL.newBuild(name,money);
	}

	@Override
	public ResultMessage delete(String name) {
		return accountBL.delete(name);
	}

	@Override
	public ResultMessage modifyName(String preName,String targetName) {
		return accountBL.modifyName(preName, targetName);
	}

	@Override
	public ResultMessage enterItem(FinancialDocVO financialDocVO) {
		return accountBL.enterItem(financialDocVO);
	}
	
	@Override
	public ArrayList<AccountVO> getAccountList() {
        return accountBL.getAccountList();
	}

}
