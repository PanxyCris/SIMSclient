package vo.purchase;

import java.util.ArrayList;



import dataenum.BillState;
import dataenum.BillType;
import dataenum.Warehouse;
import vo.ViewObject;
import vo.commodity.CommodityItemVO;

public class PurchaseVO extends ViewObject{

	public String supplierID;
	public String supplier;  //供应商
	public Warehouse warehouse;
	public String operator;
	public ArrayList<CommodityItemVO> commodities;  //入库商品列表
	public String sum;
	public String remark;
	public BillType type;
	public BillState state;


	public PurchaseVO(String supplierID, String supplier, Warehouse warehouse, String operator,
			ArrayList<CommodityItemVO> commodities, String sum, String remark, BillType type, BillState state) {
		super();
		this.supplierID = supplierID;
		this.supplier = supplier;
		this.warehouse = warehouse;
		this.operator = operator;
		this.commodities = commodities;
		this.sum = sum;
		this.remark = remark;
		this.type = type;
		this.state = state;
	}


}
