package bussinesslogicservice.checktableblservice;

import vo.ViewObject;
import vo.makefinancialdoc.FinancialDocVO;
import vo.table.BusinessHistoryScheduleVO;

public interface businessHistoryScheduleBLService {

	public FinancialDocVO viewReport(BusinessHistoryScheduleVO businessHistoryScheduleVO);

	public void exportReport();

	public void writeOff();//���

	public void writeOffAndCopy(ViewObject billVO);//��岢����

}
