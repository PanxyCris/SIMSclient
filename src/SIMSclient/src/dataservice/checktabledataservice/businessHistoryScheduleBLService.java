package SIMSclient.src.dataservice.checktabledataservice;

import SIMSclient.src.po.BillPO;
import SIMSclient.src.po.makefinancialdoc.FinancialDocPO;
import SIMSclient.src.po.table.BusinessHistorySchedulePO;

public interface businessHistoryScheduleBLService {
	
	public FinancialDocPO viewReport(BusinessHistorySchedulePO businessHistorySchedulePO);//传入筛选条件,返回单据
	
	public void exportReport();
	
	public void writeOff();//红冲
	
	public void writeOffAndCopy(BillPO billPO);//红冲并复制
	
	public void insert(BusinessHistorySchedulePO businessHistorySchedulePO);
	
	public void delete(BusinessHistorySchedulePO businessHistorySchedulePO);
}
