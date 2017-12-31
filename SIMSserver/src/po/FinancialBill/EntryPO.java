package po.FinancialBill;

import java.io.Serializable;
import java.util.ArrayList;

public class EntryPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 条目清单
	protected String entryName;// 条目名
	protected String transferAmount;// 金额
	protected String note;// 备注
	
	public EntryPO(String entryName,String transferAmount,String note) {
		this.transferAmount=transferAmount;
		this.entryName=entryName;
		this.note=note;
	}

	public String getEntryName() {
		return entryName;
	}

	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}

	public String getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(String transferAmount) {
		this.transferAmount = transferAmount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	
}
