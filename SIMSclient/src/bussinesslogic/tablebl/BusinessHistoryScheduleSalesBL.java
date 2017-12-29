package bussinesslogic.tablebl;

import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogicservice.checktableblservice.BusinessHistoryScheduleBLService;
import dataenum.findtype.FindSaleScheduleType;
import vo.billvo.salesbillvo.SalesVO;

public class BusinessHistoryScheduleSalesBL implements BusinessHistoryScheduleBLService<SalesVO> {

	@Override
	public ArrayList<SalesVO> show() {
		return null;
	}

	@Override
	public ArrayList<SalesVO> siftTime(LocalDate start, LocalDate end) {
		return null;
	}

	@Override
	public ArrayList<SalesVO> sift(String info, FindSaleScheduleType type) {
		return null;
	}

	@Override
	public void exportReport(ArrayList<SalesVO> table) {
		
	}

	@Override
	public ArrayList<SalesVO> writeOff(ArrayList<SalesVO> table) {
		return null;
	}

	@Override
	public ArrayList<SalesVO> writeOffAndCopy(ArrayList<SalesVO> table) {
		return null;
	}

}
