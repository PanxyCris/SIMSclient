package SIMSclient.src.dataservice.accountdataservice;

import java.util.ArrayList;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.po.AccountPO;
import SIMSclient.src.vo.AccountVO;

/**
 * 
 * @author ���Ӳ�
 * @version 2017-12-1
 */
public interface AccountDataService {
	
	public ArrayList<AccountPO> find(String message);//message���û�����IDʱ�������Ϣ�������߼�����󷵻�һ��AccountVO����
	
	public ResultMessage newBuild(AccountVO accountVO);//�½�һ���˻�,����һ��AccountPO����
	
	public ResultMessage delete(AccountPO accountPO);//ɾ��
	
	public ResultMessage modify(String name);//�޸�
	
}
