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
	private static final long serialVersionUID = 1L;
	// ��Ŀ�嵥
	private ArrayList<String> entryName;// ��Ŀ��
	private ArrayList<String> transferAmount;// ���
	
	private EntryListPO entryListPO;

	public ReceiptBillPO(String docID, String userID, ArrayList<String> accountName, ArrayList<String> money, String customerID,
			ArrayList<String> note,ArrayList<String> entryName,ArrayList<String> transferAmount) {
		super(docID,userID,accountName,money,customerID,note);
		entryListPO=new EntryListPO(entryName, transferAmount, note);
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

	public EntryListPO getEntryListPO() {
		return entryListPO;
	}

	public void setEntryListPO(EntryListPO entryListPO) {
		this.entryListPO = entryListPO;
	}

}
