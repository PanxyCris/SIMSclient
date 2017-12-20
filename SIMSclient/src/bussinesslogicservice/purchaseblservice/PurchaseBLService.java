package bussinesslogicservice.purchaseblservice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import dataenum.ResultMessage;
import dataenum.findtype.FindPurchaseType;
import vo.billvo.purchasebillvo.PurchaseVO;
import vo.commodityvo.CommodityItemVO;
/**
* ��˵��   ����
*
* @author lijie
* @date 2017��10��22��
*/
public interface PurchaseBLService {

	public String getPurchaseID();
	public String getPurChaseBackID();

    public void delete(PurchaseVO info);

	public ResultMessage submit(PurchaseVO Info);

	public ResultMessage save(PurchaseVO Info);

	public ResultMessage isLegal(CommodityItemVO vo);

	public ArrayList<PurchaseVO> find(String info,FindPurchaseType type);

	/**
	 * ��ʾ����
	 */
	public ArrayList<PurchaseVO> show();

}
