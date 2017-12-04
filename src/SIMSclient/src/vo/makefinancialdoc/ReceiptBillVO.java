package SIMSclient.src.vo.makefinancialdoc;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class ReceiptBillVO extends FinancialDocVO {

	// 条目清单
	private ArrayList<String> entryName;// 条目名
	private ArrayList<String> transferAmount;// 金额
	
	private EntryListVO entryListVO;

	public ReceiptBillVO(String docID, String userID, ArrayList<String> accountName, ArrayList<String> money, String customerID,
			ArrayList<String> note,ArrayList<String> entryName,ArrayList<String> transferAmount) {
		super(docID,userID,accountName,money,customerID,note);
		entryListVO=new EntryListVO(entryName, transferAmount, note);
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

	public EntryListVO getEntryListVO() {
		return entryListVO;
	}

	public void setEntryListVO(EntryListVO entryListVO) {
		this.entryListVO = entryListVO;
	}

}
