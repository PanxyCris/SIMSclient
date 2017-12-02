package SIMSserver.src.dataservice.salesdataservice;

import java.rmi.RemoteException;

import SIMSserver.src.dataservice.CommonDataService;
import SIMSserver.src.po.SalesPO;

public interface SalesDataService extends CommonDataService<SalesPO> {

	public static final String NAME = "SaleData";  //rmi接口的名称
	public String getSaleID() throws RemoteException;
	public String getSaleBackID() throws RemoteException;
	
}
