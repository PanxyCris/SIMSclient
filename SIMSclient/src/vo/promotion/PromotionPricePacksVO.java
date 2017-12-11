package vo.promotion;
/**     
*  �ؼ۰�
* @author Lijie 
* @date 2017��12��11��    
*/

import java.util.ArrayList;

import dataenum.PromotionType;
import vo.commodity.CommodityItemVO;

public class PromotionPricePacksVO extends PromotionVO {
	public String beginDate;
	public String endDate;
	public ArrayList<CommodityItemVO> pricePacks;
	public double beforeTotal;   //�ؼ۰��Ż�ǰ���ܼ�
	public double afterTotal;   //������ļ۸�
	public PromotionType type;
	
	public PromotionPricePacksVO(String ID, String beginDate, String endDate, ArrayList<CommodityItemVO> pricePacks, 
			double beforeTotal, double afterTotal) {
		this.id = ID;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.pricePacks = pricePacks;
		this.beforeTotal = afterTotal;
		this.afterTotal = afterTotal;
		this.type = PromotionType.PRICEPACKS;
	}

	public PromotionPricePacksVO(String beginDate, String endDate, double afterTotal) {
		super();
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.afterTotal = afterTotal;
	}

	
}
