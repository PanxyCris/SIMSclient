package dataservice.checktabledataservice;

import java.rmi.Remote;

import po.tablepo.SaleSchedulePO;

public interface SaleScheduleDataService extends Remote{
	public static final String NAME = "SaleScheduleData";
	
	public void viewReport(SaleSchedulePO saleSchedulePO);
	
	public void exportReport();
}
