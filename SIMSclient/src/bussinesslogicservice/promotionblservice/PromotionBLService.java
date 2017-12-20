package bussinesslogicservice.promotionblservice;

import java.util.ArrayList;

import dataenum.PromotionType;
import dataenum.ResultMessage;
import dataenum.findtype.FindPromotionType;
import vo.promotionvo.PromotionVO;

public interface PromotionBLService<P extends PromotionVO> {
//dffff

	public ResultMessage insert(P vo,PromotionType type);
	public void delete(P vo,PromotionType type);
	public ResultMessage update(P vo,PromotionType type);
	public ArrayList<P> getPromotionList(PromotionType type);
    public String getID();
    public ArrayList<P> find(String info,FindPromotionType findType,PromotionType type);


}
