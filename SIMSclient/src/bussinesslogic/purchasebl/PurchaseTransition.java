package bussinesslogic.purchasebl;

import java.util.ArrayList;

import bussinesslogic.common.CommodityItemTran;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Warehouse;
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

	public static PurchasePO VOtoPO(PurchaseVO vo) {
		ArrayList<CommodityItemPO> commodities = CommodityItemTran.VOtoPO(vo.getCommodities());
		String id = vo.getId();
		String memberID = vo.getSupplier();
		String member = vo.getSupplier();
		Warehouse warehouse = vo.getWarehouse();
		String operator = vo.getOperator();
		String remark = vo.getRemark();
		Double sum = vo.getSum();
		BillType type = vo.getType();
		BillState state = vo.getState();
		PurchasePO po = new PurchasePO(id, memberID, member, warehouse, operator, commodities, remark, sum, type, state);
		return po;
	}
	
	public static PurchaseVO POtoVO(PurchasePO po) {
		ArrayList<CommodityItemVO> commodities = CommodityItemTran.POtoVO(po.getCommodities());
		PurchaseVO vo = null;
		return vo;
	}
}
