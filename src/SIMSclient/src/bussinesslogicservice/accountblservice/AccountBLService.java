package SIMSclient.src.bussinesslogicservice.accountblservice;

import java.util.ArrayList;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.vo.AccountVO;


/**
 * 
 * @author ���Ӳ�
 * @version 2017-12-1
 *
 */
public interface AccountBLService {
	
	public ArrayList<AccountVO> find(String message);//message���û�����IDʱ�������Ϣ�������߼�����󷵻�һ��AccountVO����
	
	public ResultMessage newBuild(String name,double money);//�½�һ���˻�,����һ��AccountPO����
	
	public ResultMessage delete(AccountVO accountVO);//ɾ��
	
	public ResultMessage modify(String name);//�޸�
	
}
