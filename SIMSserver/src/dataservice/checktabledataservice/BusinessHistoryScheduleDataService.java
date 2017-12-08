package dataservice.checktabledataservice;

import dataservice.CommonDataService;
import po.PersistObject;
import po.makefinancialdoc.FinancialDocPO;
import po.table.BusinessHistorySchedulePO;

/**
 * �鿴��Ӫ���̱�
 */
public interface BusinessHistoryScheduleDataService extends CommonDataService<BusinessHistorySchedulePO>{
	public static final String NAME = "BusinessHistoryScheduleData";
	
	public FinancialDocPO viewReport(BusinessHistorySchedulePO businessHistorySchedulePO);
	
	public void exportReport();
	
	public void writeOff();//���
	
	public void writeOffAndCopy(PersistObject billPO);//��岢����
}
