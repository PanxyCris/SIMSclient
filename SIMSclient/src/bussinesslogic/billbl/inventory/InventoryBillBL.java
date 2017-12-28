package bussinesslogic.billbl.inventory;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogicservice.billblservice.inventory.InventoryBillBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindInventoryBillType;
import dataservice.billdataservice.BillDataService;
import po.inventorybillpo.InventoryBillPO;
import vo.billvo.inventorybillvo.InventoryBillVO;

public class InventoryBillBL implements InventoryBillBLService{

	BillDataService billDataService;
	InventoryTransition inventoryTransition;
	InventoryBillPO inventoryBillPO;
	InventoryBillVO inventoryBillVO;
	
	@Override
	public ArrayList<InventoryBillVO> find(String text, FindInventoryBillType type) {
		ArrayList<InventoryBillVO> inventoryBillVOs=new ArrayList<>();
		try {
			ArrayList<InventoryBillPO> inventoryBillPOs = billDataService.findInventoryBill(text, type);
			for (int i = 0; i < inventoryBillPOs.size(); i++) {
				inventoryBillVOs.add(inventoryTransition.POtoVO(inventoryBillPOs.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return inventoryBillVOs;
	}

	@Override
	public ArrayList<InventoryBillVO> show() {
		ArrayList<InventoryBillVO> inventoryBillVOs=new ArrayList<>();
		try {
			ArrayList<InventoryBillPO> inventoryBillPOs = billDataService.showInventoryBill();
			for (int i = 0; i < inventoryBillPOs.size(); i++) {
				inventoryBillVOs.add(inventoryTransition.POtoVO(inventoryBillPOs.get(i)));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return inventoryBillVOs;
	}

	@Override
	public ResultMessage submit(InventoryBillVO clickedItem) {
		clickedItem.setState(BillState.COMMITED);
		inventoryBillPO=inventoryTransition.VOtoPO(clickedItem);
		try {
			return billDataService.updateInventoryBill(inventoryBillPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public void delete(InventoryBillVO clickedItem) {
		String id=clickedItem.getId();
		try {
			billDataService.deleteInventoryBill(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultMessage save(InventoryBillVO vo) {
		inventoryBillPO=inventoryTransition.VOtoPO(vo);
		try {
			return billDataService.updateInventoryBill(inventoryBillPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public String getId(BillType type) {
		int count=0;
		try {
			ArrayList<InventoryBillPO> inventoryBillPOs=billDataService.showInventoryBill();
			for (int i = 0; i < inventoryBillPOs.size(); i++) {
				if(type==inventoryBillPOs.get(i).getBillType()){
					count++;
				}
			}
			count+=1;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return Integer.toString(count);
	}

}
