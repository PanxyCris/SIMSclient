package SIMSclient.src.dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.po.BillPO;

/*
 * 公共的数据层父类
 * 包括数据的增删改查
 */
public interface DataService<PO extends BillPO> extends Remote{

	/*初始化数据层接口*/
	public void init() throws RemoteException;
	
	public String getID() throws RemoteException;
	
	
	/*
	 * 对数据PO的增删改
	 */
	public ResultMessage insert(PO po) throws RemoteException;
	
	public ResultMessage delete(String ID) throws RemoteException;
	
	public ResultMessage update(PO po) throws RemoteException;
	
	public PO find(String ID) throws RemoteException;
	
	public ArrayList<PO> show() throws RemoteException;
}

