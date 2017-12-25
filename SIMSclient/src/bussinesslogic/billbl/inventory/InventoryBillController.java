package bussinesslogic.billbl.inventory;

import java.util.ArrayList;

import bussinesslogicservice.billblservice.inventory.InventoryBillBLService;
import dataenum.ResultMessage;
import dataenum.findtype.FindInventoryBillType;
import vo.billvo.inventorybillvo.InventoryBillVO;

public class InventoryBillController implements InventoryBillBLService {

	@Override
	public ArrayList<InventoryBillVO> find(String text, FindInventoryBillType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InventoryBillVO show() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage submit(InventoryBillVO clickedItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(InventoryBillVO clickedItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultMessage save(InventoryBillVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
