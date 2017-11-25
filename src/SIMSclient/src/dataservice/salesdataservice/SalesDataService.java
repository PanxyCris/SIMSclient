package SIMSclient.src.dataservice.salesdataservice;

import java.rmi.RemoteException;

import SIMSclient.src.dataenum.BillType;
import SIMSclient.src.dataservice.DataService;

public interface SalesDataService extends DataService{

	/*RMI��ʱ������� */
	public static final String NAME = "SaleData";
	
	String getID(BillType type) throws RemoteException;

    String getSaleID() throws RemoteException;

    String getSaleBackID() throws RemoteException;
}
