package bussiness_stub;

import vo.ViewObject;
import vo.commodity.CommodityVO;

public class CommodityBLService_Stub {

	public void insert(CommodityVO vo){
		System.out.println("Insert Success.");
	}
	public void delete(CommodityVO vo){
		System.out.println("Delete Success.");
	}
	public void update(CommodityVO vo){
		System.out.println("Update Success.");
	}
	public void find(CommodityVO vo){
		System.out.println("Find Success.");
	}
	public void check(){
		System.out.println("Check Success.");
	}
	public void stock(){
		System.out.println("Stock Success.");
	}
	public void giftInventoryReceiptsMaking(ViewObject vo){
		System.out.println("Making Success.");
	}
	public void lossAndRevenueInventoryReceiptsMaking(ViewObject vo){
		System.out.println("Making Success.");
	}
	public void warningInventoryReceiptsMaking(ViewObject vo){
		System.out.println("Making Success.");
	}
}
