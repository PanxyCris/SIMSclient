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
	AccountPO accountPO = new AccountPO("", ""); 
	

/**
 * @author 王灿灿
 * @param message为检索内容
 * 
 */
	@Override
	public ArrayList<AccountVO> find(String message) {
		
		ArrayList<AccountVO> accountVOs=new ArrayList<>();
		ArrayList<AccountPO> accountPOs=new ArrayList<>();
		accountPOs=accountDataService.find(message);
		
		if (accountPOs.isEmpty()) {
			System.out.println(ResultMessage.NOTFOUND);
		}
		
		for (int i = 0; i < accountPOs.size(); i++) {
			accountVO.setMoney(accountPOs.get(i).getMoney());
			accountVO.setName(accountPOs.get(i).getName());
			accountVOs.add(accountVO);
		}
		
		return accountVOs;
	}

/**
 * @author 王灿灿
 * @param name,money均为从ui得到的参数
 */
	@Override
	public ResultMessage newBuild(String name,String money) {
		
		double m = Double.valueOf(money);
		
		ResultMessage message = null;
		
		boolean judge=true;
		if (!find(name).isEmpty()) {
			judge=false;
			return message.ILLEGALINPUTNAME;
		}
		if(0 > m || Double.MAX_VALUE < m){
			judge=false;
			return message.ILLEAGLINPUTDATA;
		}
		if(judge){
			
			accountVO.setName(name);
			accountVO.setMoney(money);
			
			message=accountDataService.newBuild(accountVO);
			
		}
		return message.SUCCESS;
	}

/**
 * @author 王灿灿
 * @param name为待删除账户名称
 * 
 */
	@Override
	public ResultMessage delete(String name) {
		
		accountDataService.delete(name);
		
		
		return null;
	}

/**
 * @author 王灿灿
 * @param preName为修改前名称，targetName为待修改成的名称
 * 
 */
	@Override
	public ResultMessage modifyName(String preName,String targetName) {
		return null;
	}

	@Override
	public ArrayList<AccountVO> getAccountList() {
		return null;
	}

}
