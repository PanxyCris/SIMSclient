package po.inventorybillpo;

import java.util.ArrayList;
import dataenum.BillState;
import dataenum.BillType;
import po.BillPO;
import po.commodity.GiftPO;

public class InventoryBillPO extends BillPO{

	private String id;
	private String note;
	private ArrayList<GiftPO> gifts;

	public InventoryBillPO(String id,ArrayList<GiftPO> gifts,BillType billType, BillState billState,String note) {
		super(billType, billState);
		this.setId(id);
		this.setNote(note);
		this.setGifts(gifts);
	}

	public ArrayList<GiftPO> getGifts() {
		return gifts;
	}

	public void setGifts(ArrayList<GiftPO> gifts) {
		this.gifts = gifts;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}



}
