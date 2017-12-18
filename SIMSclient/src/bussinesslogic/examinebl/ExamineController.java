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
import vo.ViewObject;
import vo.billvo.BillVO;
import vo.sale.SalesVO;

/**     
*  
* @author Lijie 
* @date 2017Äê12ÔÂ17ÈÕ    
*/
public class ExamineController implements ExamineBLService {
	private SalesDataService sale;
	
	public ExamineController() {
		sale = RemoteHelper.getInstance().getSalesDataService();
	}

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
		switch (type) {
		case SALESBILL:
			SalesVO salevo = (SalesVO) vo;
			SalesPO po = SalesTransition.VOtoPO(salevo);
			try {
				sale.updateSale(po);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			break;
		case SALESBACKBILL:
			break;
		default:
			break;
		}
		return null;
	}

	
}
