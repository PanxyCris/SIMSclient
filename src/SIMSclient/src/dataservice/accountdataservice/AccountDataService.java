package SIMSclient.src.dataservice.accountdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import SIMSclient.src.dataenum.findtype.FindAccountType;
import SIMSclient.src.dataservice.CommonDataService;
import SIMSclient.src.po.AccountPO;

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
}
