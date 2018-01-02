package bussinesslogic.tablebl;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogic.billbl.inventory.InventoryBillController;
import bussinesslogic.examinebl.ExamineInventoryBL;
import bussinesslogicservice.billblservice.inventory.InventoryBillBLService;
import bussinesslogicservice.checktableblservice.BusinessHistoryScheduleBLService;
import bussinesslogicservice.examineblservice.ExamineBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindSaleScheduleType;
import javafx.util.converter.LocalDateStringConverter;
import vo.billvo.inventorybillvo.InventoryBillVO;
import vo.commodityvo.GiftVO;

public class BusinessHistoryScheduleInventoryBL implements BusinessHistoryScheduleBLService<InventoryBillVO> {

	private InventoryBillBLService inventoryBillBLService;
	private ExamineBLService<InventoryBillVO> examineBLService;
	
	public BusinessHistoryScheduleInventoryBL() {
		inventoryBillBLService=new InventoryBillController();
		examineBLService=new ExamineInventoryBL();
	}
	
	@Override
	public ArrayList<InventoryBillVO> show() {//只展示报溢、报损、赠送单
		ArrayList<InventoryBillVO> out=new ArrayList<>();
		ArrayList<InventoryBillVO> inventoryBillVOs=inventoryBillBLService.show();
		for (int i = 0; i < inventoryBillVOs.size(); i++) {//过滤
			if(inventoryBillVOs.get(i).getType()!=BillType.INVENTORYWARNINGBILL){
				out.add(inventoryBillVOs.get(i));
			}
		}
		return out;
	}

	@Override
	public ArrayList<InventoryBillVO> siftTime(LocalDate start, LocalDate end) {
		ArrayList<InventoryBillVO> out=new ArrayList<>();
		ArrayList<InventoryBillVO> inventoryBillVOs=show();
		for (int i = 0; i < inventoryBillVOs.size(); i++) {//
			LocalDate localDate=StringtoDate(inventoryBillVOs.get(i).getId());
			if(localDate.isAfter(start)&&localDate.isBefore(end)){
				out.add(inventoryBillVOs.get(i));
			}
		}
		return out;
	}

	@Override
	public ArrayList<InventoryBillVO> sift(String info, FindSaleScheduleType type) {
		/*
		 这个方法不写
		 */
		return null;
	}

	@Override
	public void exportReport(ArrayList<InventoryBillVO> table) {

	}

	@Override
	public ArrayList<InventoryBillVO> writeOff(ArrayList<InventoryBillVO> table) {
		ArrayList<InventoryBillVO> iList=new ArrayList<>();
		for (int i = 0; i < table.size(); i++) {
			InventoryBillVO inventoryBillVO=redRush(table.get(i));
			inventoryBillVO.setState(BillState.COMMITED);
			inventoryBillBLService.save(inventoryBillVO);
			iList.add(inventoryBillVO);
		}
		try {
			examineBLService.passBills(iList);
			return iList;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<InventoryBillVO> writeOffAndCopy(ArrayList<InventoryBillVO> table) {
		ArrayList<InventoryBillVO> iList=new ArrayList<>();
		for (int i = 0; i < table.size(); i++) {
			InventoryBillVO inventoryBillVO=redRush(table.get(i));
			inventoryBillVO.setState(BillState.COMMITED);
			inventoryBillBLService.save(inventoryBillVO);
			iList.add(inventoryBillVO);
		}
		return iList;
	}

	public LocalDate StringtoDate(String id){//id是单据编号
		String s=id.split("-")[1];
		String date=s.substring(0,4)+"-"+s.substring(4,6)+"-"+s.substring(6, s.length());
		LocalDate l=null;
		LocalDateStringConverter localDate =new LocalDateStringConverter();
		l=localDate.fromString(date);
		return l;
	}
	
	public InventoryBillVO redRush(InventoryBillVO inventoryBillVO){
		String operator=inventoryBillVO.getOperator();
		BillState billState=inventoryBillVO.getState();
		BillType billType=inventoryBillVO.getType();
		String note=inventoryBillVO.getNote();
		String id=inventoryBillBLService.getId(billType);
		ArrayList<GiftVO> gifts=inventoryBillVO.getGifts();
		for (int i = 0; i < gifts.size(); i++) {
			int number=gifts.get(i).getNumber();
			gifts.get(i).setNumber(-number);
		}
		return new InventoryBillVO(id, gifts, operator, billType, billState, note);
	}

	@Override
	public ResultMessage updateBill(ArrayList<InventoryBillVO> table) {
		
		return ResultMessage.FAIL;
	}
	
}
