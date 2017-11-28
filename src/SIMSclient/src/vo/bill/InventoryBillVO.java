package SIMSclient.src.vo.bill;

import java.util.Date;

import SIMSclient.src.dataenum.BillState;
import SIMSclient.src.dataenum.BillType;
import SIMSclient.src.vo.commodity.CommodityVO;

public class InventoryBillVO extends BillVO{

	CommodityVO vo;

	

	public CommodityVO getCommodity(){
		return vo;
	}

}
