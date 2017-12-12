package bussinesslogic.salesbl;
/**     
*  
* @author Lijie 
* @date 2017Äê12ÔÂ11ÈÕ    
*/

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.BillState;
import dataenum.BillType;
import dataservice.salesdataservice.SalesDataService;
import po.sales.SalesPO;
import rmi.RemoteHelper;
import vo.sale.SalesVO;

public class SaleShow {

	private SalesDataService saledataservice;
	private Sales sale;
	
	public SaleShow() {
		saledataservice = RemoteHelper.getInstance().getSalesDataService();
		sale = new Sales();
	}
	
	public ArrayList<SalesVO> showSale() throws RemoteException {
		return show(BillType.SALESBILL);
	}
	
	
	private ArrayList<SalesVO> show(BillType type) throws RemoteException {
		ArrayList<SalesVO> list = new ArrayList<>();
		ArrayList<SalesVO> sales = getSales();
		for(SalesVO s : sales) {
			if (s.type == type) {
				list.add(s);
			}
		}
		return list;
	}

	
	private ArrayList<SalesVO> show(BillType type, BillState state) throws RemoteException {
		ArrayList<SalesVO> list = new ArrayList<SalesVO>();
		ArrayList<SalesVO> sales = getSales();
		for(SalesVO s : sales) {
			if (s.type.toString().equals(type.toString()) && s.state.toString().equals(state.toString())) {
				list.add(s);
			}
		}
		return list;
	}
	
	private ArrayList<SalesVO> getSales() throws RemoteException {
		ArrayList<SalesVO> VOList = new ArrayList<>();
		ArrayList<SalesPO> POList = saledataservice.showSale();
		for(SalesPO po : POList) {
			SalesVO vo = SalesTransition.POtoVO(po);
			VOList.add(vo);
		}
		return VOList;
	}

}
