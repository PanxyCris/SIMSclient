package bussinesslogicservice.purchaseblservice;

import java.util.ArrayList;
import java.util.Date;

import dataenum.ResultMessage;
import po.PurchasePO;
import vo.PromotionVO;
import vo.commodity.CommodityItemVO;
import vo.commodity.CommodityVO;
import vo.purchase.PurchaseVO;

/**
* 类说明   进货
*
* @author ****
* @date 2017年10月22日
*/
public interface PurchaseBLService {

	public String getPurchaseID();
	public String getPurChaseBackID();

    public void delete(PurchaseVO info);

	public ResultMessage submit(PurchaseVO Info);

	public ResultMessage save(PurchaseVO Info);

	public ResultMessage isLegal(CommodityItemVO vo);

	public ArrayList<PurchaseVO> inventoryCheck(Date startDate,Date endDate);//这个方法用于库存查看，由于和进出货方法联系更为紧密，故设置在此处
	/**
	 * 显示单据
	 */
	public ArrayList<PurchaseVO> show();
}
