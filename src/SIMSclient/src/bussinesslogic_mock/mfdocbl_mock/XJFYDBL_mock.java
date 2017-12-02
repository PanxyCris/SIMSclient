package SIMSclient.src.bussinesslogic_mock.mfdocbl_mock;

import SIMSclient.src.bussinesslogic.xjfydbl.XJFYDBL;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.vo.makefinancialdoc.ReceiptBillVO;

public class XJFYDBL_mock extends XJFYDBL{

	ReceiptBillVO xjfydVO;
	
	public XJFYDBL_mock() {
	}
	
	@Override
	public ResultMessage newBuild(ReceiptBillVO xjfydVO) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modify(ReceiptBillVO xjfydVO) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(ReceiptBillVO xjfydVO) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ReceiptBillVO find(String message) {
		return xjfydVO;
	}

	@Override
	public ResultMessage commit(ReceiptBillVO xjfydVO) {
		return ResultMessage.SUCCESS;
	}

}
