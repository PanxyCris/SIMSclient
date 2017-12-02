package SIMSclient.src.bussinesslogic_mock.mfdocbl_mock;

import SIMSclient.src.bussinesslogic.skdbl.SKDBL;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.vo.makefinancialdoc.PaymentBillVO;

public class SKDBL_mock extends SKDBL{

	PaymentBillVO skdVO;
	
	public SKDBL_mock(){
		
	}
	
	@Override
	public ResultMessage newBuild(PaymentBillVO skdVO) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modify(PaymentBillVO skdVO) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(PaymentBillVO skdVO) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public PaymentBillVO find(String message) {
		return skdVO;
	}

	@Override
	public ResultMessage commit(PaymentBillVO skdVO) {
		return ResultMessage.SUCCESS;
	}
	
}
