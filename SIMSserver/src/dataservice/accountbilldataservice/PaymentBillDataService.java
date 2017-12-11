package dataservice.accountbilldataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.BillType;
import po.FinancialBill.PaymentBillPO;

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
public interface PaymentBillDataService extends Remote {

    public static final String NAME = "PaymentBillData";
	
	public ArrayList<PaymentBillPO> show(BillType type) throws RemoteException;

	
}
