package bussinesslogic.billbl.inventory.Gift;

import java.util.ArrayList;

import bussinesslogicservice.billblservice.inventory.InventoryGiftBillBLService;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindInventoryBillType;
import vo.billvo.inventorybillvo.InventoryBillVO;

public class GiftBillBL implements InventoryGiftBillBLService{

	@Override
	public ArrayList<InventoryBillVO> find(String text, FindInventoryBillType type) {
		return null;
	}

	@Override
	public ArrayList<InventoryBillVO> show() {
		return null;
	}

	@Override
	public ResultMessage submit(InventoryBillVO clickedItem) {
		return null;
	}

	@Override
	public void delete(InventoryBillVO clickedItem) {
	}

	@Override
	public ResultMessage save(InventoryBillVO vo) {
		return null;
	}

	@Override
	public String getId(BillType type) {
		return null;
	}
	
	
}
