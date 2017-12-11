package bussinesslogic.salesbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogicservice.salesblservice.SalesBLService;
import dataenum.ResultMessage;
import po.sales.SalesPO;
import vo.PromotionVO;
import vo.commodity.CommodityItemVO;
import vo.commodity.CommodityVO;
import vo.member.MemberVO;
import vo.promotion.PromotionMemberVO;
import vo.promotion.PromotionPricePacksVO;
import vo.promotion.PromotionTotalVO;
import vo.sale.SalesInputVO;
import vo.sale.SalesVO;

/*
 * 负责实现销售界面所需要的服务
 */
public class SalesController implements SalesBLService{

	private Sales sale;
	
	public SalesController() {
		sale = new Sales();
	}

	@Override
	public String getSaleID() {
		try {
			return sale.getSaleID();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getBackSaleID() {
		try {
			return sale.getSaleBackID();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
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

	
}
