package SIMSclient.src.dataservice.salesdataservice;

import java.rmi.RemoteException;

import SIMSclient.src.po.BillPO.BillType;

public interface SalesDataService {

	String NAME = "SaleData";
	
	String getID(BillType type) throws RemoteException;

    String getSaleID() throws RemoteException;

    String getSaleBackID() throws RemoteException;
}
