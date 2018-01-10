package data_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import dataservice.accountbilldataservice.ReceiptBillDataService;
import po.FinancialBill.AccountListPO;
import po.FinancialBill.ReceiptBillPO;

/**     
*  
* @author Lijie 
* @date 2018��1��10��    
*/
public class ReceiptBillDataService_Stub implements ReceiptBillDataService{

	@Override
	public ResultMessage insertReceiptBill(ReceiptBillPO po) throws RemoteException {
		System.out.println("Insert Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deleteReceiptBill(String id) throws RemoteException {
		System.out.println("Delete Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage updateReceiptBill(ReceiptBillPO po) throws RemoteException {
		System.out.println("Update Succeed!");
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<ReceiptBillPO> findReceiptBill(String keyword, FindAccountBillType type) throws RemoteException {
		ArrayList<AccountListPO> accountList = new ArrayList<>();
		AccountListPO account1 = new AccountListPO("00001",5000.00,"CNJDAN");
		AccountListPO account2 = new AccountListPO("00002",4000.00,"CADCACDA");
		accountList.add(account1);
		accountList.add(account2);

		ReceiptBillPO bill = new ReceiptBillPO("SKD-20180105-00001","Panxy","00001",BillType.SKD,BillState.DRAFT,accountList,9000.00,"ncidan");

		ArrayList<ReceiptBillPO> list = new ArrayList<>();
		list.add(bill);
		return list;
	}

	@Override
	public ArrayList<ReceiptBillPO> showReceiptBill() throws RemoteException {
		ArrayList<AccountListPO> accountList = new ArrayList<>();
		AccountListPO account1 = new AccountListPO("00001",5000.00,"CNJDAN");
		AccountListPO account2 = new AccountListPO("00002",4000.00,"CADCACDA");
		accountList.add(account1);
		accountList.add(account2);

		ReceiptBillPO bill = new ReceiptBillPO("SKD-20180105-00001","Panxy","00001",BillType.SKD,BillState.DRAFT,accountList,9000.00,"ncidan");

		ArrayList<ReceiptBillPO> list = new ArrayList<>();
		list.add(bill);
		return list;
	}

}
