package SIMSclient.src.vo.bill;

import java.util.ArrayList;
import java.util.Date;

import SIMSclient.src.dataenum.BillState;
import SIMSclient.src.dataenum.BillType;
import SIMSclient.src.dataenum.Warehouse;
import SIMSclient.src.vo.commodity.CommodityVO;
import SIMSclient.src.vo.sale.CommodityItemVO;

public class PurchaseAndSalesBillVO extends BillVO {
	
	public Warehouse warehouse; //仓库
	public String operator;  //操作员
	public double sum;  //总额
	public ArrayList<CommodityItemVO> commodityList;  //商品清单
	
	/**
	 * @param i
	 * @param d
	 * @param s
	 * @param t
	 * @param des
	 * @param warehouse
	 * @param operator
	 * @param amount
	 * @param commodityList
	 */
	public PurchaseAndSalesBillVO(String i, Date d, BillState s, BillType t, String des, Warehouse warehouse,
			String operator, double sum, ArrayList<CommodityItemVO> commodityList) {
		super(i, d, s, t, des);
		this.warehouse = warehouse;
		this.operator = operator;
		this.sum = sum;
		this.commodityList = commodityList;
	}	
	
}
