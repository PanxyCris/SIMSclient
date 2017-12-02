package SIMSclient.src.bussinesslogic.accountbl;

import java.util.ArrayList;

import SIMSclient.src.bussinesslogicservice.accountblservice.AccountBLService;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.dataservice.accountdataservice.AccountDataService;
import SIMSclient.src.po.AccountPO;
import SIMSclient.src.vo.AccountVO;

/**
 *
 * @author 王灿灿
 * @version 2017-12-1
 *
 */
public class AccountBL implements AccountBLService{

	private static AccountBL accountBL=new AccountBL();

	public AccountBL getInstance(){
		return accountBL;
	}

	AccountDataService accountDataService;
	AccountVO accountVO = new AccountVO("", "");
	AccountPO accountPO = new AccountPO("", 0);

/**
 * @author 王灿灿
 * @param message为检索内容
 *
 */
	public ArrayList<AccountVO> find(String message) {

		ArrayList<AccountVO> accountVOs=new ArrayList<>();
		ArrayList<AccountPO> accountPOs=new ArrayList<>();
		accountPOs=accountDataService.find(message);

		if (accountPOs.isEmpty()) {
			System.out.println(ResultMessage.NOTFOUND);
		}

		for (int i = 0; i < accountPOs.size(); i++) {
			//accountVO.setMoney(accountPOs.get(i).getMoney());
			accountVO.setName(accountPOs.get(i).getName());
			accountVOs.add(accountVO);
		}

		return accountVOs;
	}

/**
 * @author 王灿灿
 * @param name,money均为从ui得到的参数
 */
	public ResultMessage newBuild(String name,double money) {

		boolean judge=false;

		accountVO.setName(name);
		//accountVO.setMoney(money);

		ResultMessage message=accountDataService.newBuild(accountVO);

		return message;
	}

	public ResultMessage delete(AccountVO accountVO) {
		return null;
	}

	public ResultMessage modify(String name) {
		return null;
	}

	@Override
	public ResultMessage delete(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(String name, double money) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AccountVO> getAccountList() {
		// TODO Auto-generated method stub
		return null;
	}

}
