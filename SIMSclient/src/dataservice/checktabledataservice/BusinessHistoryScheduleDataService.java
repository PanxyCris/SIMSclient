package dataservice.checktabledataservice;

import java.rmi.Remote;

import po.PersistObject;
import po.FinancialBill.FinancialDocPO;
import po.table.BusinessHistorySchedulePO;

/**
 * �鿴��Ӫ���̱�
 */
public interface BusinessHistoryScheduleDataService extends Remote {
	public static final String NAME = "BusinessHistoryScheduleData";
	
	public FinancialDocPO viewReport(BusinessHistorySchedulePO businessHistorySchedulePO);
	
	public void exportReport();
	
	public void writeOff();//���
	
	public void writeOffAndCopy(PersistObject billPO);//��岢����
}
