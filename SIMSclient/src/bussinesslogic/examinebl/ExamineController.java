package bussinesslogic.examinebl;

import java.util.ArrayList;

import bussinesslogicservice.examineblservice.ExamineBLService;
import dataenum.BillType;
import dataenum.ResultMessage;
import vo.ViewObject;
import vo.billvo.BillVO;

/**     
*  
* @author Lijie 
* @date 2017��12��17��    
*/
public class ExamineController implements ExamineBLService {

	@Override
	public ResultMessage passBills(ArrayList<BillVO> vos, BillType type) {
		return null;
	}

	@Override
	public ResultMessage notPassBills(ArrayList<BillVO> vos, BillType type) {
		return null;
	}

	@Override
	public ResultMessage updateBill(ViewObject vo, BillType type) {
		return null;
	}

	
}
