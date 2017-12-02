package SIMSclient.src.bussinesslogic_mock.billbl_mock;

import SIMSclient.src.bussinesslogic.billbl.BillBL;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.po.PersistObject;
import SIMSclient.src.vo.ValueObject;

public class BillBL_Mock extends BillBL{

     ValueObject vo;
     PersistObject po;

     public BillBL_Mock(){

     }

     public ResultMessage insert(ValueObject vo){
     	return ResultMessage.SUCCESS;
     }

     public ResultMessage delete(ValueObject vo){
     	return ResultMessage.SUCCESS;
     }

     public ResultMessage update(ValueObject vo){
     	return ResultMessage.SUCCESS;
     }

     public ResultMessage find(long id){
     	return ResultMessage.SUCCESS;
     }

     public ResultMessage finds(String field, int value){
     	return ResultMessage.SUCCESS;
     }
}
