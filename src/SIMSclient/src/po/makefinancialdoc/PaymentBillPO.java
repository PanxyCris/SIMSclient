package SIMSclient.src.po.makefinancialdoc;

import java.util.Date;

/**
 * 付款单
 * @author xxx
 *
 */
@SuppressWarnings("serial")
public class PaymentBillPO extends FinancialDocPO {
	String docID;// 单据编号
	String userID;// 操作员(当前登录用户)
	String accountID;// 银行账户ID

	// 条目清单
	String entryName;// 条目名
	int transferAmount;// 金额
	String note;// 备注

	int total;// 总额

	/**
	 * @param d
	 * @param u
	 * @param n
	 * @param docID
	 * @param userID
	 * @param accountID
	 * @param entryName
	 * @param transferAmount
	 * @param note
	 * @param total
	 */
	public PaymentBillPO(String d, int u, String n, Date date, String docID, String userID, String accountID, String entryName,
			int transferAmount, String note, int total) {
		super(d, u, n, date);
		this.docID = docID;
		this.userID = userID;
		this.accountID = accountID;
		this.entryName = entryName;
		this.transferAmount = transferAmount;
		this.note = note;
		this.total = total;
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

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getEntryName() {
		return entryName;
	}

	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}

	public int getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(int transferAmount) {
		this.transferAmount = transferAmount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
