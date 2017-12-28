package data.billdata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindInventoryBillType;
import dataservice.billdataservice.BillDataService;
import po.inventorybillpo.InventoryBillPO;


public class BillData implements BillDataService {

	@Override
	public Date getDate() {
		return null;
	}

	@Override
	public BillType getType() {
		return null;
	}

	@Override
	public BillState getState() {
		return null;
	}

	@Override
	public ResultMessage insertInventoryBill(InventoryBillPO inventoryBillPO) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage deleteInventoryBill(String id) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updateInventoryBill(InventoryBillPO inventoryBillPO) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<InventoryBillPO> findInventoryBill(String keyword, FindInventoryBillType type)
			throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<InventoryBillPO> showInventoryBill() throws RemoteException {
		return null;
	}

}
