package bussinesslogic.billbl.inventory;

import java.util.ArrayList;

import bussinesslogic.billbl.inventory.Gift.GiftBillController;
import bussinesslogic.billbl.inventory.Loss.LossBillController;
import bussinesslogic.billbl.inventory.Revenue.RevenueBillController;
import bussinesslogic.billbl.inventory.Warn.WarnBillController;
import bussinesslogicservice.billblservice.inventory.InventoryBillBLService;
import dataenum.ResultMessage;
import dataenum.findtype.FindInventoryBillType;
import vo.billvo.inventorybillvo.InventoryBillVO;

public class InventoryBillController implements InventoryBillBLService {

	WarnBillController warnBillController;
	RevenueBillController revenueBillController;
	LossBillController lossBillController;
	GiftBillController giftBillController;
	
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
	public String getId() {//得到新建单据的Id
		return null;
	}

}
