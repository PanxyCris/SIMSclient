package bussinesslogic.purchasebl;

import java.util.ArrayList;
import java.util.Date;

import bussinesslogicservice.purchaseblservice.PurchaseBLService;
import dataenum.ResultMessage;
import po.PurchasePO;
import vo.PromotionVO;
import vo.commodity.CommodityItemVO;
import vo.commodity.CommodityVO;
import vo.purchase.PurchaseVO;

/**
*
* @author Lijie
* @date 2017Äê12ÔÂ1ÈÕ
*/
public class PurchaseController implements PurchaseBLService{

	@Override
	public String getPurchaseID() {
		return null;
	}

	@Override
	public String getPurChaseBackID() {
		return null;
	}

	@Override
	public void delete(PurchaseVO info) {
	}

	@Override
	public ResultMessage submit(PurchaseVO Info) {
		return null;
	}

	@Override
	public ResultMessage save(PurchaseVO Info) {
		return null;
	}

	@Override
	public ResultMessage isLegal(CommodityItemVO vo) {
		return null;
	}

	@Override
	public ArrayList<PurchaseVO> inventoryCheck(Date startDate, Date endDate) {
		return null;
	}

	@Override
	public ArrayList<PurchaseVO> show() {
		return null;
	}

	
}
