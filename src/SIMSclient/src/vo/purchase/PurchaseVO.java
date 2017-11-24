package SIMSclient.src.vo.purchase;

import java.util.ArrayList;
import java.util.Date;

import SIMSclient.src.dataenum.BillState;
import SIMSclient.src.dataenum.BillType;
import SIMSclient.src.dataenum.Warehouse;
import SIMSclient.src.vo.bill.PurchaseAndSalesBillVO;
import SIMSclient.src.vo.bill.WareHouse;
import SIMSclient.src.vo.commodity.CommodityVO;
import SIMSclient.src.vo.sale.CommodityItemVO;

/**  
* 类说明   
*  
* @author ****  
* @date 2017年10月22日    
*/
public class PurchaseVO extends PurchaseAndSalesBillVO{

	public String clientID;
	public String supplier;  //供应商
	
	
	public PurchaseVO(String i, Date d, BillState s, BillType t, String des, Warehouse warehouse, String operator,
			double sum, ArrayList<CommodityItemVO> commodityList, String clientID, String supplier) {
		super(i, d, s, t, des, warehouse, operator, sum, commodityList);
		this.clientID = clientID;
		this.supplier = supplier;
	}
	
	
	
	
}
