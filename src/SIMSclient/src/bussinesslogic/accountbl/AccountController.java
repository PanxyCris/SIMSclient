package SIMSclient.src.bussinesslogic.accountbl;

import java.util.ArrayList;

import SIMSclient.src.bussinesslogicservice.accountblservice.AccountBLService;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.vo.AccountVO;

/**
 *
 * @author 王灿灿
 * @version 2017-12-1
 *
 * AccountBL模块的controller
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
	public ResultMessage newBuild(String name, double money) {
		return accountBL.newBuild(name,money);
	}

	@Override
	public ResultMessage delete(String name) {//这里改了一下，输入名称就好了
		return accountBL.delete(accountVO);
	}

	@Override
	public ResultMessage modify(String name,double money) {//这里改了一下，修改两个都可能要改
		return accountBL.modify(name);
	}

	@Override
	public ArrayList<AccountVO> getAccountList() {
		AccountVO account1 = new AccountVO("王灿灿", "500000");
		ArrayList<AccountVO> list = new ArrayList<>();
		list.add(account1);
        return list;
	}


}
