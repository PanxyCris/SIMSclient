package bussinesslogic.commoditybl.Info;

import java.rmi.RemoteException;

import bussinesslogicservice.salesblservice.Sale_CommodityInfo;
import dataenum.BillType;

/**     
*  
* @author Lijie 
* @date 2017��12��11��    
*/
public class CommodityInfo implements Sale_CommodityInfo{

	/**
	 * ������ʱ�򣬼��������Ʒ�������Ƿ�
	 */
	@Override
	public boolean checkNumber(String id, int i) throws RemoteException {
		return false;
	}
    
	/**
	 * ����Ʒ���ó��Ƿ��ɾ��
	 */
	@Override
	public void setDelete(String id, boolean canDelete) throws RemoteException {
	}

	@Override
	public String getName(String id) throws RemoteException {
		return null;
	}

	@Override
	public String getModel(String id) throws RemoteException {
		return null;
	}

	@Override
	public void changeCommodityInfo(String id, int number, double price, BillType billType) throws RemoteException {
	}

}
