package dataservice.accountbilldataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import po.financialbillpo.PaymentBillPO;

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
	
	public ResultMessage insertPaymentBill(PaymentBillPO po) throws RemoteException;
	
	public ResultMessage deletePaymentBill(String id) throws RemoteException;
	
	public ResultMessage updatePaymentBill(PaymentBillPO po) throws RemoteException;
	
	public ArrayList<PaymentBillPO> findPaymentBill(String keyword, FindAccountBillType type) throws RemoteException;
	
	public ArrayList<PaymentBillPO> showPaymentBill() throws RemoteException;

	
}
