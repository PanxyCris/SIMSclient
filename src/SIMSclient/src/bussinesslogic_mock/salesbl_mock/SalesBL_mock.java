package SIMSclient.src.bussinesslogic_mock.salesbl_mock;
/**  
* 类说明   
*  
* @author ****  
* @date 2017年11月14日    
*/

import SIMSclient.src.bussinesslogic.salesbl.Sales;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.po.sales.SalesPO;
import SIMSclient.src.vo.sale.SalesVO;

public class SalesBL_mock extends Sales{

	SalesVO vo;
	SalesPO po;
	
	public SalesBL_mock() {
		
	}
	
	public ResultMessage delete(SalesVO vo) {
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage insert(SalesVO vo){
    	return ResultMessage.SUCCESS;
    }
	
	public ResultMessage update(SalesVO vo){
    	return ResultMessage.SUCCESS;
    }

    public ResultMessage find(long id){
    	return ResultMessage.SUCCESS;
    }
    
    public ResultMessage getTotal(SalesVO vo){
    	return ResultMessage.SUCCESS;
    }
}
