package bussinesslogic.commoditybl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;

import bussinesslogicservice.commodityblservice.CommodityBLService;
import dataenum.ResultMessage;
import dataenum.findtype.FindCommodityType;
import dataservice.commoditydataservice.CommodityDataService;
import po.MemberPO;
import po.commodity.CommodityPO;
import rmi.RemoteHelper;
import vo.ViewObject;
import vo.commodityvo.CommodityVO;
import vo.membervo.MemberVO;

public class CommodityController implements CommodityBLService{

	private CommodityDataService service;
	private CommodityTransiton transition;
	
	public CommodityController() {
		service = RemoteHelper.getInstance().getCommodityDataService();
		transition = new CommodityTransiton();
	}
	
	@Override
	public String getID() {
		ArrayList<CommodityPO> list = null;
		try {
		    list = service.showCommodity();
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		ArrayList<Integer> IDList = new ArrayList<>();
		for (CommodityPO po : list) {
			IDList.add(Integer.parseInt(po.getId()));
		}
		Collections.sort(IDList);
//		Collections.reverse(IDList);
		String id = String.valueOf(IDList.get(IDList.size()-1)+1);
		StringBuilder sb = new StringBuilder(id);
		int len = id.length();
		for (int i=0; i < 6-len; i++) {
			sb.insert(0, "0");
		}
		return sb.toString();
	}

	@Override
	public ResultMessage insert(CommodityVO vo) {
		try {
			return service.insertCommodity(transition.VOtoPO(vo));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public void delelte(CommodityVO vo) {
		try {
			service.daleteCommodity(vo.getID());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public ResultMessage update(CommodityVO vo) {
		try {
			return service.updateCommodity(transition.VOtoPO(vo));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<CommodityVO> find(String info, FindCommodityType properties) {
		ArrayList<CommodityVO> list = new ArrayList<>();
		ArrayList<CommodityPO> poList = null;
		try {
			poList = service.findCommodity(info, properties);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		CommodityVO vo = null;
		for (CommodityPO po : poList) {
			vo = transition.POtoVO(po);
			list.add(vo);
		}

		return list;
	}


	@Override
	public void stock() {
	}

	@Override
	public ArrayList<CommodityVO> show() {
		ArrayList<CommodityVO> list = new ArrayList<>();	
		ArrayList<CommodityPO> poList = null;
		try {
			poList = service.showCommodity();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		CommodityVO vo = null;
		for (CommodityPO po : poList) {
			vo = transition.POtoVO(po);
			list.add(vo);
		}
		return list;
	}

	@Override
	public ArrayList<String> getIDandName() {
		ArrayList<CommodityVO> list = show();
		ArrayList<String> result = new ArrayList<>();
//		for (CommodityVO vo : list) {
//			result.add(vo.getName() + "(" + vo.getID() + ")");
//		}
		ArrayList<String> a = new ArrayList<>();
		a.add("¿ÓΩ‹(00001)");
		return a;
	}

		
}
