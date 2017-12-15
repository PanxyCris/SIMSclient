package bussiness_stub;

import java.util.ArrayList;

import bussinesslogicservice.accountbillblservice.PaymentBillBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.MemberCategory;
import dataenum.MemberLevel;
import dataenum.ResultMessage;
import vo.AccountVO;
import vo.FinancialBill.EntryVO;
import vo.FinancialBill.PaymentBillVO;
import vo.member.MemberVO;

public class PaymentBillBLService_Stub implements PaymentBillBLService {

	@Override
	public ResultMessage save(PaymentBillVO paymentBillVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(PaymentBillVO paymentBillVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}



	@Override
	public ResultMessage judgeLegal(String money) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage commit(PaymentBillVO paymentBillVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<PaymentBillVO> find() {
		ArrayList<EntryVO> entryList = new ArrayList<>();
		EntryVO entry1 = new EntryVO("QWERT","20","NCFIDJCN");
		EntryVO entry2 = new EntryVO("RAT","789","NCJDJC");
		entryList.add(entry1);
		entryList.add(entry2);

		ArrayList<PaymentBillVO> list = new ArrayList<>();
		PaymentBillVO bill1 = new PaymentBillVO("00001","Panxy","00001","00001",entryList,"809",BillType.XJFYD,BillState.DRAFT);
		list.add(bill1);
		return list;
	}

	@Override
	public ArrayList<AccountVO> getAccountList() {
		ArrayList<AccountVO> list = new ArrayList<>();
		AccountVO account1 = new AccountVO("00001","cancan","20000");
		AccountVO account2 = new AccountVO("00002","lijie","50000");
		list.add(account1);
		list.add(account2);
		return list;
	}

	@Override
	public ArrayList<MemberVO> getCustomerList() {
		MemberVO member1 = new MemberVO("00001",MemberCategory.SUPPLIER,MemberLevel.LEVEL5,"李杰","1591515","南京大学",
				"210064","lq@qq.com","50","20","50","NJU");
		MemberVO member2 = new MemberVO("00002",MemberCategory.RETAILER,MemberLevel.LEVEL4,"NJU","15cs515","南京大学",
				"210064","lq@qq.com","50","20","50","NJU");
		System.out.println("Show Succeed!\n");
		ArrayList<MemberVO> list = new ArrayList<>();
		list.add(member1);
		list.add(member2);
		return list;
	}

}
