package bussinesslogic.billbl.inventory;

import java.util.ArrayList;

import bussinesslogicservice.billblservice.inventory.InventoryBillBLService;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindInventoryBillType;
import vo.billvo.inventorybillvo.InventoryBillVO;

public class InventoryBillBL implements InventoryBillBLService{

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
