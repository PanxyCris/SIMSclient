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

	public ArrayList<PurchaseVO> inventoryCheck(Date startDate,Date endDate);//����������ڿ��鿴�����ںͽ�����������ϵ��Ϊ���ܣ��������ڴ˴�
	/**
	 * ��ʾ����
	 */
	public ArrayList<PurchaseVO> show();
}
