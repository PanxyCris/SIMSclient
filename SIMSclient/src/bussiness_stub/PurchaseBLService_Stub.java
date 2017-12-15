package bussiness_stub;

import java.util.ArrayList;
import java.util.Date;

import bussinesslogicservice.purchaseblservice.PurchaseBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.Warehouse;
import vo.commodity.CommodityItemVO;
import vo.purchase.PurchaseVO;

public class PurchaseBLService_Stub implements PurchaseBLService{

	@Override
	public String getPurchaseID() {
		// TODO Auto-generated method stub
		return "JHD-20171214-00001";
	}



	@Override
	public ArrayList<PurchaseVO> show() {
		ArrayList<PurchaseVO> list = new ArrayList<>();
		ArrayList<CommodityItemVO> commodities = new ArrayList<>();
		CommodityItemVO commodity = new CommodityItemVO("001","�׳��","L",89,45.00,"cnjwdfcj");
		commodities.add(commodity);
		PurchaseVO purchase1 = new PurchaseVO("0001","���",Warehouse.WAREHOUSE1,"Panxy",commodities,
				"ncibwcfhbwvhu",45.00,BillType.PURCHASEBILL,BillState.FAIL);
		list.add(purchase1);
		return list;
	}

	@Override
	public ResultMessage isLegal(CommodityItemVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}



	@Override
	public String getPurChaseBackID() {
		// TODO Auto-generated method stub
		return "JHTHD-20171214-00002";
	}




	@Override
	public void delete(PurchaseVO info) {
		// TODO Auto-generated method stub

	}



	@Override
	public ResultMessage submit(PurchaseVO Info) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}



	@Override
	public ResultMessage save(PurchaseVO Info) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}



	@Override
	public ArrayList<PurchaseVO> inventoryCheck(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
