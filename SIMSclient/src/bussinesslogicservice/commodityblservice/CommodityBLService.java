package bussinesslogicservice.commodityblservice;
import java.util.ArrayList;


import dataenum.ResultMessage;
import dataenum.findtype.FindCommodityType;
import vo.commodityvo.CommodityVO;

public interface CommodityBLService {

	public String getID();

	public ResultMessage insert(CommodityVO vo);

	public void delelte(CommodityVO vo);

	public ResultMessage update(CommodityVO vo);

	public ArrayList<CommodityVO> find(String info,FindCommodityType properties);

	public ArrayList<CommodityVO> show();

	public ArrayList<String> getIDandName();

	public void stock();   //ø‚¥Ê≈Ãµ„
}
