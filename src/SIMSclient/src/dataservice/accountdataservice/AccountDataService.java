package SIMSclient.src.dataservice.accountdataservice;

import java.util.ArrayList;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.po.AccountPO;
import SIMSclient.src.vo.AccountVO;
import SIMSserver.src.po.BillPO;

/**
 * 
 * @author ���Ӳ�
 * @version 2017-12-1
 */
public interface AccountDataService {
	
	public ArrayList<AccountPO> find(String message);//message���û�����IDʱ�������Ϣ,�������ݲ��߼�����󷵻�AccountPOList
	
	public ResultMessage newBuild(AccountVO accountVO);//�½�һ���˻�
	
	public ResultMessage delete(String name);//ɾ��
	
	public ResultMessage modify(String preName,String targetName);//�޸��˻���
	
	public ArrayList<AccountPO> getAccountList();  //����һ�½ӿڣ�����һ���˻�list
	
	public ResultMessage enterItem(BillP); //�տ����� ����
}
