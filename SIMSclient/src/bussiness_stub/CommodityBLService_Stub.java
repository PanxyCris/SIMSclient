package bussiness_stub;

import java.time.LocalDate;
import java.util.ArrayList;
import bussinesslogicservice.commodityblservice.CommodityBLService;
import dataenum.ResultMessage;
import dataenum.findtype.FindCommodityType;
import vo.commodityvo.ClassificationVO;
import vo.commodityvo.CommodityCheckVO;
import vo.commodityvo.CommodityStockVO;
import vo.commodityvo.CommodityVO;

public class CommodityBLService_Stub implements CommodityBLService{

	@Override
	public ResultMessage insert(CommodityVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public void delelte(CommodityVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public ResultMessage update(CommodityVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<CommodityVO> find(String info, FindCommodityType properties) {
		ArrayList<CommodityVO> list = new ArrayList<>();
		ClassificationVO classification = new ClassificationVO("00001","�׵���",null,null,null);
        CommodityVO commodity1 = new CommodityVO("00001","�׳��","L",classification,20,25,45,500);
        CommodityVO commodity2 = new CommodityVO("00002","̨��","S",classification,30,30,50,500);
        list.add(commodity1);
        list.add(commodity2);
		return list;
	}

	@Override
	public ArrayList<CommodityVO> getCommodityList() {
		ArrayList<CommodityVO> list = new ArrayList<>();
		ClassificationVO classification = new ClassificationVO("00001","�׵���",null,null,null);
        CommodityVO commodity1 = new CommodityVO("00001","�׳��","L",classification,20,25,45,500);
        CommodityVO commodity2 = new CommodityVO("00002","̨��","L",classification,30,30,50,500);
        list.add(commodity1);
        list.add(commodity2);
		return list;
	}

	@Override
	public void stock() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<String> getCommodityIDList() {
		ArrayList<String> list = new ArrayList<>();
		String id1 = "�׳��(00001)";
		String id2 = "̨��(00002)";
		list.add(id1);
		list.add(id2);
		return list;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(CommodityVO vo) throws Exception {
	}

	@Override
	public ArrayList<CommodityVO> show() throws Exception {
		return null;
	}

	@Override
	public ArrayList<String> getIDandName() throws Exception {
		return null;
	}

	@Override
	public ArrayList<String> getAllChildrenClass() throws Exception {
		return null;
	}

	@Override
	public ArrayList<CommodityStockVO> stock() throws Exception {
		return null;
	}

	@Override
	public ArrayList<CommodityCheckVO> check(LocalDate start, LocalDate end) {
		return null;
	}

	@Override
	public void exportReport(ArrayList<CommodityStockVO> commodityStockVOs) {
	}

}
