package vo.billvo.financialbillvo;

public class EntryVO {
	// ��Ŀ�嵥
	protected String entryName;// ��Ŀ��
	protected Double transferAmount;// ���
	protected String note;// ��ע

	public EntryVO(String entryName, Double transferAmount, String note) {
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

	public Double getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(Double transferAmount) {
		this.transferAmount = transferAmount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
