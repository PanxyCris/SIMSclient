package bussinesslogic.tablebl;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogic.accountbillbl.ReceiptBillController;
import bussinesslogic.examinebl.ExamineReceiptBL;
import bussinesslogicservice.accountbillblservice.ReceiptBillBLService;
import bussinesslogicservice.checktableblservice.BusinessHistoryScheduleBLService;
import bussinesslogicservice.examineblservice.ExamineBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.findtype.FindSaleScheduleType;
import javafx.util.converter.LocalDateStringConverter;
import vo.billvo.financialbillvo.AccountListVO;
import vo.billvo.financialbillvo.ReceiptBillVO;

public class BussinessHistoryScheduleReceiveBL implements BusinessHistoryScheduleBLService<ReceiptBillVO> {

	private ExamineBLService<ReceiptBillVO> examineBLService;
	private ReceiptBillBLService receiptBillBLService;
	
	public BussinessHistoryScheduleReceiveBL() {
		examineBLService=new ExamineReceiptBL();
		receiptBillBLService=new ReceiptBillController();
	}
	
	
	@Override
	public ArrayList<ReceiptBillVO> show() {
		return receiptBillBLService.show();
	}

	@Override
	public ArrayList<ReceiptBillVO> siftTime(LocalDate start, LocalDate end) {
		
		ArrayList<ReceiptBillVO> out=new ArrayList<>();
		ArrayList<ReceiptBillVO> receiptBillVOs=receiptBillBLService.show();
		for (int i = 0; i < receiptBillVOs.size(); i++) {
			LocalDate localDate=StringtoDate(receiptBillVOs.get(i).getId());
			if(localDate.isBefore(end)&&localDate.isAfter(start)){
				out.add(receiptBillVOs.get(i));
			}
		}
		return out;
	}
	
	/**
	 * 筛选条件：客户、业务员
	 */
	@Override
	public ArrayList<ReceiptBillVO> sift(String info, FindSaleScheduleType type) {
		ArrayList<ReceiptBillVO> out=new ArrayList<>();
		ArrayList<ReceiptBillVO> receiptBillVOs=receiptBillBLService.show();
		if(type==FindSaleScheduleType.OPERATOR){
			for (int i = 0; i < receiptBillVOs.size(); i++) {
				String userID=receiptBillVOs.get(i).getId();
				if(userID.equals(info)){
					out.add(receiptBillVOs.get(i));
				}
			}
		}
		if(type==FindSaleScheduleType.MEMBER){
			for (int i = 0; i < receiptBillVOs.size(); i++) {
				String customerID=receiptBillVOs.get(i).getCustomerID();
				if(customerID.equals(info)){
					out.add(receiptBillVOs.get(i));
				}
			} 
		}		
		return out;
	}

	@Override
	public void exportReport(ArrayList<ReceiptBillVO> table) {
		
	}

	@Override
	public ArrayList<ReceiptBillVO> writeOff(ArrayList<ReceiptBillVO> table) {
		ArrayList<ReceiptBillVO> rList=new ArrayList<>();
		for (int i = 0; i < table.size(); i++) {
			ReceiptBillVO receiptBillVO=redRush(table.get(i));
			receiptBillVO.setState(BillState.COMMITED);
			receiptBillBLService.save(receiptBillVO);//存入红冲创建的新单据
			rList.add(receiptBillVO);
		}
		try {
			examineBLService.passBills(rList);
			return rList;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<ReceiptBillVO> writeOffAndCopy(ArrayList<ReceiptBillVO> table) {
		ArrayList<ReceiptBillVO> rList=new ArrayList<>();
		for (int i = 0; i < table.size(); i++) {
			ReceiptBillVO receiptBillVO=redRush(table.get(i));
			receiptBillVO.setState(BillState.COMMITED);
			receiptBillBLService.save(receiptBillVO);//存入红冲创建的新单据
			rList.add(receiptBillVO);
		}
		return rList;
	}

	public LocalDate StringtoDate(String id){//id是单据编号
		String s=id.split("-")[1];
		String date=s.substring(0,4)+"-"+s.substring(4,6)+"-"+s.substring(6, s.length());
		LocalDate l=null;
		LocalDateStringConverter localDate =new LocalDateStringConverter();
		l=localDate.fromString(date);
		return l;
	}
	
	public ReceiptBillVO redRush(ReceiptBillVO receiptBillVO){
		String customerID=receiptBillVO.getCustomerID();
		String userID=receiptBillVO.getUserID();
		String note=receiptBillVO.getNote();
		BillState billState=receiptBillVO.getState();
		BillType billType=receiptBillVO.getType();
		//以上是不会变化的单据属性
		//单据的id要另外存取
		String docID=receiptBillBLService.getId();
		//以下是会将数值取负的单据属性
		double total=-receiptBillVO.getTotal();
		ArrayList<AccountListVO> aVOs=new ArrayList<>();
		ArrayList<AccountListVO> accountListVOs=receiptBillVO.getAccountListVOs();
		for (int i = 0; i < accountListVOs.size(); i++) {
			aVOs.add(new AccountListVO(accountListVOs.get(i).getAccountID(), -accountListVOs.get(i).getMoney(), accountListVOs.get(i).getNote()));
		}
		return new ReceiptBillVO(docID, userID, customerID, billType, billState, aVOs, total, note);
	}
	
}
