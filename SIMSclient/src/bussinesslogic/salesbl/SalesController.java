package bussinesslogic.salesbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

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
		}catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getBackSaleID() {
		try {
			return sale.getSaleBackID();
		}catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public CommodityVO getCommodityByID(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCommodities(CommodityItemVO vo) {
		try {
			sale.addCommodities(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
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
		
		
	}

	
	
}
