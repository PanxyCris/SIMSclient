package SIMSclient.src.vo.bill;

import java.util.ArrayList;
import java.util.Date;

import SIMSclient.src.vo.commodity.CommodityVO;

/**  
* 类说明   
*  
* @author ****  
* @date 2017年11月7日    
*/
public class PurchaseAndSalesBillVO extends BillVO {
	
	private WareHouse warehouse; //仓库
	private String Operator;  //操作员
	private int amount;  //总额
	private ArrayList<CommodityVO> commodityList;  //商品清单
	
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
	public PurchaseAndSalesBillVO(String i, Date d, BillState s, BillType t, String des, WareHouse warehouse,
			String operator, int amount, ArrayList<CommodityVO> commodityList) {
		super(i, d, s, t, des);
		this.warehouse = warehouse;
		Operator = operator;
		this.amount = amount;
		this.commodityList = commodityList;
	}	
	
}
