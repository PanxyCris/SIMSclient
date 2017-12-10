package dataservice.accountbookdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBookType;
import po.AccountBookPO;

/**
 * 
* @ClassName: SetUpAccountDataService 
* @Description: �ڳ����� ,ֻ�����ӣ��鿴����ʾ
* @author lijie 
* @date 2017��12��3�� ����11:10:47 
*
 */
public interface AccountBookDataService extends Remote {
	public static final String NAME = "AccountBookData";
    public ResultMessage insertAccountBook(AccountBookPO po) throws RemoteException;
    public ResultMessage deleteAccountBook(String ID) throws RemoteException;
    public ResultMessage updateAccountBook(AccountBookPO po) throws RemoteException;
    public ArrayList<AccountBookPO> find(String keyword, FindAccountBookType type) throws RemoteException;
	public ArrayList<AccountBookPO> showAccountBook() throws RemoteException;
}
