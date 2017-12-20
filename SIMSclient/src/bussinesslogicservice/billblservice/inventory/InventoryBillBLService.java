package bussinesslogicservice.billblservice.inventory;

import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindInventoryBillType;
import vo.billvo.inventorybillvo.InventoryBillVO;

public interface InventoryBillBLService{

	public ResultMessage save(InventoryBillVO bill);

	public ResultMessage submit(InventoryBillVO bill);

	public void delete(InventoryBillVO bill);

	public String getId();

	public ArrayList<InventoryBillVO> show();

	public ArrayList<InventoryBillVO> find(String info,FindInventoryBillType type);

}
