package SIMSclient.src.bussinesslogicservice.utilityblservice;

import SIMSclient.src.dataenum.BillType;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.vo.ValueObject;

public interface UtilityBillBLService {
	
	public ResultMessage commitBill(ValueObject valueObject);
	
	public ResultMessage saveBill(ValueObject valueObject);
	
	
	
}
