package dataservice.accountdataservice;
/**     
*  
* @author Lijie 
* @date 2017��12��14��    
*/

import java.util.ArrayList;

import po.MemberPO;

public interface Member_AccountInfo {

	public void setPayable(String id, double payable); //�޸�Ӧ��
	public void setReceivable(String id, double receivable); //�޸�Ӧ��
	public ArrayList<MemberPO> getMembers(); //��ȡȫ���ͻ�����
	public String getName(String id);  
	public String getId(String id);
	
}
