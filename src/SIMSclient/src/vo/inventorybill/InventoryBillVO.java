package SIMSclient.src.vo.inventorybill;

import java.util.Date;

import SIMSclient.src.dataenum.BillState;
import SIMSclient.src.dataenum.BillType;
import SIMSclient.src.vo.BillVO;
import SIMSclient.src.vo.ValueObject;
import SIMSclient.src.vo.commodity.CommodityVO;

public class InventoryBillVO extends BillVO{
	
	CommodityVO vo;

	public InventoryBillVO(BillType billType, BillState billState) {
		super(billType, billState);
	}
	
	public CommodityVO getCommodity(){
		return vo;
	}

}
