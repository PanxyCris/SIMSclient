package SIMSclient.src.bussinesslogic.salesbl;

import java.util.ArrayList;
import java.util.Date;

import SIMSclient.src.dataenum.BillState;
import SIMSclient.src.dataenum.BillType;
import SIMSclient.src.dataenum.Warehouse;
import SIMSclient.src.po.sales.CommodityItemPO;
import SIMSclient.src.po.sales.SalesPO;
import SIMSclient.src.vo.sale.CommodityItemVO;
import SIMSclient.src.vo.sale.SalesVO;

/**  
* 用于PO与VO的相互转换     
*/
public class SalesTransition {

	public static SalesPO VOtoPO(SalesVO vo) {
		String id = vo.id;
		String retailerId = vo.clientID;
		String retailer = vo.retailer;  //销售商客户
		String salesMan = vo.saleMan;  //业务员
		String operator = vo.operator;  //操作员
		Warehouse warehouse = vo.warehouse;
		ArrayList<CommodityItemPO> commodity = null;
		double beforePrice = vo.beforePrice;
		double allowance = vo.allowance;  //折让
		double voucher = vo.voucher; //使用代金券金额
		double afterPrice = vo.sum;
		String remark = vo.description;  //备注
		BillType type = vo.type;
		SalesPO po = new SalesPO(id, retailerId, retailer, salesMan, operator, 
				warehouse, beforePrice, allowance, voucher, afterPrice, remark, commodity);
		return po;
	}
	
	public static SalesVO POtoVO(SalesPO po) {
		String id = po.ID;
		Date date = null;
		String retailerId = po.clientID;
		String retailer = po.clientName;
		String salesMan = po.saleMan;
		String operator = po.operator;
		Warehouse warehouse = po.warehouse;
		ArrayList<CommodityItemVO> commodity = null;
		double beforePrice = po.beforePrice;
		double allowance = po.allowance;  //折让
		double voucher = po.voucher; //使用代金券金额
		double afterPrice = po.afterPrice;
		String remark = po.remark;  //备注
		BillType type = null;
		BillState state = null;
		SalesVO vo = new SalesVO(id, date, retailerId, retailer, salesMan, operator, 
				warehouse, commodity, beforePrice, allowance, voucher, afterPrice, remark, state, type);
		return vo;
	}
}
