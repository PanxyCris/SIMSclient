package bussinesslogic.purchasebl;

import java.util.ArrayList;

import bussinesslogic.CommodityItemTran;
import po.PurchasePO;
import po.commodity.CommodityItemPO;
import vo.commodity.CommodityItemVO;
import vo.purchase.PurchaseVO;

/**     
*  ����PO��VO�Ļ���ת��
* @author Lijie 
* @date 2017��12��1��    
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
				po.getOperator(), commodities, po.getSum(), po.getRemark(), po.getType(), po.getState());
	}
}
