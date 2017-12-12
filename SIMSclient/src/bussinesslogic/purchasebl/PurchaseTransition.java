package bussinesslogic.purchasebl;

import java.util.ArrayList;

import bussinesslogic.CommodityItemTran;
import po.PurchasePO;
import po.commodity.CommodityItemPO;
import vo.commodity.CommodityItemVO;
import vo.purchase.PurchaseVO;

/**     
*  用于PO与VO的互相转换
* @author Lijie 
* @date 2017年12月1日    
*/
public class PurchaseTransition {

//	public static PurchasePO VOtoPO(PurchaseVO vo) {
//		ArrayList<CommodityItemPO> commodities = CommodityItemTran.VOtoPO(vo.commodities);
//		return new PurchasePO(vo.id, vo.supplierID, vo.supplier, vo.warehouse, 
//				vo.operator, commodities, vo.sum, vo.remark, vo.state, vo.type);
//	}
	
	public static PurchaseVO POtoVO(PurchasePO po) {
		ArrayList<CommodityItemVO> commodities = CommodityItemTran.POtoVO(po.getCommodities());
		return new PurchaseVO(po.getMemberID(), po.getMember(), po.getWarehouse(), 
				po.getOperator(), commodities, String.valueOf(po.getSum()), po.getRemark(), po.getType(), po.getState());
	}
}
