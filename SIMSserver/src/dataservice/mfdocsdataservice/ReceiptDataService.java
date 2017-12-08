package SIMSserver.src.dataservice.mfdocsdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import SIMSserver.src.dataenum.BillType;
import SIMSserver.src.dataservice.CommonDataService;
import SIMSserver.src.po.makefinancialdoc.ReceiptBillPO;

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
