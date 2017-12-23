package bussinesslogic.salesbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import bussinesslogicservice.salesblservice.SalesBLService;
import bussinesslogicservice.salesblservice.SalesShowService;
import dataenum.ResultMessage;
import dataenum.findtype.FindSalesType;
import dataservice.salesdataservice.SalesDataService;
import po.sales.SalesPO;
import rmi.RemoteHelper;
import vo.billvo.salesbillvo.SalesVO;
import vo.commodityvo.CommodityItemVO;
import vo.promotionvo.PromotionMemberVO;
import vo.promotionvo.PromotionPricePacksVO;
import vo.promotionvo.PromotionTotalVO;

/*
 * 负责实现销售界面所需要的服务
 */
public class SalesController implements SalesBLService, SalesShowService{

	private Sales sale;
	private SaleShow saleshow;
	private SalesDataService service;
	private String date;

	public SalesController() {
		sale = new Sales();
		saleshow = new SaleShow();
		service = RemoteHelper.getInstance().getSalesDataService();
	}

	@Override
	public String getSaleID() {
		ArrayList<SalesPO> list = new ArrayList<>();
		ArrayList<Long> IDList = new ArrayList<>();
		String id = null;
		for (SalesPO po: list) {
			id = po.getId();
			String temp[] = id.split("-");

			if (temp[0].equals("XSD")) {
				IDList.add(Long.parseLong(temp[1]+temp[2]));
			}
		}

		Collections.sort(IDList);
		String day = getDate();
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
	}

	@Override
	public String getBackSaleID() {
		ArrayList<SalesPO> list = new ArrayList<>();
		ArrayList<Long> IDList = new ArrayList<>();
		String id = null;
		for (SalesPO po: list) {
			id = po.getId();
			String temp[] = id.split("-");

			if (temp[0].equals("XSD")) {
				IDList.add(Long.parseLong(temp[1]+temp[2]));
			}
		}

		Collections.sort(IDList);
		String day = getDate();
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

	}

	@Override
	public SalesPO createSale() {
		try {
			return sale.createSale();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addCommodities(CommodityItemVO item) {
		try {
			sale.addCommodities(item);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<PromotionPricePacksVO> showPricePacks() {
		try {
			return sale.showPricePacks();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addPricePacks(String id) {
		try {
			sale.addPricePacks(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<PromotionTotalVO> FindTotalPromotion() {
		try {
			return sale.FindTotalPromotion();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<PromotionMemberVO> FindMemberPromotion() {
		try {
			return sale.FindMemberPromotion();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public double setPromotion(String id) {
		try {
			return sale.setPromotion(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void addMembers(String id) {
		try {
			sale.addMembers(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public SalesVO submit(SalesInputVO Info) {
		try {
			return sale.save(Info);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public SalesVO save(SalesInputVO Info) {
		try {
			return sale.save(Info);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage updateDraft(SalesVO vo) {
		try {
			return sale.updateDraft(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage submitDraft(String id) {
		try {
			return sale.submitDraft(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<SalesVO> showSale() {
		try {
			return saleshow.showAllSaleBill();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<SalesVO> showSaleBack() {
		try {
			return saleshow.showAllSaleBackBill();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<SalesVO> showSaleCommited() {
		try {
			return saleshow.showSaleCommited();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<SalesVO> showSaleBackCommited() {
		try {
			return saleshow.showSaleBackCommited();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<SalesVO> showSaleSuccess() {
		try {
			return saleshow.showSaleSuccess();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<SalesVO> showSaleBackSuccess() {
		try {
			return saleshow.showSaleBackSuccess();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<SalesVO> showSaleFail() {
		try {
			return saleshow.showSaleFail();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<SalesVO> showSaleBackFail() {
		try {
			return saleshow.showSaleBackFail();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<SalesVO> showSaleDraft() {
		try {
			return saleshow.showSaleDraft();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<SalesVO> showSaleBackDraft() {
		try {
			return saleshow.showSaleBackDraft();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(SalesVO info) {
	}

	public String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		this.date = sdf.format(new Date());
		return this.date;
	}


}
