package SIMSclient.src.vo.purchase;

import java.util.ArrayList;
import java.util.Date;

import SIMSclient.src.vo.bill.PurchaseAndSalesBillVO;
import SIMSclient.src.vo.bill.WareHouse;
import SIMSclient.src.vo.commodity.CommodityVO;

/**  
* ��˵��   
*  
* @author ****  
* @date 2017��10��22��    
*/
public class PurchaseVO extends PurchaseAndSalesBillVO{

	public String clientID;
	public String supplier;  //��Ӧ��
	
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
	public PurchaseVO(String i, Date d, BillState s, String des, WareHouse warehouse, String operator, int amount,
			ArrayList<CommodityVO> commodityList, String id, String supplier) {
		super(i, d, s, des, warehouse, operator, amount, commodityList);
		this.clientID = id;
		this.supplier = supplier;
	}
	
	
	
}
