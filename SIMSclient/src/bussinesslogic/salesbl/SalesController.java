package bussinesslogic.salesbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import bussinesslogic.promotionbl.PromotionMemberBL;
import bussinesslogic.promotionbl.PromotionSpecialBL;
import bussinesslogic.promotionbl.PromotionSumBL;
import bussinesslogic.purchasebl.PurchaseTransition;
import bussinesslogicservice.salesblservice.SalesBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.Warehouse;
import dataenum.findtype.FindSalesType;
import dataservice.promotiondataservice.PromotionMemberDataService;
import dataservice.promotiondataservice.PromotionSpecialDataService;
import dataservice.promotiondataservice.PromotionSumDataService;
import dataservice.salesdataservice.SalesDataService;
import po.PurchasePO;
import po.promotionpo.PromotionMemberPO;
import po.promotionpo.PromotionPricePacksPO;
import po.promotionpo.PromotionTotalPO;
import po.sales.SalesPO;
import rmi.RemoteHelper;
import vo.billvo.purchasebillvo.PurchaseVO;
import vo.billvo.salesbillvo.SalesVO;
import vo.commodityvo.CommodityItemVO;
import vo.promotionvo.PromotionMemberVO;
import vo.promotionvo.PromotionPricePacksVO;
import vo.promotionvo.PromotionTotalVO;

/*
 * 负责实现销售界面所需要的服务
 */
public class SalesController implements SalesBLService{

	private SalesDataService service;
	private PromotionMemberDataService PMService;
	private PromotionSpecialDataService PSpService;
	private PromotionSumDataService PSumService;
	private PromotionSpecialBL PSpbl;
	private PromotionSumBL PSumbl;
	private PromotionMemberBL PSbl;
	private String date;
	
	public SalesController() {
		service = RemoteHelper.getInstance().getSalesDataService();
		PMService = RemoteHelper.getInstance().getMemberPromotionDataService();
		PSpService = RemoteHelper.getInstance().getSpecialPromotionDataService();
		PSumService = RemoteHelper.getInstance().getSumPromotionDataService();
		PSpbl = new PromotionSpecialBL();
		PSumbl = new PromotionSumBL();
		PSbl = new PromotionMemberBL();
	}

	@Override
	public String getSaleID() {
		ArrayList<SalesPO> list = null;
		try {
			list = service.showSale();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		ArrayList<Long> IDList = new ArrayList<>();
		String id = null;
		String day = getDate();
		if (list==null) {
			return "XSD-" + getDate() + "-00001";
		}
		for (SalesPO po : list) {
			id = po.getId();
			String temp[] = id.split("-");
			
			if (temp[0].equals("XSD")) {
				IDList.add(Long.parseLong(temp[1]+temp[2]));
			}
		}
			
		Collections.sort(IDList);
		
//		Collections.reverse(IDList);
		
		String num = String.valueOf(IDList.get(IDList.size()-1));
		if (day.equals(String.valueOf(num.substring(0, 8)))) {
			String index = num.substring(8, num.length());
			index = String.valueOf(Integer.parseInt(index)+1);
			StringBuilder sb = new StringBuilder(index);
			int len = index.length();
			for (int i=0; i < 5-len; i++) {
				sb.insert(0, "0");
			}
			id = sb.toString();
		}
		else {
			id = "00001";
		}
		StringBuilder s = new StringBuilder("XSD-");
		return s.append(day).append("-").append(id).toString();

//		return "000001";
	}

	@Override
	public String getBackSaleID() {
		ArrayList<SalesPO> list = null;
		try {
			list = service.showSale();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		ArrayList<Long> IDList = new ArrayList<>();
		String id = null;
		for (SalesPO po : list) {
			id = po.getId();
			String temp[] = id.split("-");
			
			if (temp[0].equals("XSTHD")) {
				IDList.add(Long.parseLong(temp[1]+temp[2]));
			}
		}
		Collections.sort(IDList);
		String day = getDate();
//		Collections.reverse(IDList);
		if (IDList.isEmpty()) {
			return "XSTHD-" + date + "-00001";
		}
		String num = String.valueOf(IDList.get(IDList.size()-1));
		if (day.equals(String.valueOf(num.substring(0, 8)))) {
			String index = num.substring(8, num.length());
			index = String.valueOf(Integer.parseInt(index)+1);
			StringBuilder sb = new StringBuilder(index);
			int len = index.length();
			for (int i=0; i < 5-len; i++) {
				sb.insert(0, "0");
			}
			id = sb.toString();
		}
		else {
			id = "00001";
		}
		StringBuilder s = new StringBuilder("XSTHD-");
		return s.append(day).append("-").append(id).toString();

	}

	@Override
	public ResultMessage isLegal(CommodityItemVO item) {
		return null;
	}

	@Override
	public void delete(SalesVO info) {
		try {
			service.deleteSale(info.getId());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultMessage submit(SalesVO Info) {
		try {
			SalesPO po = SalesTransition.VOtoPO(Info);
			if (service.insertSale(po) == ResultMessage.EXISTED) {
				return service.updateSale(po);
			}
			else return service.insertSale(SalesTransition.VOtoPO(Info));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage save(SalesVO Info) {
		try {
			SalesPO po = SalesTransition.VOtoPO(Info);
			if (service.insertSale(po) == ResultMessage.EXISTED) {
				return service.updateSale(po);
			}
			else return service.insertSale(SalesTransition.VOtoPO(Info));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<SalesVO> show() {
		ArrayList<SalesVO> list = new ArrayList<>();
		ArrayList<SalesPO> POList = null;
		try {
			POList = service.showSale();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		SalesVO vo = null;
		for (SalesPO po : POList) {
			vo = SalesTransition.POtoVO(po);
			list.add(vo);
		}
		return list;
	}

	@Override
	public ArrayList<SalesVO> find(String info, FindSalesType type) {
		ArrayList<SalesVO> list = new ArrayList<>();
		ArrayList<SalesPO> POList = null;
		try {
			POList = service.findSale(info, type);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		SalesVO vo = null;
		for (SalesPO po : POList) {
			vo = SalesTransition.POtoVO(po);
			list.add(vo);
		}
		return list;
	}

	@Override
	public ArrayList<PromotionPricePacksVO> showPricePacks() {
		ArrayList<PromotionPricePacksPO> list = null;
		ArrayList<PromotionPricePacksVO> result = new ArrayList<>();
		try {
			list = PSpService.showSpecialPromotion();
			for (PromotionPricePacksPO po : list) {
				PromotionPricePacksVO vo = PSpbl.poTovo(po);
				result.add(vo);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<PromotionTotalVO> FindTotalPromotion() {
		ArrayList<PromotionTotalVO> result = new ArrayList<>();
		ArrayList<PromotionTotalPO> list = null;
		try {
			list = PSumService.showSumPromotion();
			for (PromotionTotalPO po : list) {
				PromotionTotalVO vo = PSumbl.poTovo(po);
				result.add(vo);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<PromotionMemberVO> FindMemberPromotion() {
		ArrayList<PromotionMemberVO> result = new ArrayList<>();
		ArrayList<PromotionMemberPO> list = null;
		try {
			list = PMService.showMemberPromotion();
			for (PromotionMemberPO po : list) {
				PromotionMemberVO vo = PSbl.poTovo(po);
				result.add(vo);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	public String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		this.date = sdf.format(new Date());
		return this.date;
	}

}
