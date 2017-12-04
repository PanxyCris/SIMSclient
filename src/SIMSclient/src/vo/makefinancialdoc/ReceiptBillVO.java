package SIMSclient.src.vo.makefinancialdoc;

import java.util.ArrayList;

import SIMSclient.src.dataenum.BillState;
import SIMSclient.src.dataenum.BillType;

@SuppressWarnings("serial")
public class ReceiptBillVO extends FinancialDocVO {

	// ��Ŀ�嵥
	private ArrayList<String> entryName;// ��Ŀ��
	private ArrayList<String> transferAmount;// ���
	
	private EntryListVO entryListVO;

	public ReceiptBillVO(String docID, String userID, ArrayList<String> accountName, ArrayList<String> money, String customerID,
			ArrayList<String> note,ArrayList<String> entryName,ArrayList<String> transferAmount,BillType billType,BillState billState) {
		super(docID,userID,accountName,money,customerID,note,billType,billState);
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
