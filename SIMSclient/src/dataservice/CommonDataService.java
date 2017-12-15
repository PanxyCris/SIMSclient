package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import java.util.ArrayList;

import dataenum.ResultMessage;
import po.PersistObject;
import po.PurchasePO;
import po.sales.SalesPO;


/**
*  通用的数据层接口，包括数据的增删改查
* @author Lijie
* @date 2017年12月2日
*/
public interface CommonDataService extends Remote {

	public ArrayList<SalesPO> showSales() throws RemoteException;
	public ArrayList<PurchasePO> showPurchase() throws RemoteException;
}
