package bussinesslogic.tablebl;

import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogic.billbl.inventory.InventoryBillController;
import bussinesslogicservice.billblservice.inventory.InventoryBillBLService;
import bussinesslogicservice.checktableblservice.BusinessHistoryScheduleBLService;
import dataenum.BillType;
import dataenum.findtype.FindSaleScheduleType;
import javafx.util.converter.LocalDateStringConverter;
import vo.billvo.inventorybillvo.InventoryBillVO;

public class BusinessHistoryScheduleInventoryBL implements BusinessHistoryScheduleBLService<InventoryBillVO> {

	private InventoryBillBLService inventoryBillBLService;
	
	public BusinessHistoryScheduleInventoryBL() {
		inventoryBillBLService=new InventoryBillController();
	}
	
	@Override
	public ArrayList<InventoryBillVO> show() {//ֻչʾ���硢�������͵�
		ArrayList<InventoryBillVO> out=new ArrayList<>();
		ArrayList<InventoryBillVO> inventoryBillVOs=inventoryBillBLService.show();
		for (int i = 0; i < inventoryBillVOs.size(); i++) {//����
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
		 ���������д
		 */
		return null;
	}

	@Override
	public void exportReport(ArrayList<InventoryBillVO> table) {

	}

	@Override
	public ArrayList<InventoryBillVO> writeOff(ArrayList<InventoryBillVO> table) {
		return null;
	}

	@Override
	public ArrayList<InventoryBillVO> writeOffAndCopy(ArrayList<InventoryBillVO> table) {
		return null;
	}

	public LocalDate StringtoDate(String id){//id�ǵ��ݱ��
		String s=id.split("-")[1];
		String date=s.substring(0,4)+"-"+s.substring(4,6)+"-"+s.substring(6, s.length());
		LocalDate l=null;
		LocalDateStringConverter localDate =new LocalDateStringConverter();
		l=localDate.fromString(date);
		return l;
	}
	
}
