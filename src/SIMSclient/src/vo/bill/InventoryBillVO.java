package SIMSclient.src.vo.bill;

import java.util.Date;
import SIMSclient.src.vo.commodity.CommodityVO;

public class InventoryBillVO extends BillVO{

	CommodityVO vo;

	public InventoryBillVO(String i, Date d, BillState s,BillType t, String des,CommodityVO v) {
		super(i, d, s,t, des);
		vo = v;
	}

	public CommodityVO getCommodity(){
		return vo;
	}

}
