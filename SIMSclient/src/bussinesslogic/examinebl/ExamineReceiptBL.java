package bussinesslogic.examinebl;

import java.util.ArrayList;

import bussinesslogicservice.examineblservice.ExamineBLService;
import dataenum.BillType;
import dataenum.ResultMessage;
import vo.billvo.financialbillvo.ReceiptBillVO;

public class ExamineReceiptBL implements ExamineBLService<ReceiptBillVO>{

	@Override
	public ResultMessage updateBill(ReceiptBillVO vo, BillType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage passBills(ArrayList<ReceiptBillVO> vos, BillType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage notPassBills(ArrayList<ReceiptBillVO> vos, BillType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReceiptBillVO> getCommitedBills() {
		// TODO Auto-generated method stub
		return null;
	}

}
