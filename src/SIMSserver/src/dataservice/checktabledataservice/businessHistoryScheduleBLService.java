package SIMSserver.src.dataservice.checktabledataservice;

import SIMSclient.src.po.PersistObject;
import SIMSclient.src.po.makefinancialdoc.FinancialDocPO;
import SIMSclient.src.po.table.BusinessHistorySchedulePO;

public interface businessHistoryScheduleBLService {
	
	public FinancialDocPO viewReport(BusinessHistorySchedulePO businessHistorySchedulePO);
	
	public void exportReport();
	
	public void writeOff();//ºì³å
	
	public void writeOffAndCopy(PersistObject billPO);//ºì³å²¢¸´ÖÆ
}
