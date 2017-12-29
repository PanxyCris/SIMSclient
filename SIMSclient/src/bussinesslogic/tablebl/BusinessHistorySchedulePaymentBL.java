package bussinesslogic.tablebl;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogic.accountbillbl.PaymentBillController;
import bussinesslogic.examinebl.ExaminePaymentBL;
import bussinesslogicservice.accountbillblservice.PaymentBillBLService;
import bussinesslogicservice.checktableblservice.BusinessHistoryScheduleBLService;
import bussinesslogicservice.examineblservice.ExamineBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.findtype.FindSaleScheduleType;
import javafx.util.converter.LocalDateStringConverter;
import vo.billvo.financialbillvo.EntryVO;
import vo.billvo.financialbillvo.PaymentBillVO;

public class BusinessHistorySchedulePaymentBL implements BusinessHistoryScheduleBLService<PaymentBillVO> {

	private ExamineBLService<PaymentBillVO> examineBLService;
	private PaymentBillBLService paymentBillBLService;
	
	public BusinessHistorySchedulePaymentBL() {
		examineBLService=new ExaminePaymentBL();
		paymentBillBLService=new PaymentBillController();
	}
	
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

	@Override//红冲生成一样的单据的话是否意味着单据的id也一样？不是的话该怎么存？
	public ArrayList<PaymentBillVO> writeOff(ArrayList<PaymentBillVO> table) {//不能是总经理
		ArrayList<PaymentBillVO> pArrayList=new ArrayList<>();
		for (int i = 0; i < table.size(); i++) {
			pArrayList.add(redRush(table.get(i)));
		}
		
		//在数据库中创建单据的方法在这里
		try {
			examineBLService.passBills(pArrayList);
			return pArrayList;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<PaymentBillVO> writeOffAndCopy(ArrayList<PaymentBillVO> table) {//不能是总经理
		return null;
			
	}

	public LocalDate StringtoDate(String id){//id是单据编号
		String s=id.split("-")[1];
		String date=s.substring(0,4)+"-"+s.substring(4,6)+"-"+s.substring(6, s.length());
		LocalDate l=null;
		LocalDateStringConverter localDate =new LocalDateStringConverter();
		l=localDate.fromString(date);
		return l;
	}
	
	public PaymentBillVO redRush(PaymentBillVO paymentBillVO){//红冲数据转化方法
		String docID=paymentBillVO.getId();
		String customerID=paymentBillVO.getCustomerID();
		String userID=paymentBillVO.getUserID();
		String accountID=paymentBillVO.getAccountID();
		String note=paymentBillVO.getNote();
		BillState billState=paymentBillVO.getState();
		BillType billType=paymentBillVO.getType();
		//以上是不会变化的单据属性
		//以下是会将数值取负的单据属性
		double total=-paymentBillVO.getTotal();
		ArrayList<EntryVO> eVOs=new ArrayList<>();
		ArrayList<EntryVO> entryVOs=paymentBillVO.getEntryListVO();
		for (int i = 0; i < entryVOs.size(); i++) {
			eVOs.add(new EntryVO(entryVOs.get(i).getEntryName(),-entryVOs.get(i).getTransferAmount(), entryVOs.get(i).getNote()));
		}
		return new PaymentBillVO(docID, userID, customerID, accountID, eVOs, total, billType, billState, note);
	}
	
}
