package SIMSserver.src.dataservice.checktabledataservice;

import SIMSclient.src.po.PersistObject;
import SIMSclient.src.po.makefinancialdoc.FinancialDocPO;
import SIMSclient.src.po.table.BusinessHistorySchedulePO;

public interface businessHistoryScheduleDataService {
	
	public FinancialDocPO viewReport(BusinessHistorySchedulePO businessHistorySchedulePO);
	
	public void exportReport();
	
	public void writeOff();//���
	
	public void writeOffAndCopy(PersistObject billPO);//��岢����
}
