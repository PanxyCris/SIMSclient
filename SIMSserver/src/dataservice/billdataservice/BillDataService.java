package dataservice.billdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindInventoryBillType;
import po.inventorybillpo.InventoryBillPO;
public interface BillDataService {

	public Date getDate();
	public BillType getType();
	public BillState getState();
	
	public ResultMessage insertInventoryBill(InventoryBillPO inventoryBillPO) throws RemoteException;
	
	public ResultMessage deleteInventoryBill(String id) throws RemoteException;
	
	public ResultMessage updateInventoryBill(InventoryBillPO inventoryBillPO)throws RemoteException;
	
	public ArrayList<InventoryBillPO> findInventoryBill(String keyword,FindInventoryBillType type)throws RemoteException;
	
	public ArrayList<InventoryBillPO> showInventoryBill() throws RemoteException;//����ǰ�ȫ���Ŀ���൥�ݶ��ù���

}
