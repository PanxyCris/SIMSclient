package bussinesslogic.commoditybl;
/**     
*  VO与PO的转换
* @author Lijie 
* @date 2017年12月18日    
*/

import java.util.ArrayList;

import bussinesslogic.classificationbl.ClassificationTran;
import po.ClassificationPO;
import po.commodity.CommodityPO;
import vo.commodityvo.ClassificationVO;
import vo.commodityvo.CommodityVO;

public class CommodityTransiton {

	public CommodityPO VOtoPO(CommodityVO vo) {
		ClassificationTran classify = new ClassificationTran();
		String id = vo.getID();
		String name = vo.getName();
		String model = vo.getModel();
		int number = vo.getNumber();
		double purPrice = vo.getPurPrice();
		double retailedPrice = vo.getRetailedPrice();
		int warmingValue = vo.getWarmingValue();
		ClassificationPO classification = classify.VOtoPO(vo.getClassification());
		double recentRetailedPrice = vo.getRecentRetailedPrice();
		double recentPurPrice = vo.getRecentPurPrice();
		CommodityPO po = new CommodityPO(id, name, model, classification, number, purPrice, retailedPrice,
				recentPurPrice, recentRetailedPrice, warmingValue);
		return po;
	}
	
	public CommodityVO POtoVO(CommodityPO po) {
		ClassificationTran classify = new ClassificationTran();
		String id = po.getId();
		String name = po.getName();
		String model = po.getModel();
		int number = po.getNumber();
		double purPrice = po.getPurPrice();
		double retailedPrice = po.getRetailedPrice();
		int warmingValue = po.getWarmingValue();
		ClassificationVO classification = classify.POtoVO(po.getClassification());
		double recentRetailedPrice = po.getRecentRetailedPrice();
		double recentPurPrice = po.getRecentPurPrice();
		CommodityVO vo = new CommodityVO(id, name, model, classification, number, purPrice, retailedPrice,
				recentPurPrice, recentRetailedPrice, warmingValue);
		return vo;
	}
}
