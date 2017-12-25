package bussinesslogicservice.promotionblservice;

import java.util.ArrayList;
import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import vo.promotionvo.PromotionVO;

public interface PromotionBLService {


	public ResultMessage insert(PromotionVO vo);
	public ResultMessage delete(PromotionVO vo);
	public ResultMessage update(PromotionVO vo);
	public ArrayList<PromotionVO> getPromotionList();
    public String getID();
    public ArrayList<PromotionVO> find(String info,FindPromotionType findType);

 
}
