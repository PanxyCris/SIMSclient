package SIMSserver.src.dataservice.accountdataservice;

import java.rmi.RemoteException;

import SIMSclient.src.po.AccountPO;

public interface AccountDataService {
	
public AccountPO check(String message)throws RemoteException;//message���û�����IDʱ�������Ϣ�������߼�����󷵻�һ��AccountPO����
	
	public AccountPO newBuild()throws RemoteException;//�½�һ���˻�,����һ��AccountPO����
	
	public boolean delete(AccountPO accountPO)throws RemoteException;//ɾ��
	
	public boolean modify(String name)throws RemoteException;//�޸�
}
