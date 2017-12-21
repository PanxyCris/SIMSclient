package vo.billvo.inventorybillvo;

import java.util.ArrayList;

import dataenum.BillState;

import dataenum.BillType;
import vo.billvo.BillVO;
import vo.commodityvo.GiftVO;

public class InventoryBillVO extends BillVO{

	private ArrayList<GiftVO> gifts;

	public InventoryBillVO(String id,ArrayList<GiftVO> gifts,BillType billType, BillState billState,String note) {
		super(id,billType, billState,note);
		this.setGifts(gifts);
	}

	public ArrayList<GiftVO> getGifts() {
		return gifts;
	}

	public void setGifts(ArrayList<GiftVO> gifts) {
		this.gifts = gifts;
	}



}
