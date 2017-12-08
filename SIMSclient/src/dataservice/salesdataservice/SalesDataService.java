package SIMSclient.src.dataservice.salesdataservice;

import java.rmi.RemoteException;

import SIMSclient.src.dataservice.CommonDataService;
import SIMSclient.src.po.sales.SalesPO;

public interface SalesDataService extends CommonDataService<SalesPO> {

	public static final String NAME = "SaleData";  //rmi�ӿڵ�����
	public String getSaleID() throws RemoteException;
	public String getSaleBackID() throws RemoteException;
	
}
