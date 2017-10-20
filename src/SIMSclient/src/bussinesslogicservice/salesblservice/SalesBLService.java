package SIMSclient.src.bussinesslogicservice.salesblservice;

import java.util.*;

import SIMSclient.src.vo.MemberVO;
import SIMSclient.src.vo.PromotionVO;
import SIMSclient.src.vo.Commodity.CommodityVO;

public interface SalesBLService {

	public CommodityVO getCommodityByID(int id);
	public ArrayList<PromotionVO> getCommodityPromotionListByID(int commodityID);

	public MemberVO getMember();

	public double getTotal(int mode);
	public double getChange(double payment);
	public void endSales();
}
