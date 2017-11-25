package SIMSclient.src.bussinesslogic_mock.member_mock;
/**  
* 类说明   
*  
* @author ****  
* @date 2017年11月14日    
*/

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.po.MemberPO;
import SIMSclient.src.vo.commodity.CommodityVO;
import SIMSclient.src.vo.member.MemberVO;

public class MemberBL_mock {

	MemberVO vo;
	MemberPO po;
	
	public MemberBL_mock() {
		
	}
	
	public ResultMessage insert(MemberVO vo){
    	return ResultMessage.SUCCESS;
    }

    public ResultMessage delete(MemberVO vo){
    	return ResultMessage.SUCCESS;
    }

    public ResultMessage update(MemberVO vo){
    	return ResultMessage.SUCCESS;
    }

    public ResultMessage find(long id){
    	return ResultMessage.SUCCESS;
    }

    public ResultMessage finds(String field, int value){
    	return ResultMessage.SUCCESS;
    }


    public ResultMessage getTotal(MemberVO vo){
    	return ResultMessage.SUCCESS;
    }
}
