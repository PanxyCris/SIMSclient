package bussinesslogicservice.accountblservice;

import java.util.ArrayList;

import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountType;
import vo.AccountVO;
import vo.FinancialBill.FinancialDocVO;


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
	 * @param 
	 */
	public ResultMessage judgeLegal(AccountVO accountVO);

	public ArrayList<AccountVO> getAccountList();  //����һ�½ӿڣ�����һ���˻�list
	
	public ResultMessage enterItem(FinancialDocVO financialDocVO,BillType billType); //�տ����� ����


}
