package dataservice.mfdocsdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.BillType;
import dataservice.CommonDataService;
import po.makefinancialdoc.ReceiptBillPO;

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
