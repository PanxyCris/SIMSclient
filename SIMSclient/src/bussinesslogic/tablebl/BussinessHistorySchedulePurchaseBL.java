package bussinesslogic.tablebl;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogic.examinebl.ExaminePurchaseBL;
import bussinesslogic.purchasebl.PurchaseController;
import bussinesslogicservice.checktableblservice.BusinessHistoryScheduleBLService;
import bussinesslogicservice.examineblservice.ExamineBLService;
import bussinesslogicservice.purchaseblservice.PurchaseBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Warehouse;
import dataenum.findtype.FindSaleScheduleType;
import javafx.util.converter.LocalDateStringConverter;
import vo.billvo.purchasebillvo.PurchaseVO;
import vo.commodityvo.CommodityItemVO;

public class BussinessHistorySchedulePurchaseBL implements BusinessHistoryScheduleBLService<PurchaseVO> {

	private PurchaseBLService purchaseBLService;
	private ExamineBLService<PurchaseVO> examineBLService;
	
	public BussinessHistorySchedulePurchaseBL() {
		purchaseBLService=new PurchaseController();
		examineBLService=new ExaminePurchaseBL();
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
		if(FindSaleScheduleType.OPERATOR==type){//操作员（业务员）
			for (int i = 0; i < purchaseVOs.size(); i++) {
				if(purchaseVOs.get(i).getOperator().equals(info)){
					out.add(purchaseVOs.get(i));
				}
			}
		}
		if(FindSaleScheduleType.WAREHOUSE==type){//仓库
			for (int i = 0; i < purchaseVOs.size(); i++) {
				if(purchaseVOs.get(i).getWarehouse().equals(info)){
					out.add(purchaseVOs.get(i));
				}
			}
		}
		if(FindSaleScheduleType.MEMBER==type){//客户：这里要注意客户为retailer，详情参见salesvo
			for (int i = 0; i < purchaseVOs.size(); i++) {
				if(purchaseVOs.get(i).getSupplier().equals(info)){
					out.add(purchaseVOs.get(i));
				}
			}
		}
		if(FindSaleScheduleType.NAME==type){//商品，返回所有带有该商品的单据
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
		ArrayList<PurchaseVO> pList=new ArrayList<>();
		for (int i = 0; i < table.size(); i++) {
			PurchaseVO purchaseVO=redRush(table.get(i));
			purchaseVO.setState(BillState.COMMITED);
			purchaseBLService.save(purchaseVO);
			pList.add(purchaseVO);
		}
		try {
			examineBLService.passBills(pList);
			return pList;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<PurchaseVO> writeOffAndCopy(ArrayList<PurchaseVO> table) {
		ArrayList<PurchaseVO> pList=new ArrayList<>();
		for (int i = 0; i < table.size(); i++) {
			PurchaseVO purchaseVO=redRush(table.get(i));
			purchaseVO.setState(BillState.COMMITED);
			purchaseBLService.save(purchaseVO);
			pList.add(purchaseVO);
		}
		return pList;
	}

	public LocalDate StringtoDate(String id){//id是单据编号
		String s=id.split("-")[1];
		String date=s.substring(0,4)+"-"+s.substring(4,6)+"-"+s.substring(6, s.length());
		LocalDate l=null;
		LocalDateStringConverter localDate =new LocalDateStringConverter();
		l=localDate.fromString(date);
		return l;
	}
	
	public PurchaseVO redRush(PurchaseVO purchaseVO){
		String supplier=purchaseVO.getSupplier();
		Warehouse warehouse=purchaseVO.getWarehouse();
		String operator=purchaseVO.getOperator();
		String note=purchaseVO.getNote();
		BillState billState=purchaseVO.getState();
		BillType billType=purchaseVO.getType();
		Double sum=-purchaseVO.getSum();
		String id=purchaseBLService.getPurChaseBackID();//这个不是我写的getId()方法
		ArrayList<CommodityItemVO> commodities=purchaseVO.getCommodities();
		for (int i = 0; i < commodities.size(); i++) {
			Integer number=commodities.get(i).getNumber();
			commodities.get(i).setNumber(-number);
		}
		return new PurchaseVO(id, supplier, warehouse, operator, commodities, note, sum, billType, billState);
	}
	
}
