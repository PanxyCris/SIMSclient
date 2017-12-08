package SIMSclient.src.dataservice.accountbilldataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import SIMSclient.src.dataenum.BillType;
import SIMSclient.src.dataservice.CommonDataService;
import SIMSclient.src.po.makefinancialdoc.ReceiptBillPO;


/**  
* ��˵��   
*  
* @author ****  
* @date 2017��11��12��    
*/
public interface ReceiptDataService extends CommonDataService<ReceiptBillPO>{

	public static final String NAME = "ReceiptBillData";
	
	public ArrayList<ReceiptBillPO> show(BillType type) throws RemoteException;

}
