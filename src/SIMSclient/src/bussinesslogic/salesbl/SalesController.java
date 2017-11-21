package SIMSclient.src.bussinesslogic.salesbl;

import java.util.ArrayList;

import SIMSclient.src.bussinesslogic.commoditybl.CommodityItem;
import SIMSclient.src.bussinesslogicservice.salesblservice.SalesBLService;
import SIMSclient.src.vo.PromotionVO;
import SIMSclient.src.vo.commodity.CommodityVO;
import SIMSclient.src.vo.member.MemberVO;
import SIMSclient.src.vo.sale.SalesAddVO;
import SIMSclient.src.vo.sale.SalesVO;

public class SalesController implements SalesBLService{

	private Sales sale = new Sales();
	
	public SalesController() {
		
	}

	public String getSaleID() {
		try {
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public String getBackSaleID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommodityVO getCommodityByID(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCommodities(CommodityItem item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<PromotionVO> getCommodityPromotionListByID(int commodityID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO getMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SalesVO submit(SalesAddVO Info) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SalesVO save(SalesAddVO Info) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void endSales() {
		// TODO Auto-generated method stub
		
	}

	
	
}
