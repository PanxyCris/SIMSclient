package bussinesslogic.tablebl;

import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogicservice.checktableblservice.BusinessHistoryScheduleBLService;
import dataenum.findtype.FindSaleScheduleType;
import vo.billvo.financialbillvo.ReceiptBillVO;

public class BussinessHistoryScheduleReceiveBL implements BusinessHistoryScheduleBLService<ReceiptBillVO> {

	@Override
	public ArrayList<ReceiptBillVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReceiptBillVO> siftTime(LocalDate start, LocalDate end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReceiptBillVO> sift(String info, FindSaleScheduleType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void exportReport(ArrayList<ReceiptBillVO> table) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeOff(ArrayList<ReceiptBillVO> table) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeOffAndCopy(ArrayList<ReceiptBillVO> table) {
		// TODO Auto-generated method stub
		
	}

}
