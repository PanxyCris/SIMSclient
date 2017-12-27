package bussinesslogic.commoditybl;

import java.time.LocalDateTime;
import java.util.ArrayList;

import bussinesslogicservice.commodityblservice.CommodityBLService;
import dataenum.ResultMessage;
import dataenum.findtype.FindCommodityType;
import vo.commodityvo.CommodityCheckVO;
import vo.commodityvo.CommodityStockVO;
import vo.commodityvo.CommodityVO;

public class CommodityController implements CommodityBLService{

	CommodityBL commodityBL;
	
	@Override
	public String getID() throws Exception {
		return commodityBL.getID();
	}

	@Override
	public ResultMessage insert(CommodityVO vo) throws Exception {
		return commodityBL.insert(vo);
	}

	@Override
	public void delete(CommodityVO vo) throws Exception {
		commodityBL.delete(vo);
	}

	@Override
	public ResultMessage update(CommodityVO vo) throws Exception {
		return commodityBL.update(vo);
	}

	@Override
	public ArrayList<CommodityVO> find(String info, FindCommodityType properties) throws Exception {
		return commodityBL.find(info, properties);
	}

	@Override
	public ArrayList<CommodityVO> show() throws Exception {
		return commodityBL.show();
	}

	@Override
	public ArrayList<String> getIDandName() throws Exception {
		return commodityBL.getIDandName();
	}

	@Override
	public ArrayList<String> getAllChildrenClass() throws Exception {
		return commodityBL.getAllChildrenClass();
	}

	@Override
	public ArrayList<CommodityStockVO> stock() throws Exception {
		return commodityBL.stock();
	}

	@Override
	public ArrayList<CommodityCheckVO> check(LocalDateTime startDate, LocalDateTime endDate) {
		return commodityBL.check(startDate, endDate);
	}

}
