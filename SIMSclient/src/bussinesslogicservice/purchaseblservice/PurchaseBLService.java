package bussinesslogicservice.purchaseblservice;

import java.util.ArrayList;
import dataenum.ResultMessage;
import vo.billvo.purchasebillvo.PurchaseVO;
import vo.commodityvo.CommodityItemVO;
/**
* ��˵��   ����
*
* @author ****
* @date 2017��10��22��
*/
public interface PurchaseBLService {

	public String getPurchaseID();
	public String getPurChaseBackID();

    public void delete(PurchaseVO info);

	public ResultMessage submit(PurchaseVO Info);

	public ResultMessage save(PurchaseVO Info);

	public ResultMessage isLegal(CommodityItemVO vo);

	/**
	 * ��ʾ����
	 */
	public ArrayList<PurchaseVO> show();
}
