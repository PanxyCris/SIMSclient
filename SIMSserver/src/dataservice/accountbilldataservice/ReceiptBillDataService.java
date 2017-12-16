package dataservice.accountbilldataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import po.FinancialBill.ReceiptBillPO;

/**  
* ��˵��   
*  
* @author ****  
* @date 2017��11��12��    
*/
public interface ReceiptBillDataService extends Remote {

	public ResultMessage insertReceiptBill(ReceiptBillPO po) throws RemoteException;

	public ResultMessage deleteReceiptBill(String id) throws RemoteException;

	public ResultMessage updateReceiptBill(ReceiptBillPO po) throws RemoteException;

	public ArrayList<ReceiptBillPO> findReceiptBill(String keyword, FindAccountBillType type) throws RemoteException;

	public ArrayList<ReceiptBillPO> showReceiptBill() throws RemoteException;
}
