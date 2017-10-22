package SIMSclient.src.dataservice.checktabledataservice;

import SIMSclient.src.po.BillPO;
import SIMSclient.src.po.makefinancialdoc.FinancialDocPO;
import SIMSclient.src.po.table.BusinessHistorySchedulePO;

public interface businessHistoryScheduleBLService {
	
	public FinancialDocPO viewReport(BusinessHistorySchedulePO businessHistorySchedulePO);//����ɸѡ����,���ص���
	
	public void exportReport();
	
	public void writeOff();//���
	
	public void writeOffAndCopy(BillPO billPO);//��岢����
	
	public void insert(BusinessHistorySchedulePO businessHistorySchedulePO);
	
	public void delete(BusinessHistorySchedulePO businessHistorySchedulePO);
}
