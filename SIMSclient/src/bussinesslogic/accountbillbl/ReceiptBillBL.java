package bussinesslogic.accountbillbl;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogic.accountbl.AccountController;
import bussinesslogic.memberbl.MemberController;
import bussinesslogicservice.accountbillblservice.ReceiptBillBLService;
import bussinesslogicservice.accountblservice.AccountBLService;
import bussinesslogicservice.memberblservice.MemberBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import dataservice.accountbilldataservice.ReceiptBillDataService;
import javafx.util.converter.LocalDateStringConverter;
import po.FinancialBill.ReceiptBillPO;
import rmi.RemoteHelper;
import vo.accountvo.AccountVO;
import vo.billvo.financialbillvo.ReceiptBillVO;

public class ReceiptBillBL implements ReceiptBillBLService{

	private ReceiptBillVO receiptBillVO;
	private ReceiptBillPO receiptBillPO;
	
	private ReceiptBillTransition receiptBillTransition;
	private ReceiptBillDataService receiptBillDataService;
	
	private AccountBLService accountBLService;
	private MemberBLService memberBLService;

	public ReceiptBillBL() {
		receiptBillTransition=new ReceiptBillTransition();
		receiptBillDataService=RemoteHelper.getInstance().getReceiptDataService();
		accountBLService=new AccountController();
		memberBLService=new MemberController();
	}
	
	@Override
	public ResultMessage save(ReceiptBillVO receiptBillVO) {
		receiptBillPO=receiptBillTransition.VOtoPO(receiptBillVO);
		ArrayList<ReceiptBillPO> receiptBillPOs=null;
		try {
			receiptBillPOs=receiptBillDataService.findReceiptBill(receiptBillVO.getId(), FindAccountBillType.BILLID);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		if(receiptBillPOs.isEmpty()){
			try {
				try {
					String customerID="";
					String customer=receiptBillVO.getCustomer();
					for (int i = 0; i < customer.length(); i++) {
						if('('==customer.charAt(i)){
							for (int j = i+1; j < customer.length(); j++) {
								if(')'!=customer.charAt(j)){
									customerID+=customer.charAt(j);
								}
								else{
									break;
								}
							}
							break;
						}
					}
					receiptBillVO.setCustomerID(customerID);
				return receiptBillDataService.insertReceiptBill(receiptBillPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		else{
			try {
				return receiptBillDataService.updateReceiptBill(receiptBillPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ResultMessage delete(ReceiptBillVO receiptBillVO) {
		String id=receiptBillVO.getId();
		try {
			return receiptBillDataService.deleteReceiptBill(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ArrayList<ReceiptBillVO> show() {
		ArrayList<ReceiptBillVO> aBillVOs=new ArrayList<>();
		try {
			ArrayList<ReceiptBillPO> aBillPOs=receiptBillDataService.showReceiptBill();
			for (int i = 0; i < aBillPOs.size(); i++) {
				receiptBillVO=receiptBillTransition.POtoVO(aBillPOs.get(i));
				aBillVOs.add(receiptBillVO);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return aBillVOs;
	}

	@Override
	public ArrayList<ReceiptBillVO> find(String info, FindAccountBillType type) {
		ArrayList<ReceiptBillVO> aBillVOs=new ArrayList<>();
		try {
			ArrayList<ReceiptBillPO> aBillPOs=receiptBillDataService.findReceiptBill(info, type);
			for (int i = 0; i < aBillPOs.size(); i++) {
				receiptBillVO=receiptBillTransition.POtoVO(aBillPOs.get(i));
				aBillVOs.add(receiptBillVO);
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
	public ResultMessage commit(ReceiptBillVO receiptBillVO) {
		receiptBillVO.setState(BillState.COMMITED);
		receiptBillPO=receiptBillTransition.VOtoPO(receiptBillVO);
		try {
			return receiptBillDataService.updateReceiptBill(receiptBillPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public String getId() {
		LocalDate l=null;
		l=LocalDate.now();
		int count=0;
		try {
			ArrayList<ReceiptBillPO> receiptBillPOs=receiptBillDataService.showReceiptBill();
			for (int i = 0; i < receiptBillPOs.size(); i++) {
				if(l==StringtoDate(receiptBillPOs.get(i).getDocID()))
					count++;
			}
			count+=1;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		String number=Integer.toString(count);
		while (5>number.length()) {
			number="0"+number;
		}
		String[] date=l.toString().split("-");
		String id="";
		id=BillType.SKD.prefix+"-"+date[0]+date[1]+date[2]+"-"+number;
		
		return id;
	}
	
	public LocalDate StringtoDate(String id){//id «µ•æ›±‡∫≈
		String s=id.split("-")[1];
		String date=s.substring(0,4)+"-"+s.substring(4,6)+"-"+s.substring(6, s.length());
		LocalDate l=null;
		LocalDateStringConverter localDate =new LocalDateStringConverter();
		l=localDate.fromString(date);
		return l;
	}

}
