package SIMSserver.src.dataservice.checktabledataservice;


import SIMSserver.src.dataservice.CommonDataService;
import SIMSserver.src.po.table.SaleSchedulePO;

public interface SaleScheduleDataService extends CommonDataService<SaleSchedulePO>{
	public static final String NAME = "SaleScheduleData";
	
	public void viewReport(SaleSchedulePO saleSchedulePO);
	
	public void exportReport();
}
