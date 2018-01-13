package po.financialbillpo;

import java.io.Serializable;

public class EntryPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ��Ŀ�嵥
	protected String entryName;// ��Ŀ��
	protected double transferAmount;// ���
	protected String note;// ��ע

	public EntryPO(String entryName, double transferAmount, String note) {
		this.transferAmount = transferAmount;
		this.entryName = entryName;
		this.note = note;
	}

	public String getEntryName() {
		return entryName;
	}

	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}

	public double getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
