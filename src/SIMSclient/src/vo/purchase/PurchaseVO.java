package SIMSclient.src.vo.purchase;

import java.util.ArrayList;
import java.util.Date;

import SIMSclient.src.vo.bill.PurchaseAndSalesBillVO;
import SIMSclient.src.vo.bill.WareHouse;
import SIMSclient.src.vo.commodity.CommodityVO;

/**  
* 类说明   
*  
* @author ****  
* @date 2017年10月22日    
*/
public class PurchaseVO extends PurchaseAndSalesBillVO{

	public String clientID;
	public String supplier;  //供应商
	
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
	 * @param clientID
	 * @param supplier
	 */
	public PurchaseVO(String i, Date d, BillState s, BillType t, String des, WareHouse warehouse, String operator,
			int amount, ArrayList<CommodityVO> commodityList, String clientID, String supplier) {
		super(i, d, s, t, des, warehouse, operator, amount, commodityList);
		this.clientID = clientID;
		this.supplier = supplier;
	}
	
	
}
