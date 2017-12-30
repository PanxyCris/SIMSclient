package bussinesslogic.billbl.inventory;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogicservice.billblservice.inventory.InventoryBillBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindInventoryBillType;
import dataservice.billdataservice.BillDataService;
import javafx.util.converter.LocalDateStringConverter;
import po.inventorybillpo.InventoryBillPO;
import rmi.RemoteHelper;
import vo.billvo.inventorybillvo.InventoryBillVO;

public class InventoryBillBL implements InventoryBillBLService{

	private BillDataService billDataService;
	private InventoryTransition inventoryTransition;
	private InventoryBillPO inventoryBillPO;
	private InventoryBillVO inventoryBillVO;
	
	public InventoryBillBL() {
		billDataService=RemoteHelper.getInstance().getBilldataService();
		inventoryTransition=new InventoryTransition();
	}
	
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
		ArrayList<InventoryBillPO> inventoryBillPOs=null;
		try {
			inventoryBillPOs=billDataService.findInventoryBill(inventoryBillVO.getId(), FindInventoryBillType.ID);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		if(inventoryBillPOs.isEmpty()){
			try {
				return billDataService.insertInventoryBill(inventoryBillPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		else{
			try {
				return billDataService.updateInventoryBill(inventoryBillPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return ResultMessage.FAIL;
	}

	@Override
	public String getId(BillType type) {
		LocalDate l=null;
		l=LocalDate.now();
		int count=0;
		try {
			ArrayList<InventoryBillPO> inventoryBillPOs=billDataService.showInventoryBill();
			for (int i = 0; i < inventoryBillPOs.size(); i++) {
				LocalDate localDate=StringtoDate(inventoryBillPOs.get(i).getId());
				if(type==inventoryBillPOs.get(i).getBillType()&&localDate==l){
					count++;
				}
			}
			count+=1;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		String id="";
		//格式化
		String number=Integer.toString(count);
		while(5>number.length()){
			number="0"+number;
		}
		String[] date=l.toString().split("-");
		
		id=type.prefix+"-"+date[0]+date[1]+date[2]+"-"+number;
		return id;
	}
	
	public LocalDate StringtoDate(String id){//id是单据编号
		String s=id.split("-")[1];
		String date=s.substring(0,4)+"-"+s.substring(4,6)+"-"+s.substring(6, s.length());
		LocalDate l=null;
		LocalDateStringConverter localDate =new LocalDateStringConverter();
		l=localDate.fromString(date);
		return l;
	}

}
