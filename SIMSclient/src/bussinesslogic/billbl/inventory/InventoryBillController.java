package bussinesslogic.billbl.inventory;

import java.util.ArrayList;

import bussinesslogicservice.billblservice.inventory.InventoryBillBLService;
import dataenum.ResultMessage;
import dataenum.findtype.FindInventoryBillType;
import vo.billvo.inventorybillvo.InventoryBillVO;

public class InventoryBillController implements InventoryBillBLService {

	@Override
	public ResultMessage save(InventoryBillVO bill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage submit(InventoryBillVO bill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(InventoryBillVO bill) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InventoryBillVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InventoryBillVO> find(String info, FindInventoryBillType type) {
		// TODO Auto-generated method stub
		return null;
	}

}
