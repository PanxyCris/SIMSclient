package bussinesslogic.tablebl;

import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogic.purchasebl.PurchaseController;
import bussinesslogicservice.checktableblservice.BusinessHistoryScheduleBLService;
import bussinesslogicservice.purchaseblservice.PurchaseBLService;
import dataenum.findtype.FindSaleScheduleType;
import javafx.util.converter.LocalDateStringConverter;
import vo.billvo.purchasebillvo.PurchaseVO;
import vo.commodityvo.CommodityItemVO;

public class BussinessHistorySchedulePurchaseBL implements BusinessHistoryScheduleBLService<PurchaseVO> {

	private PurchaseBLService purchaseBLService;
	
	public BussinessHistorySchedulePurchaseBL() {
		purchaseBLService=new PurchaseController();
	}
	
	@Override
	public ArrayList<PurchaseVO> show() {
		return purchaseBLService.show();
	}

	@Override
	public ArrayList<PurchaseVO> siftTime(LocalDate start, LocalDate end) {
		ArrayList<PurchaseVO> out=new ArrayList<>();
		ArrayList<PurchaseVO> purchaseVOs=show();
		for (int i = 0; i < purchaseVOs.size(); i++) {
			LocalDate localDate=StringtoDate(purchaseVOs.get(i).getId());
			if(localDate.isAfter(start)&&localDate.isBefore(end)){
				out.add(purchaseVOs.get(i));
			}
		}
		return out;
	}

	@Override
	public ArrayList<PurchaseVO> sift(String info, FindSaleScheduleType type) {
		ArrayList<PurchaseVO> out=new ArrayList<>();
		ArrayList<PurchaseVO> purchaseVOs=show();
		if(FindSaleScheduleType.OPERATOR==type){//����Ա��ҵ��Ա��
			for (int i = 0; i < purchaseVOs.size(); i++) {
				if(purchaseVOs.get(i).getOperator().equals(info)){
					out.add(purchaseVOs.get(i));
				}
			}
		}
		if(FindSaleScheduleType.WAREHOUSE==type){//�ֿ�
			for (int i = 0; i < purchaseVOs.size(); i++) {
				if(purchaseVOs.get(i).getWarehouse().equals(info)){
					out.add(purchaseVOs.get(i));
				}
			}
		}
		if(FindSaleScheduleType.MEMBER==type){//�ͻ�������Ҫע��ͻ�Ϊretailer������μ�salesvo
			for (int i = 0; i < purchaseVOs.size(); i++) {
				if(purchaseVOs.get(i).getSupplier().equals(info)){
					out.add(purchaseVOs.get(i));
				}
			}
		}
		if(FindSaleScheduleType.NAME==type){//��Ʒ���������д��и���Ʒ�ĵ���
			for (int i = 0; i < purchaseVOs.size(); i++) {
				ArrayList<CommodityItemVO> commodityItemVOs=purchaseVOs.get(i).getCommodities();
				for (int j = 0; j < commodityItemVOs.size(); j++) {
					if(commodityItemVOs.get(i).getName().equals(info)){
						out.add(purchaseVOs.get(i));
						break;
					}
				}
			}
		}
		return out;
	}

	@Override
	public void exportReport(ArrayList<PurchaseVO> table) {
		
	}

	@Override
	public ArrayList<PurchaseVO> writeOff(ArrayList<PurchaseVO> table) {
		return null;
	}

	@Override
	public ArrayList<PurchaseVO> writeOffAndCopy(ArrayList<PurchaseVO> table) {
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
