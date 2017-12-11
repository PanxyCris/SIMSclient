package bussinesslogicservice.salesblservice;

import java.rmi.RemoteException;

import dataenum.BillType;

/**     
*  
* @author Lijie 
* @date 2017��12��11��    
*/
public interface Sale_CommodityInfo {
	
	public boolean checkNumber(String id, int i) throws RemoteException;  //������ʱ�򣬼��������Ʒ�������Ƿ�
	
	public void setDelete(String id, boolean canDelete) throws RemoteException;  //���ó��Ƿ����ɾ��

	public String getName(String id) throws RemoteException;
	
	public String getModel(String id) throws RemoteException;
	
	public void changeCommodityInfo(String id, int number, double price, BillType billType) throws RemoteException;

}
