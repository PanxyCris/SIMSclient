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
import vo.billvo.inventorybillvo.InventoryBillVO;
import vo.billvo.salesbillvo.SalesVO;

/**
*
* @author Lijie
* @date 2017Äê12ÔÂ17ÈÕ
*/
public class ExamineSalesBL implements ExamineBLService<SalesVO> {
	private SalesDataService sale;

	public ExamineSalesBL() {
		sale = RemoteHelper.getInstance().getSalesDataService();
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



	@Override
	public ResultMessage updateBill(SalesVO vo, BillType type) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ResultMessage passBills(ArrayList<SalesVO> vos, BillType type) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ResultMessage notPassBills(ArrayList<SalesVO> vos, BillType type) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ArrayList<SalesVO> getCommitedBills() {
		// TODO Auto-generated method stub
		return null;
	}








}
