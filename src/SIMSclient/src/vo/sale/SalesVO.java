package SIMSclient.src.vo.sale;

import java.util.ArrayList;
import java.util.Date;

import SIMSclient.src.dataenum.BillState;
import SIMSclient.src.dataenum.BillType;
import SIMSclient.src.dataenum.Warehouse;
import SIMSclient.src.vo.bill.PurchaseAndSalesBillVO;
import SIMSclient.src.vo.bill.WareHouse;

public class SalesVO extends PurchaseAndSalesBillVO {
	public String clientID;
	public String retailer; // 客户姓名
	public String saleMan; // 业务员
	public double beforePrice; // 折让前价格
	public double allowance; // 折让金额
	public double voucher; // 代金券金额

	public SalesVO(String i, Date d, String clientID, String retailer, String saleMan, String operator,
			Warehouse warehouse, ArrayList<CommodityItemVO> commodityList, double beforePrice, double allowance,
			double voucher, double amount, String des, BillState s, BillType t) {
		super(i, d, s, t, des, warehouse, operator, amount, commodityList);
		this.clientID = clientID;
		this.retailer = retailer;
		this.saleMan = saleMan;
		this.beforePrice = beforePrice;
		this.allowance = allowance;
		this.voucher = voucher;
	}

}