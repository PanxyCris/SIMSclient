package vo.inventorybill;

import dataenum.BillState;
import dataenum.BillType;
import vo.billvo.BillVO;
import vo.commodity.CommodityVO;

public class InventoryBillVO extends BillVO{

	CommodityVO vo;

	public InventoryBillVO(BillType billType, BillState billState) {
		super(billType, billState);
	}

	public CommodityVO getCommodity(){
		return vo;
	}

}
