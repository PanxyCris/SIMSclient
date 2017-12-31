package bussinesslogic.commoditybl;


import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import bussinesslogic.classificationbl.ClassificationBL;
import bussinesslogic.classificationbl.ClassificationController;
import bussinesslogic.purchasebl.PurchaseController;
import bussinesslogic.salesbl.SalesController;
import bussinesslogicservice.commodityblservice.ClassificationBLService;
import bussinesslogicservice.commodityblservice.CommodityBLService;
import bussinesslogicservice.purchaseblservice.PurchaseBLService;
import bussinesslogicservice.salesblservice.SalesBLService;
import dataenum.ResultMessage;
import dataenum.findtype.FindCommodityType;
import dataservice.commoditydataservice.CommodityDataService;
import javafx.util.converter.LocalDateStringConverter;
import po.ClassificationVPO;
import po.MemberPO;
import po.commodity.CommodityPO;
import rmi.RemoteHelper;
import vo.ViewObject;
import vo.billvo.purchasebillvo.PurchaseVO;
import vo.billvo.salesbillvo.SalesVO;
import vo.commodityvo.CommodityCheckVO;
import vo.commodityvo.CommodityStockVO;
import vo.commodityvo.CommodityVO;
import vo.membervo.MemberVO;

/**
 * 
* @ClassName: CommodityController 
* @author lijie
* @date 2017年12月16日
* 修改：王灿灿
*  
*/


public class CommodityBL implements CommodityBLService{

	private CommodityDataService service;
	private CommodityTransiton transition;
	private ClassificationBLService classificationBLService;
	private SalesBLService salesBLService;
	private PurchaseBLService purchaseBLService;
	
	public CommodityBL() {
		service = RemoteHelper.getInstance().getCommodityDataService();
		transition = new CommodityTransiton();
		classificationBLService=new ClassificationController();
		salesBLService=new SalesController();
		purchaseBLService=new PurchaseController();
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
	public void delete(CommodityVO vo)  throws Exception{
		try {
			service.deleteCommodity(vo.getID());
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

//ccw
	@Override
	public ArrayList<CommodityStockVO> stock() {
		ArrayList<CommodityStockVO> commodityStockVOs=new ArrayList<>();
		CommodityStockVO commodityStockVO=null;
		ArrayList<CommodityVO> commodityVOs=show();
		for (int i = 0; i < commodityStockVOs.size(); i++) {
			commodityStockVO=new CommodityStockVO(commodityVOs.get(i).getID(), commodityVOs.get(i).getName(),
					commodityVOs.get(i).getModel(), commodityVOs.get(i).getNumber(),
					(commodityVOs.get(i).getRecentRetailedPrice()+commodityVOs.get(i).getRetailedPrice())/2,(commodityVOs.get(i).getRecentPurPrice()+commodityVOs.get(i).getPurPrice())/2, 
					commodityVOs.get(i).getLine());
			commodityStockVOs.add(commodityStockVO);
		}
		return commodityStockVOs;
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

	/**
	 * 获取全部的商品ID和名字
	 * @author lijie
	 */
	@Override
	public ArrayList<String> getIDandName() {
		ArrayList<CommodityVO> list = show();
		ArrayList<String> result = new ArrayList<>();
		for (CommodityVO vo : list) {
			result.add(vo.getName() + "(" + vo.getID() + ")");
		}
		return result;
	}

//ccw
	static ArrayList<String> nameList=null;

	public void addName(ClassificationVPO classificationVPO){
		ArrayList<ClassificationVPO> childrenVPOs=classificationVPO.getChildren();
		if(childrenVPOs!=null){
			for (int i = 0; i < childrenVPOs.size(); i++) {
					if(childrenVPOs.get(i).getB()==true){
						addName(childrenVPOs.get(i));
					}
					else{
						nameList.add(classificationVPO.getName());
						break;
					}
				}
			}
		else{
			if(classificationVPO.getB()==true){
				nameList.add(classificationVPO.getName());
			}
		}
	}
	
//ccw
	@Override
	public ArrayList<String> getAllChildrenClass() throws Exception {
		nameList=new ArrayList<>();
		ClassificationVPO root=classificationBLService.getRoot();
		addName(root);
		return nameList;
	}

//ccw
	@Override
	public ArrayList<CommodityCheckVO> check(LocalDate start, LocalDate end) {
		ArrayList<CommodityCheckVO> checkVOs=new ArrayList<>();
		ArrayList<SalesVO> salesVOs=salesBLService.show();
		for (int i = 0; i < salesVOs.size(); i++) {
			LocalDate localDate=StringtoDate(salesVOs.get(i).getId());
			if(localDate.isAfter(start)&&localDate.isBefore(end)){
				
			}
		}
		ArrayList<PurchaseVO> purchaseVOs=purchaseBLService.show();
		return null;
	}
	
	public LocalDate StringtoDate(String id){//id是单据编号
		String s=id.split("-")[1];
		String date=s.substring(0,4)+"-"+s.substring(4,6)+"-"+s.substring(6, s.length());
		LocalDate l=null;
		LocalDateStringConverter localDate =new LocalDateStringConverter();
		l=localDate.fromString(date);
		return l;
	}
	
}
