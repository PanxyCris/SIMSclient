package SIMSclient.src.bussinesslogic_mock.commoditybl_mock;

import java.util.*;

import SIMSclient.src.ResultMessage;
import SIMSclient.src.bussinesslogic.commoditybl.CommodityList;

public class CommodityList_Mock extends CommodityList{

	ArrayList<CommodityBL_Mock> commodityList;

	public CommodityList_Mock(){

	}

	public ResultMessage check(CommodityList_Mock list){
		return ResultMessage.SUCCESS;
	}

	public ResultMessage stock(CommodityList_Mock list){
		return ResultMessage.SUCCESS;
	}


}