package SIMSclient.src.bussinesslogicservice.accountblservice;

import java.util.ArrayList;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.vo.AccountVO;
import SIMSclient.src.vo.bill.BillVO;


/**
 *
 * @author ���Ӳ�
 * @version 2017-12-1
 *
 */
public interface AccountBLService {

	public ArrayList<AccountVO> find(String message);//message���û�����IDʱ�������Ϣ�������߼�����󷵻�һ��AccountVO����

	public ResultMessage newBuild(String name,String money);//�½�һ���˻�,����һ��AccountPO����

	public ResultMessage delete(String name);//ɾ��

	public ResultMessage modifyName(String preName,String targetName);//�޸��˻���

	public ArrayList<AccountVO> getAccountList();  //����һ�½ӿڣ�����һ���˻�list
	
	public ResultMessage enterItem(BillVO billVO); //�տ����� ����


}
