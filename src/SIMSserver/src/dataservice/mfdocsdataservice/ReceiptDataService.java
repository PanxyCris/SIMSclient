package SIMSserver.src.dataservice.mfdocsdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import SIMSserver.src.dataenum.BillType;
import SIMSserver.src.dataservice.CommonDataService;
import SIMSserver.src.po.makefinancialdoc.PaymentBillPO;

/**  
* 类说明   
*  
* @author ****  
* @date 2017年11月12日    
*/
public interface ReceiptDataService extends CommonDataService<PaymentBillPO>{

	public static final String NAME = "ReceiptBillData";
	
	public ArrayList<PaymentBillPO> show(BillType type) throws RemoteException;

}
