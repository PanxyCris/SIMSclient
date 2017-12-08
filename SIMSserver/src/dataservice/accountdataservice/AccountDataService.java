package dataservice.accountdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindAccountType;
import dataservice.CommonDataService;
import po.AccountPO;
import po.PersistObject;

/**
 * 
 * @author ���Ӳ�
 * @version 2017-12-1
 */
/**
 * 
* @ClassName: AccountDataService 
* @author lijie
* @date 2017��12��3�� ����10:03:44 
*
 */
public interface AccountDataService extends CommonDataService<AccountPO>{
	
	public static final String NAME = "AccountData";
	public ArrayList<AccountPO> find(String keywords, FindAccountType type) throws RemoteException;
	public ArrayList<AccountPO> getAccountList();
	public ResultMessage enterItem(ArrayList<String> idList, ArrayList<String> moneyList);
	public ResultMessage newBuild(PersistObject po);
	public ResultMessage saveChange(ArrayList<PersistObject> persistObjects);
}
