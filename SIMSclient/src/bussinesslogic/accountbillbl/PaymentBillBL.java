package bussinesslogic.accountbillbl;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogic.accountbl.AccountController;
import bussinesslogic.memberbl.MemberController;
import bussinesslogicservice.accountbillblservice.PaymentBillBLService;
import bussinesslogicservice.accountblservice.AccountBLService;
import bussinesslogicservice.memberblservice.MemberBLService;
import dataenum.BillState;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import dataservice.accountbilldataservice.PaymentBillDataService;
import javafx.util.converter.LocalDateStringConverter;
import po.FinancialBill.PaymentBillPO;
import rmi.RemoteHelper;
import vo.accountvo.AccountVO;
import vo.billvo.financialbillvo.PaymentBillVO;


public class PaymentBillBL implements PaymentBillBLService{
	
	private PaymentBillPO paymentBillPO;
	private PaymentBillVO paymentBillVO;
	
	private PaymentBillTransition paymentBillTransition;
	private PaymentBillDataService paymentBillDataService;
	
	private AccountBLService accountBLService;
	private MemberBLService memberBLService;

	public PaymentBillBL() {
		paymentBillTransition=new PaymentBillTransition();
		paymentBillDataService=RemoteHelper.getInstance().getPaymentDataService();	
		accountBLService=new AccountController();
		memberBLService=new MemberController();
	}
	
	
	@Override
	public ResultMessage save(PaymentBillVO paymentBillVO) {
		paymentBillPO=paymentBillTransition.VOtoPO(paymentBillVO);
		ArrayList<PaymentBillPO> paymentBillPOs=null;
		try {
			paymentBillPOs=paymentBillDataService.findPaymentBill(paymentBillVO.getId(), FindAccountBillType.BILLID);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		if(paymentBillPOs.isEmpty()){//找不到，新建
			try {
				return paymentBillDataService.insertPaymentBill(paymentBillPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		else{//找到，修改
			try {
				return paymentBillDataService.updatePaymentBill(paymentBillPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage delete(PaymentBillVO paymentBillVO) {
		String id=paymentBillVO.getId();
		try {
			return paymentBillDataService.deletePaymentBill(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	/**
	 * 仅仅用于手动创建单据时判断，不能用于红冲和红冲并复制
	 */
	@Override
	public ResultMessage judgeLegal(String money) {
		Double m=Double.valueOf(money);
		if(0>m){
			return ResultMessage.FAIL;
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage commit(PaymentBillVO paymentBillVO) {
		paymentBillVO.setState(BillState.COMMITED);
		paymentBillPO=paymentBillTransition.VOtoPO(paymentBillVO);
		try {
			return paymentBillDataService.updatePaymentBill(paymentBillPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<PaymentBillVO> show() {
		ArrayList<PaymentBillVO> aBillVOs=new ArrayList<>();
		try {
			ArrayList<PaymentBillPO> aBillPOs=paymentBillDataService.showPaymentBill();
			for (int i = 0; i < aBillPOs.size(); i++) {
				paymentBillVO=paymentBillTransition.POtoVO(aBillPOs.get(i));
				aBillVOs.add(paymentBillVO);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return aBillVOs;
	}

	@Override
	public ArrayList<PaymentBillVO> find(String info, FindAccountBillType type) {
		ArrayList<PaymentBillVO> aBillVOs=new ArrayList<>();
		try {
			ArrayList<PaymentBillPO> aBillPOs=paymentBillDataService.findPaymentBill(info, type);
			for (int i = 0; i < aBillPOs.size(); i++) {
				paymentBillVO=paymentBillTransition.POtoVO(aBillPOs.get(i));
				aBillVOs.add(paymentBillVO);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return aBillVOs;
	}

	@Override
	public ArrayList<String> getAccountList() {
		ArrayList<String> list=new ArrayList<>();
 		ArrayList<AccountVO> accountVOs=accountBLService.getAccountList();
		String a="";
		for (int i = 0; i < accountVOs.size(); i++) {
			a=accountVOs.get(i).getId()+" "+accountVOs.get(i).getName();
			list.add(a);
		}
		return list;
	}

	@Override
	public ArrayList<String> getCustomerList() {
		ArrayList<String> list = null;
		try {
		 list=memberBLService.getIDandName();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String getId() {
		LocalDate l=null;
		l=LocalDate.now();
		int count=0;
		try {
			ArrayList<PaymentBillPO> paymentBillPOs=paymentBillDataService.showPaymentBill();
			for (int i = 0; i < paymentBillPOs.size(); i++) {
				if(l==StringtoDate(paymentBillPOs.get(i).getID()))
					count++;
			}
			count+=1;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return Integer.toString(count);
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
