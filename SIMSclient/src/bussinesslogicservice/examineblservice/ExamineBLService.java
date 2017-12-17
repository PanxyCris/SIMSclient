package bussinesslogicservice.examineblservice;
/**     
*  �����ӿ�
* @author Lijie 
* @date 2017��12��17��    
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
