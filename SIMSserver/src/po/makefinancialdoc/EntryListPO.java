package SIMSserver.src.po.makefinancialdoc;

import java.util.ArrayList;

public class EntryListPO {
	
	// ��Ŀ�嵥
		protected ArrayList<String> entryName;// ��Ŀ��
		protected ArrayList<String> transferAmount;// ���
		protected ArrayList<String> note;// ��ע
		
		public EntryListPO(ArrayList<String> entryName,ArrayList<String> transferAmount,ArrayList<String> note) {
			this.transferAmount=transferAmount;
			this.entryName=entryName;
			this.note=note;
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

		public ArrayList<String> getNote() {
			return note;
		}

		public void setNote(ArrayList<String> note) {
			this.note = note;
		}
	
}
