package SIMSclient.src.vo.bill;

import java.util.ArrayList;
import java.util.Date;

import SIMSclient.src.vo.commodity.CommodityVO;

/**  
* ��˵��   
*  
* @author ****  
* @date 2017��11��7��    
*/
public class PurchaseAndSalesBillVO extends BillVO {
	
	private WareHouse warehouse; //�ֿ�
	private String Operator;  //����Ա
	private int amount;  //�ܶ�
	private ArrayList<CommodityVO> commodityList;  //��Ʒ�嵥
	public PurchaseAndSalesBillVO(String i, Date d, BillState s, String des) {
		super(i, d, s, des);
		
	}
	/**
	 * @param i
	 * @param d
	 * @param s
	 * @param des
	 * @param warehouse
	 * @param operator
	 * @param amount
	 * @param commodityList
	 */
	public PurchaseAndSalesBillVO(String i, Date d, BillState s, String des, WareHouse warehouse, String operator,
			int amount, ArrayList<CommodityVO> commodityList) {
		super(i, d, s, des);
		this.warehouse = warehouse;
		Operator = operator;
		this.amount = amount;
		this.commodityList = commodityList;
	}

	
	
}
