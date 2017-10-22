package SIMSserver.src.dataservice.checktabledataservice;

import SIMSclient.src.po.table.SaleSchedulePO;

public interface saleScheduleBLService {
	public void viewReport(SaleSchedulePO saleSchedulePO);
	
	public void exportReport();
}
