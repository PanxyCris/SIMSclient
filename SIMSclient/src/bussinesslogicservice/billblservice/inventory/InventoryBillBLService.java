package bussinesslogicservice.billblservice.inventory;

import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindInventoryBillType;
import vo.billvo.inventorybillvo.InventoryBillVO;

public interface InventoryBillBLService {

	ArrayList<InventoryBillVO> find(String text, FindInventoryBillType type);

	InventoryBillVO show();

	ResultMessage submit(InventoryBillVO clickedItem);

	void delete(InventoryBillVO clickedItem);

	ResultMessage save(InventoryBillVO vo);

	String getId();

}
