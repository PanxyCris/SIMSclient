package SIMSclient.src.bussinesslogic_mock.commoditybl_mock;

import SIMSclient.src.bussinesslogic.commoditybl.CommodityController;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.vo.commodity.CommodityVO;

public class CommodityController_Mock extends CommodityController{

	public CommodityController_Mock(){

	}

	public ResultMessage addSales(CommodityVO vo){
		return ResultMessage.SUCCESS;
	}

	public ResultMessage addBill(CommodityVO vo){
		return ResultMessage.SUCCESS;
	}

	public ResultMessage getTotal(CommodityVO vo){
		return ResultMessage.SUCCESS;
	}
}
