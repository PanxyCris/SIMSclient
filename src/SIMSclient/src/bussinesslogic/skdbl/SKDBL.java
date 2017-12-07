package SIMSclient.src.bussinesslogic.skdbl;

import SIMSclient.src.bussinesslogicservice.mfdocblservice.skdblservice;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.vo.makefinancialdoc.PaymentBillVO;

public class SKDBL implements skdblservice{

	private static SKDBL skdController = new SKDBL();
	public static SKDBL getInstance(){
		return skdController;
	}

	public skdblservice getSKDBLService(){
		return (skdblservice)skdController;
	}

	@Override
	public ResultMessage newBuild(PaymentBillVO skdVO) {
		return null;
	}

	@Override
	public ResultMessage modify(PaymentBillVO skdVO) {
		return null;
	}

	@Override
	public ResultMessage delete(PaymentBillVO skdVO) {
		return null;
	}

	@Override
	public PaymentBillVO find(String message) {
		return null;
	}

	@Override
	public ResultMessage commit(PaymentBillVO skdVO) {
		return null;
	}

}
