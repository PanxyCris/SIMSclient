package SIMSclient.src.bussinesslogic_mock.purchase_mock;

import SIMSclient.src.ResultMessage;
import SIMSclient.src.bussinesslogic.purchasebl.PurchaseBL;
import SIMSclient.src.po.PurchasePO;
import SIMSclient.src.vo.purchase.PurchaseVO;

/**  
* 类说明   
*  
* @author ****  
* @date 2017年11月14日    
*/
public class PurchaseBL_mock extends PurchaseBL{

	PurchaseVO vo;
	PurchasePO po;
	
	public PurchaseBL_mock() {}
	
	public ResultMessage insert(PurchaseVO vo){
    	return ResultMessage.SUCCESS;
    }

    public ResultMessage delete(PurchaseVO vo){
    	return ResultMessage.SUCCESS;
    }

    public ResultMessage update(PurchaseVO vo){
    	return ResultMessage.SUCCESS;
    }

    public ResultMessage find(long id){
    	return ResultMessage.SUCCESS;
    }

    public ResultMessage finds(String field, int value){
    	return ResultMessage.SUCCESS;
    }

   
    public ResultMessage getTotal(PurchaseVO vo){
    	return ResultMessage.SUCCESS;
    }
}
