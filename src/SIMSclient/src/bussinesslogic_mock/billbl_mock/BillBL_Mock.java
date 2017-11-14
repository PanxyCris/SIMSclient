package SIMSclient.src.bussinesslogic_mock.billbl_mock;

import SIMSclient.src.ResultMessage;
import SIMSclient.src.bussinesslogic.billbl.BillBL;
import SIMSclient.src.po.BillPO;
import SIMSclient.src.vo.bill.BillVO;

public class BillBL_Mock extends BillBL{

     BillVO vo;
     BillPO po;

     public BillBL_Mock(){

     }

     public ResultMessage insert(BillVO vo){
     	return ResultMessage.SUCCESS;
     }

     public ResultMessage delete(BillVO vo){
     	return ResultMessage.SUCCESS;
     }

     public ResultMessage update(BillVO vo){
     	return ResultMessage.SUCCESS;
     }

     public ResultMessage find(long id){
     	return ResultMessage.SUCCESS;
     }

     public ResultMessage finds(String field, int value){
     	return ResultMessage.SUCCESS;
     }
}
