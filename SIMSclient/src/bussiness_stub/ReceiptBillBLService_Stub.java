package bussiness_stub;

import java.util.ArrayList;

import bussinesslogicservice.accountbillblservice.ReceiptBillBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.MemberCategory;
import dataenum.MemberLevel;
import dataenum.ResultMessage;
import vo.AccountVO;
import vo.FinancialBill.AccountListVO;
import vo.FinancialBill.ReceiptBillVO;
import vo.member.MemberVO;

public class ReceiptBillBLService_Stub implements ReceiptBillBLService {

	@Override
	public ResultMessage save(ReceiptBillVO receiptBillVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(ReceiptBillVO receiptBillVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<ReceiptBillVO> find() {
		// TODO Auto-generated method stub
		ArrayList<AccountListVO> accountList = new ArrayList<>();
		AccountListVO account1 = new AccountListVO("00001","5000","CNJDAN");
		AccountListVO account2 = new AccountListVO("00002","4000","CADCACDA");
		accountList.add(account1);
		accountList.add(account2);
		ArrayList<ReceiptBillVO> list = new ArrayList<>();
		ReceiptBillVO bill = new ReceiptBillVO("00001","Panxy","00001",BillType.XJFYD,BillState.DRAFT,accountList,"9000");
		list.add(bill);
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

	@Override
	public ResultMessage judgeLegal(String money) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage commit(ReceiptBillVO receiptBillVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
