package SIMSclient.src.bussinesslogicservice.mfdocblservice;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.vo.makefinancialdoc.PaymentBillVO;

public interface skdblservice {
	
	public ResultMessage newBuild(PaymentBillVO skdVO);
	
	public ResultMessage modify(PaymentBillVO skdVO);
	
	public ResultMessage delete(PaymentBillVO skdVO);
	
	public PaymentBillVO find(String message);
	
	public ResultMessage commit(PaymentBillVO skdVO);
	
}
