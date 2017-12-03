package SIMSserver.src.dataservice.accountdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import SIMSserver.src.dataenum.findtype.FindAccountType;
import SIMSserver.src.dataservice.CommonDataService;
import SIMSserver.src.po.AccountPO;

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
