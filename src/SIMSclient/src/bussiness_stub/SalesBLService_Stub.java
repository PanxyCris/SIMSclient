package SIMSclient.src.bussiness_stub;

import java.util.ArrayList;

import SIMSclient.src.bussinesslogicservice.salesblservice.SalesBLService;
import SIMSclient.src.vo.PromotionVO;
import SIMSclient.src.vo.commodity.CommodityItemVO;
import SIMSclient.src.vo.commodity.CommodityVO;
import SIMSclient.src.vo.member.MemberVO;
import SIMSclient.src.vo.sale.SalesAddVO;
import SIMSclient.src.vo.sale.SalesVO;

/**  
* 类说明   
*  
* @author ****  
* @date 2017年10月22日    
*/
public class SalesBLService_Stub implements SalesBLService{

	public String getSaleID() {
		System.out.println("getSaleID Succeed!\n");
		return null;
	}

	
	public String getBackID() {
		System.out.println("getBackID Succeed!\n");
		return null;
	}

	
	public CommodityVO getCommodityByID(int ID) {
		System.out.println("getCommodityByID Succeed!\n");
		return null;
	}

	
	public void addCommodities(CommodityItemVO item) {
		System.out.println("addCommodities Succeed!\n");
		
	}

	public ArrayList<PromotionVO> getCommodityPromotionListByID(int commodityID) {
		System.out.println("getCommodityPromotionListByID Succeed!\n");
		return null;
	}

	public MemberVO getMember() {
		System.out.println("getMember Succeed!\n");
		return null;
	}

	public SalesVO submit(SalesAddVO Info) {
		System.out.println("Submit Succeed!\n");
		return null;
	}

	public SalesVO save(SalesAddVO Info) {
		System.out.println("Save Succeed!\n");
		return null;
	}

	public void endSales() {
		System.out.println("End Succeed!\n");
		
	}

}
