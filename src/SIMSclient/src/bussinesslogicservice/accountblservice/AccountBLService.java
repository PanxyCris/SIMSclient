package SIMSclient.src.bussinesslogicservice.accountblservice;

import SIMSclient.src.ResultMessage;
import SIMSclient.src.vo.AccountVO;

public interface AccountBLService {
	
	public AccountVO find(String message);//message���û�����IDʱ�������Ϣ�������߼�����󷵻�һ��AccountVO����
	
	public ResultMessage newBuild();//�½�һ���˻�,����һ��AccountPO����
	
	public ResultMessage delete(AccountVO accountVO);//ɾ��
	
	public ResultMessage modify(String name);//�޸�
	
}
