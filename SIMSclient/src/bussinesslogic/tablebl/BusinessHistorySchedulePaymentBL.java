package bussinesslogic.tablebl;

import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogicservice.accountbillblservice.PaymentBillBLService;
import bussinesslogicservice.checktableblservice.BusinessHistoryScheduleBLService;
import dataenum.findtype.FindSaleScheduleType;
import javafx.util.converter.LocalDateStringConverter;
import vo.billvo.financialbillvo.PaymentBillVO;

public class BusinessHistorySchedulePaymentBL implements BusinessHistoryScheduleBLService<PaymentBillVO> {

	PaymentBillBLService paymentBillBLService;
	
	@Override
	public ArrayList<PaymentBillVO> show() {
		return paymentBillBLService.show();
	}

	@Override
	public ArrayList<PaymentBillVO> siftTime(LocalDate start, LocalDate end) {
		
		ArrayList<PaymentBillVO> out=new ArrayList<>();
		ArrayList<PaymentBillVO> paymentBillVOs=paymentBillBLService.show();
		for (int i = 0; i < paymentBillVOs.size(); i++) {
			LocalDate localDate=StringtoDate(paymentBillVOs.get(i).getId());
			if(localDate.isBefore(end)&&localDate.isAfter(start)){
				out.add(paymentBillVOs.get(i));
			}
		}
		return out;
	}

	/**
	 * 筛选条件：客户、业务员
	 */
	@Override
	public ArrayList<PaymentBillVO> sift(String info, FindSaleScheduleType type) {
		ArrayList<PaymentBillVO> out=new ArrayList<>();
		ArrayList<PaymentBillVO> paymentBillVOs=paymentBillBLService.show();
		if(type==FindSaleScheduleType.OPERATOR){
			for (int i = 0; i < paymentBillVOs.size(); i++) {
				String userID=paymentBillVOs.get(i).getId();
				if(userID.equals(info)){
					out.add(paymentBillVOs.get(i));
				}
			}
		}
		if(type==FindSaleScheduleType.MEMBER){
			for (int i = 0; i < paymentBillVOs.size(); i++) {
				String customerID=paymentBillVOs.get(i).getCustomerID();
				if(customerID.equals(info)){
					out.add(paymentBillVOs.get(i));
				}
			}
		}
		return out;
	}

	@Override
	public void exportReport(ArrayList<PaymentBillVO> table) {
		
	}

	@Override
	public void writeOff(ArrayList<PaymentBillVO> table) {//不能是总经理
		
	}

	@Override
	public void writeOffAndCopy(ArrayList<PaymentBillVO> table) {//不能是总经理
		
	}

	public LocalDate StringtoDate(String id){//id是单据编号
		String s=id.split("-")[1];
		String date=s.substring(0,4)+"-"+s.substring(4,6)+"-"+s.substring(6, s.length());
		LocalDate l=null;
		LocalDateStringConverter localDate =new LocalDateStringConverter();
		l=localDate.fromString(date);
		return l;
	}
	
}
