package SIMSclient.src.bussinesslogic_mock.commoditybl_mock;

import SIMSclient.src.bussinesslogic.commoditybl.ClassificationBL;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.po.ClassificationPO;
import SIMSclient.src.vo.commodity.ClassificationVO;

public class ClassificationBL_Mock extends ClassificationBL {

	ClassificationVO vo;
	ClassificationPO po;

	public ClassificationBL_Mock(){

	}

	public ResultMessage insert(ClassificationVO vo){
		return ResultMessage.SUCCESS;
	}

	public ResultMessage delete(ClassificationVO vo){
		return ResultMessage.SUCCESS;
	}
	public ResultMessage update(ClassificationVO vo){
		return ResultMessage.SUCCESS;
	}

}
