package bussinesslogic.classificationbl;

import java.util.ArrayList;

import po.ClassificationPO;
import vo.commodityvo.ClassificationVO;
import vo.commodityvo.CommodityVO;

public class ClassificationTransition {
	
	ClassificationVO classificationVO;
	ClassificationPO classificationPO;
	
	public ClassificationPO VOtoPO(ClassificationVO classificationVO){
		String id=classificationVO.getID();
		String name=classificationVO.getName();
		ClassificationVO father=classificationVO.getFather();
		return classificationPO;
	}
	
	public ClassificationVO POtoVO(ClassificationPO classificationPO){
		
		return classificationVO;
	}
	
}
