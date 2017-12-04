package SIMSclient.src.bussinesslogicservice.accountblservice;

import java.util.ArrayList;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.dataenum.findtype.FindAccountType;
import SIMSclient.src.vo.AccountVO;
import SIMSclient.src.vo.makefinancialdoc.FinancialDocVO;


/**
 *
 * @author ���Ӳ�
 * @version 2017-12-1
 *
 */
public interface AccountBLService {
	
	/**
	 * @param message �û�����ʱ�����keywords
	 * @param findType ѡ��Ĳ�������
	 * @return �˻�list
	 */
	public ArrayList<AccountVO> find(String message,FindAccountType findType);

	/**
	 * @param id �˻�id
	 * @param name �˻�����
	 * @param money �˻����
	 */
	public ResultMessage newBuild(String id,String name,String money);
		
	/**
	 * @param accountVOsΪ��������˻��б�
	 */
	public ResultMessage saveChange(ArrayList<AccountVO> accountVOs);

	/**
	 * @param id ��ɾ���˻�id
	 */
	public ResultMessage delete(String id);//ɾ��

	public ArrayList<AccountVO> getAccountList();  //����һ�½ӿڣ�����һ���˻�list
	
	public ResultMessage enterItem(FinancialDocVO financialDocVO); //�տ����� ����


}
