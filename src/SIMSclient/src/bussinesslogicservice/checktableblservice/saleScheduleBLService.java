package SIMSclient.src.bussinesslogicservice.checktableblservice;

import SIMSclient.src.po.table.SaleSchedulePO;

public interface saleScheduleBLService {
	
	public SaleSchedulePO viewReport();
	
	public void exportReport();
	
}
