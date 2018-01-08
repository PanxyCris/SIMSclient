package data_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindSalesType;
import dataservice.salesdataservice.SalesDataService;
import po.sales.SalesPO;

/**  
* 类说明   
*  
* @author ****  
* @date 2017年10月22日    
*/
public class SalesDataService_Stub implements SalesDataService{

	@Override
	public ArrayList<SalesPO> findSale(String info, FindSalesType type) throws RemoteException {
		return null;
	}


	@Override
	public ResultMessage insertSale(SalesPO po) throws RemoteException {
		return null;
	}


	@Override
	public ResultMessage deleteSale(String ID) throws RemoteException {
		return null;
	}


	@Override
	public ResultMessage updateSale(SalesPO po) throws RemoteException {
		return null;
	}


	@Override
	public ArrayList<SalesPO> showSale() throws RemoteException {
		return null;
	}


	@Override
	public String getSaleBackID() throws RemoteException {
		return null;
	}


	@Override
	public String getSaleID() throws RemoteException {
		return null;
	}


}
