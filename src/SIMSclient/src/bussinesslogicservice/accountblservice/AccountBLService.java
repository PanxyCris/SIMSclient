package SIMSclient.src.bussinesslogicservice.accountblservice;

import SIMSclient.src.vo.AccountVO;

public interface AccountBLService {
	
	public AccountVO check(String message);//message���û�����IDʱ�������Ϣ�������߼�����󷵻�һ��AccountVO����
	
	public AccountVO newBuild();//�½�һ���˻�,����һ��AccountPO����
	
	public boolean delete(AccountVO accountVO);//ɾ��
	
	public boolean modify(String name);//�޸�
	
}
