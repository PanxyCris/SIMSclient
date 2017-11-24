package SIMSclient.src.vo.bill;

import java.util.ArrayList;
import java.util.Date;

import SIMSclient.src.dataenum.BillState;
import SIMSclient.src.dataenum.BillType;
import SIMSclient.src.dataenum.Warehouse;
import SIMSclient.src.vo.commodity.CommodityVO;
import SIMSclient.src.vo.sale.CommodityItemVO;

public class PurchaseAndSalesBillVO extends BillVO {
	
	public Warehouse warehouse; //�ֿ�
	public String operator;  //����Ա
	public double sum;  //�ܶ�
	public ArrayList<CommodityItemVO> commodityList;  //��Ʒ�嵥
	
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
