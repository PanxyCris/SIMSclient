package SIMSclient.src.dataservice.accountbilldataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import SIMSclient.src.dataenum.BillType;
import SIMSclient.src.dataservice.CommonDataService;
import SIMSclient.src.po.makefinancialdoc.PaymentBillPO;

/**  
* ��˵��   
*  
* @author ****  
* @date 2017��11��12��    
*/
public interface PaymentBillDataService extends CommonDataService<PaymentBillPO> {

    public static final String NAME = "PaymentBillData";
	
	public ArrayList<PaymentBillPO> show(BillType type) throws RemoteException;
}
