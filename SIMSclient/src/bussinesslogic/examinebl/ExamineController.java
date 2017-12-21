package bussinesslogic.examinebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogic.salesbl.SalesTransition;
import bussinesslogicservice.examineblservice.ExamineBLService;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataservice.salesdataservice.SalesDataService;
import po.sales.SalesPO;
import rmi.RemoteHelper;
import vo.billvo.BillVO;
/**     
*  
* @author Lijie 
* @date 2017Äê12ÔÂ17ÈÕ    
*/
public class ExamineController implements ExamineBLService<BillVO> {
	private SalesDataService sale;
	
	public ExamineController() {
		sale = RemoteHelper.getInstance().getSalesDataService();
	}

	@Override
	public ResultMessage updateBill(BillVO vo, BillType type) {
		return null;
	}

	@Override
	public ResultMessage passBills(ArrayList<BillVO> vos, BillType type) {
		return null;
	}

	@Override
	public ResultMessage notPassBills(ArrayList vos, BillType type) {
		return null;
	}

}
