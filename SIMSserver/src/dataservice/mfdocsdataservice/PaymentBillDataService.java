package SIMSserver.src.dataservice.mfdocsdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import SIMSserver.src.dataenum.BillType;
import SIMSserver.src.dataservice.CommonDataService;
import SIMSserver.src.po.makefinancialdoc.PaymentBillPO;

/**  
* ��˵��   
*  
* @author ****  
* @date 2017��11��12��    
*/
/**
 * 
* @ClassName: PaymentBillDataService 
* @Description: TODO(������һ�仰��������������) 
* @author lijie
* @date 2017��12��3�� ����11:42:48 
*
 */
public interface PaymentBillDataService extends CommonDataService<PaymentBillPO> {

    public static final String NAME = "PaymentBillData";
	
	public ArrayList<PaymentBillPO> show(BillType type) throws RemoteException;

	
}
