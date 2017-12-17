package bussinesslogicservice.examineblservice;
/**     
*  审批接口
* @author Lijie 
* @date 2017年12月17日    
*/

import java.util.ArrayList;

import dataenum.BillType;
import dataenum.ResultMessage;
import vo.ViewObject;
import vo.billvo.BillVO;

public interface ExamineBLService {

	public ResultMessage updateBill(ViewObject vo, BillType type);

	public ResultMessage passBills(ArrayList<BillVO> vos, BillType type);
	
	public ResultMessage notPassBills(ArrayList<BillVO> vos, BillType type);
}
