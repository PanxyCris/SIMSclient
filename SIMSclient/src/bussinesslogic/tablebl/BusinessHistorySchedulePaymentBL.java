package bussinesslogic.tablebl;

import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogicservice.checktableblservice.BusinessHistoryScheduleBLService;
import dataenum.findtype.FindSaleScheduleType;
import vo.billvo.financialbillvo.PaymentBillVO;

public class BusinessHistorySchedulePaymentBL implements BusinessHistoryScheduleBLService<PaymentBillVO> {

	@Override
	public ArrayList<PaymentBillVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PaymentBillVO> siftTime(LocalDate start, LocalDate end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PaymentBillVO> sift(String info, FindSaleScheduleType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void exportReport(ArrayList<PaymentBillVO> table) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeOff(ArrayList<PaymentBillVO> table) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeOffAndCopy(ArrayList<PaymentBillVO> table) {
		// TODO Auto-generated method stub
		
	}

}
