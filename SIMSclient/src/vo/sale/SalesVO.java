package vo.sale;

import java.util.ArrayList;


import dataenum.BillState;
import dataenum.BillType;
import dataenum.Warehouse;
import vo.ViewObject;
import vo.commodity.CommodityItemVO;

public class SalesVO extends ViewObject {
	public String retailerID;
	public String retailer; // 客户姓名
	public String saleMan; // 业务员
	public String operator;
	public Warehouse warehouse;
	public ArrayList<CommodityItemVO> commodity;
	public double beforePrice; // 折让前价格
	public double allowance; // 折让金额
	public double voucher; // 代金券金额
	public double afterPrice;
	public String remark;
	public BillState state;
	public BillType type;

	
	public SalesVO(String id, String retailerID, String retailer, String saleMan, String operator, Warehouse warehouse,
			ArrayList<CommodityItemVO> commodity, double beforePrice, double allowance, double voucher,
			double afterPrice, String remark, BillState state, BillType type) {
		super();
		this.id = id;
		this.retailerID = retailerID;
		this.retailer = retailer;
		this.saleMan = saleMan;
		this.operator = operator;
		this.warehouse = warehouse;
		this.commodity = commodity;
		this.beforePrice = beforePrice;
		this.allowance = allowance;
		this.voucher = voucher;
		this.afterPrice = afterPrice;
		this.remark = remark;
		this.state = state;
		this.type = type;
	}

}