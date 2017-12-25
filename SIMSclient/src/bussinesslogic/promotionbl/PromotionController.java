package bussinesslogic.promotionbl;

import java.util.ArrayList;

import bussinesslogicservice.promotionblservice.PromotionBLService;
import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import vo.promotionvo.PromotionVO;

/**     
*  
* @author Lijie 
* @date 2017Äê12ÔÂ24ÈÕ    
*/
public class PromotionController implements PromotionBLService{

	@Override
	public ResultMessage insert(PromotionVO vo) {
		return null;
	}

	@Override
	public ResultMessage delete(PromotionVO vo) {
		return null;
	}

	@Override
	public ResultMessage update(PromotionVO vo) {
		return null;
	}

	@Override
	public ArrayList<PromotionVO> getPromotionList() {
		return null;
	}

	@Override
	public String getID() {
		return null;
	}

	@Override
	public ArrayList<PromotionVO> find(String info, FindPromotionType findType) {
		return null;
	}

}
