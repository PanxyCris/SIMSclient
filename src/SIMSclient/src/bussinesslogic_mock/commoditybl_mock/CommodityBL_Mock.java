package SIMSclient.src.bussinesslogic_mock.commoditybl_mock;

import SIMSclient.src.bussinesslogic.commoditybl.CommodityBL;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.po.CommodityPO;
import SIMSclient.src.vo.commodity.CommodityVO;

public class CommodityBL_Mock extends CommodityBL{

    CommodityVO vo;
    CommodityPO po;

    public CommodityBL_Mock(){

    }

    public ResultMessage insert(CommodityVO vo){
    	return ResultMessage.SUCCESS;
    }

    public ResultMessage delete(CommodityVO vo){
    	return ResultMessage.SUCCESS;
    }

    public ResultMessage update(CommodityVO vo){
    	return ResultMessage.SUCCESS;
    }

    public ResultMessage find(long id){
    	return ResultMessage.SUCCESS;
    }

    public ResultMessage finds(String field, int value){
    	return ResultMessage.SUCCESS;
    }

    public ResultMessage addBill(CommodityVO vo){
    	return ResultMessage.SUCCESS;
    }

    public ResultMessage addSales(CommodityVO vo){
    	return ResultMessage.SUCCESS;
    }

    public ResultMessage getTotal(CommodityVO vo){
    	return ResultMessage.SUCCESS;
    }
}
