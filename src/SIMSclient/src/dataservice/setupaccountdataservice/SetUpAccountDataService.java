package SIMSserver.src.dataservice.setupaccountdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import SIMSserver.src.dataenum.ResultMessage;
import SIMSserver.src.dataservice.DataService;
import SIMSserver.src.po.AccountBookPO;

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
