package SIMSserver.src.dataservice.accountdataservice;

import java.rmi.RemoteException;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.po.AccountPO;

public interface AccountDataService {
	
	public AccountPO find(String message);//message���û�����IDʱ�������Ϣ�������߼�����󷵻�һ��AccountVO����
	
	public ResultMessage newBuild();//�½�һ���˻�,����һ��AccountPO����
	
	public ResultMessage delete(AccountPO accountPO);//ɾ��
	
	public ResultMessage modify(String name);//�޸�
}
