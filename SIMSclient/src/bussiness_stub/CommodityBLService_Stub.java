package bussiness_stub;

import java.time.LocalDate;
import java.util.ArrayList;
import bussinesslogicservice.commodityblservice.CommodityBLService;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindCommodityType;
import vo.commodityvo.CommodityCheckVO;
import vo.commodityvo.CommodityStockVO;
import vo.commodityvo.CommodityVO;

public class CommodityBLService_Stub implements CommodityBLService{

	@Override
	public String getID() throws Exception {
		return "00001";
	}

	@Override
	public ResultMessage insert(CommodityVO vo) throws Exception {
		return ResultMessage.SUCCESS;
	}

	@Override
	public void delete(CommodityVO vo) throws Exception {
	}

	@Override
	public ResultMessage update(CommodityVO vo) throws Exception {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<CommodityVO> find(String info, FindCommodityType properties) throws Exception {
		ArrayList<CommodityVO> list = new ArrayList<>();
		CommodityVO v1 = new CommodityVO("00001", "������", "L", "��", 
				300, 400.0, 500.0, 100);
		CommodityVO v2 = new CommodityVO("00002", "������", "S", "��", 
				400, 300.0, 400.0, 100);
		list.add(v1);
		list.add(v2);
		ArrayList<CommodityVO> result = new ArrayList<>();
		for (CommodityVO vo : list) {
			switch (properties) {
			case ID:
				if (info.equals(vo.getID())) result.add(vo);
				break;
			case NAME:
				if (info.equals(vo.getName())) result.add(vo);
				break;

			default:
				break;
			}
		}
		return result;
	}

	@Override
	public ArrayList<CommodityVO> show() throws Exception {
		ArrayList<CommodityVO> list = new ArrayList<>();
		CommodityVO v1 = new CommodityVO("00001", "������", "L", "��", 
				300, 400.0, 500.0, 100);
		CommodityVO v2 = new CommodityVO("00002", "������", "S", "��", 
				400, 300.0, 400.0, 100);
		list.add(v1);
		list.add(v2);
		return list;
	}

	@Override
	public ArrayList<String> getIDandName() throws Exception {
		ArrayList<String> list = new ArrayList<>();
		String s1 = "����(00001)";
		String s2 = "������(00002)";
		list.add(s1);
		list.add(s2);
		return list;
	}

	@Override
	public ArrayList<String> getAllChildrenClass() throws Exception {
		return null;
	}

	@Override
	public ArrayList<CommodityStockVO> stock() throws Exception {
		return null;
	}

	@SuppressWarnings("unused")
	@Override
	public ArrayList<CommodityCheckVO> check(LocalDate start, LocalDate end) {
		ArrayList<CommodityCheckVO> list = new ArrayList<>();
		LocalDate L = LocalDate.of(2018, 01, 01);
		CommodityCheckVO v1 = new CommodityCheckVO(L , BillType.INVENTORYWARNINGBILL, "������", 1000, 30.0);
		list.add(v1);
		return list;
	}

	@Override
	public void exportReport(ArrayList<CommodityStockVO> commodityStockVOs) {
	}

	
}
