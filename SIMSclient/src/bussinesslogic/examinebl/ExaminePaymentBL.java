package bussinesslogic.examinebl;

import java.util.ArrayList;

import bussinesslogicservice.examineblservice.ExamineBLService;
import dataenum.BillType;
import dataenum.ResultMessage;
import vo.billvo.financialbillvo.PaymentBillVO;

public class ExaminePaymentBL implements ExamineBLService<PaymentBillVO>{

	@Override
	public ResultMessage updateBill(PaymentBillVO vo, BillType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage passBills(ArrayList<PaymentBillVO> vos, BillType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage notPassBills(ArrayList<PaymentBillVO> vos, BillType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PaymentBillVO> getCommitedBills() {
		// TODO Auto-generated method stub
		return null;
	}

}
