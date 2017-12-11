package dataservice.accountbilldataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.BillType;
import po.FinancialBill.ReceiptBillPO;

/**  
* ��˵��   
*  
* @author ****  
* @date 2017��11��12��    
*/
public interface ReceiptDataService extends Remote{

	public static final String NAME = "ReceiptBillData";
	
	public ArrayList<ReceiptBillPO> show(BillType type) throws RemoteException;

}
