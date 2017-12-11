package vo.promotion;
/**     
* ���ݹ������Ʒ�ܼۣ��ƶ����ã���Ʒ�����ʹ���ȯ
* @author Lijie 
* @date 2017��12��11��    
*/

import java.util.ArrayList;

public class PromotionTotalVO extends PromotionVO {

	public String beginDate;
	public String endDate;
	public double total;
	public double allowance;
	public double voucher;
	public ArrayList<PromotionGoodsVO> gifts;
	
	public PromotionTotalVO(String id, String beginDate, String endDate, double total, 
			double allowance, double voucher, ArrayList<PromotionGoodsVO> gifts) {
		this.id = id;
		this.allowance = allowance;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.voucher = voucher;
		this.gifts = gifts;
		this.total = total;
	}
	
}
