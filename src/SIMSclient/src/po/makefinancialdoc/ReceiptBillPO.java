package SIMSclient.src.po.makefinancialdoc;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ���Ӳ�
 * @version 2017-12-2
 *
 */
@SuppressWarnings("serial")
public class ReceiptBillPO extends FinancialDocPO {
	private String docID;//���ݱ��
	private String userID;//��ǰ��¼�û���ID
	private ArrayList<String> accountName;//�����˻����������list��ֻ�����һ�������˻�������Ϊ�˼��ٴ��룬������Ȼ��list�洢
	private ArrayList<String> money;//ת���ܽ��(transferAmount��ֵ���ܺ�)��ʹ��list����ͬaccountName
	private String customerID;//�ͻ�ID

	// ��Ŀ�嵥
	private ArrayList<String> entryName;// ��Ŀ��
	private ArrayList<String> transferAmount;// ���
	private String note;// ��ע

	public ReceiptBillPO(String docID, String userID, ArrayList<String> accountName, ArrayList<String> money, String customerID,
			String note,ArrayList<String> entryName,ArrayList<String> transferAmount) {
		super(docID,userID,accountName,money,customerID,note);
		this.entryName=entryName;
		this.transferAmount=transferAmount;
	}

	public String getDocID() {
		return docID;
	}

	public void setDocID(String docID) {
		this.docID = docID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public ArrayList<String> getAccountName() {
		return accountName;
	}

	public void setAccountName(ArrayList<String> accountName) {
		this.accountName = accountName;
	}

	public ArrayList<String> getMoney() {
		return money;
	}

	public void setMoney(ArrayList<String> money) {
		this.money = money;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public ArrayList<String> getEntryName() {
		return entryName;
	}

	public void setEntryName(ArrayList<String> entryName) {
		this.entryName = entryName;
	}

	public ArrayList<String> getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(ArrayList<String> transferAmount) {
		this.transferAmount = transferAmount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}
