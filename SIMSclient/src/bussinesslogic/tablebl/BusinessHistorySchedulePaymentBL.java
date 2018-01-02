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
import dataenum.ResultMessage;
import dataenum.findtype.FindSaleScheduleType;
import javafx.util.converter.LocalDateStringConverter;
import vo.billvo.financialbillvo.EntryVO;
import vo.billvo.financialbillvo.PaymentBillVO;

//������ɴ�������
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
	 * ɸѡ�������ͻ���ҵ��Ա
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

	@Override//�������һ���ĵ��ݵĻ��Ƿ���ζ�ŵ��ݵ�idҲһ�������ǵĻ�����ô�棿
	public ArrayList<PaymentBillVO> writeOff(ArrayList<PaymentBillVO> table) {//�������ܾ���
		ArrayList<PaymentBillVO> pArrayList=new ArrayList<>();
		for (int i = 0; i < table.size(); i++) {
			PaymentBillVO paymentBillVO=redRush(table.get(i));
			paymentBillVO.setState(BillState.COMMITED);
			paymentBillBLService.save(paymentBillVO);
			pArrayList.add(paymentBillVO);
		}
		try {
			examineBLService.passBills(pArrayList);
			return pArrayList;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<PaymentBillVO> writeOffAndCopy(ArrayList<PaymentBillVO> table) {//�������ܾ���
		ArrayList<PaymentBillVO> pArrayList=new ArrayList<>();
		for (int i = 0; i < table.size(); i++) {
			PaymentBillVO paymentBillVO=redRush(table.get(i));
			paymentBillVO.setState(BillState.COMMITED);
			paymentBillBLService.save(paymentBillVO);
			pArrayList.add(paymentBillVO);
		}
		return pArrayList;
	}

	public LocalDate StringtoDate(String id){//id�ǵ��ݱ��
		String s=id.split("-")[1];
		String date=s.substring(0,4)+"-"+s.substring(4,6)+"-"+s.substring(6, s.length());
		LocalDate l=null;
		LocalDateStringConverter localDate =new LocalDateStringConverter();
		l=localDate.fromString(date);
		return l;
	}
	
	public PaymentBillVO redRush(PaymentBillVO paymentBillVO){//�������ת������
		String customerID=paymentBillVO.getCustomerID();
		String userID=paymentBillVO.getUserID();
		String accountID=paymentBillVO.getAccountID();
		String note=paymentBillVO.getNote();
		BillState billState=paymentBillVO.getState();
		BillType billType=paymentBillVO.getType();
		//�����ǲ���仯�ĵ�������
		//���ݵ�idҪ�����ȡ
		String docID=paymentBillBLService.getId();
		//�����ǻὫ��ֵȡ���ĵ�������
		double total=-paymentBillVO.getTotal();
		ArrayList<EntryVO> eVOs=new ArrayList<>();
		ArrayList<EntryVO> entryVOs=paymentBillVO.getEntryListVO();
		for (int i = 0; i < entryVOs.size(); i++) {
			eVOs.add(new EntryVO(entryVOs.get(i).getEntryName(),-entryVOs.get(i).getTransferAmount(), entryVOs.get(i).getNote()));
		}
		return new PaymentBillVO(docID, userID, customerID, accountID, eVOs, total, billType, billState, note);
	}

	@Override
	public ResultMessage updateBill(ArrayList<PaymentBillVO> table) {
		ArrayList<PaymentBillVO> pList=new ArrayList<>();
		for (int i = 0; i < table.size(); i++) {
			PaymentBillVO paymentBillVO=table.get(i);
			paymentBillVO.setState(BillState.COMMITED);
			paymentBillBLService.save(paymentBillVO);
			pList.add(paymentBillVO);
		}
		try {
			examineBLService.passBills(pList);
			return ResultMessage.SUCCESS;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}
	
}
