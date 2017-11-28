package SIMSclient.src.dataservice.salesdataservice;

import java.rmi.RemoteException;

import SIMSclient.src.dataenum.BillType;
import SIMSclient.src.dataservice.DataService;
import SIMSclient.src.po.sales.SalesPO;

public interface SalesDataService extends DataService<SalesPO>{

	/*RMI绑定时候的名称 */
	public static final String NAME = "SaleData";
	
	String getID(BillType type) throws RemoteException;

    String getSaleID() throws RemoteException;

    String getSaleBackID() throws RemoteException;
}
