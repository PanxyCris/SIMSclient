package SIMSserver.src.dataservice.checktabledataservice;

import SIMSserver.src.dataservice.CommonDataService;
import SIMSserver.src.po.PersistObject;
import SIMSserver.src.po.makefinancialdoc.FinancialDocPO;
import SIMSserver.src.po.table.BusinessHistorySchedulePO;

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
