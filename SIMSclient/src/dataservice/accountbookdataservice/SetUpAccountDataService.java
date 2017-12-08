package SIMSclient.src.dataservice.accountbookdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.dataservice.DataService;
import SIMSclient.src.po.AccountBookPO;


/**
 * 
* @ClassName: SetUpAccountDataService 
* @Description: �ڳ����� ,ֻ�����ӣ��鿴����ʾ
* @author lijie 
* @date 2017��12��3�� ����11:10:47 
*
 */
public interface SetUpAccountDataService extends DataService<AccountBookPO> {
	public static final String NAME = "AccountBookData";
    public ResultMessage insert(AccountBookPO po) throws RemoteException;
	public ArrayList<AccountBookPO> show() throws RemoteException;
}
