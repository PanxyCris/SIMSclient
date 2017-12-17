package bussinesslogicservice.checktableblservice;

import vo.ViewObject;
import vo.billvo.financialbillvo.FinancialDocVO;
import vo.tablevo.BusinessHistoryScheduleVO;

public interface BusinessHistoryScheduleBLService {

	public FinancialDocVO viewReport(BusinessHistoryScheduleVO businessHistoryScheduleVO);

	public void exportReport();

	public void writeOff();//���

	public void writeOffAndCopy(ViewObject billVO);//��岢����

}
