package SIMSclient.src.bussinesslogic.accountbl;

import SIMSclient.src.po.AccountPO;
import SIMSclient.src.vo.AccountVO;

public interface AccountBLService {
	
	public AccountPO check(String message);//message���û�����IDʱ�������Ϣ�������߼�����󷵻�һ��AccountPO����
	
	public boolean newBuild(AccountVO accountVO);//�½�һ���˻�,����bool��Ϣ
	
	public boolean delete(AccountVO accountVO);//ɾ��
	
	public boolean modify(String name);//�޸�
	
}