package SIMSserver.src.data.accountdata;

import java.util.ArrayList;

import com.mysql.fabric.xmlrpc.base.Array;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.po.AccountPO;
import SIMSclient.src.vo.AccountVO;
import SIMSserver.src.dataservice.accountdataservice.AccountDataService;

/**
 * 
 * @author 王灿灿
 * @version 2017-12-2
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
		return null;
	}

	@Override
	public ResultMessage newBuild(AccountVO accountVO) {
		return null;
	}

	@Override
	public ResultMessage delete(String name) {
		return null;
	}

	@Override
	public ResultMessage modifyName(String preName, String targetName) {
		return null;
	}

	@Override
	public ArrayList<AccountPO> getAccountList() {
		return null;
	}

//这里负责实现将收付款单据入账，即修改对应account的Money数据
	@Override
	public ResultMessage enterItem(ArrayList<String> nameList,ArrayList<String> transferMoney) {
		return null;
	}
	


}
