package bussinesslogic.tablebl;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogic.examinebl.ExamineSalesBL;
import bussinesslogic.salesbl.SalesController;
import bussinesslogicservice.checktableblservice.BusinessHistoryScheduleBLService;
import bussinesslogicservice.examineblservice.ExamineBLService;
import bussinesslogicservice.salesblservice.SalesBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.Warehouse;
import dataenum.findtype.FindSaleScheduleType;
import javafx.util.converter.LocalDateStringConverter;
import vo.billvo.salesbillvo.SalesVO;
import vo.commodityvo.CommodityItemVO;

public class BusinessHistoryScheduleSalesBL implements BusinessHistoryScheduleBLService<SalesVO> {

	private SalesBLService salesBLService;
	private ExamineBLService<SalesVO> examineBLService;
	
	public BusinessHistoryScheduleSalesBL() {
		salesBLService=new SalesController();
		examineBLService=new ExamineSalesBL();
	}
	
	@Override
	public ArrayList<SalesVO> show() {
		return salesBLService.show();
	}

	@Override
	public ArrayList<SalesVO> siftTime(LocalDate start, LocalDate end) {
		ArrayList<SalesVO> out=new ArrayList<>();
		ArrayList<SalesVO> salesVOs=show();
		for (int i = 0; i < salesVOs.size(); i++) {
			LocalDate localDate=StringtoDate(salesVOs.get(i).getId());
			if(localDate.isAfter(start)&&localDate.isBefore(end)){
				out.add(salesVOs.get(i));
			}
		}
		return out;
	}

	@Override
	public ArrayList<SalesVO> sift(String info, FindSaleScheduleType type) {
		ArrayList<SalesVO> out=new ArrayList<>();
		ArrayList<SalesVO> salesVOs=show();
		if(FindSaleScheduleType.OPERATOR==type){//操作员（业务员）
			for (int i = 0; i < salesVOs.size(); i++) {
				if(salesVOs.get(i).getSaleMan().equals(info)){
					out.add(salesVOs.get(i));
				}
			}
		}
		if(FindSaleScheduleType.WAREHOUSE==type){//仓库
			for (int i = 0; i < salesVOs.size(); i++) {
				if(salesVOs.get(i).getWarehouse().equals(info)){
					out.add(salesVOs.get(i));
				}
			}
		}
		if(FindSaleScheduleType.MEMBER==type){//客户：这里要注意客户为retailer，详情参见salesvo
			for (int i = 0; i < salesVOs.size(); i++) {
				if(salesVOs.get(i).getRetailer().equals(info)){
					out.add(salesVOs.get(i));
				}
			}
		}
		if(FindSaleScheduleType.NAME==type){//商品，返回所有带有该商品的单据
			for (int i = 0; i < salesVOs.size(); i++) {
				ArrayList<CommodityItemVO> commodityItemVOs=salesVOs.get(i).getCommodity();
				for (int j = 0; j < commodityItemVOs.size(); j++) {
					if(commodityItemVOs.get(i).getName().equals(info)){
						out.add(salesVOs.get(i));
						break;
					}
				}
			}
		}
		return out;
	}

	@Override
	public void exportReport(ArrayList<SalesVO> table) {
		
	}

	@Override
	public ArrayList<SalesVO> writeOff(ArrayList<SalesVO> table) {
		ArrayList<SalesVO> sList=new ArrayList<>();
		for (int i = 0; i < table.size(); i++) {
			SalesVO salesVO=redRush(table.get(i));
			salesVO.setState(BillState.COMMITED);
			salesBLService.save(salesVO);
			sList.add(salesVO);
		}
		try {
			examineBLService.passBills(sList);
			return sList;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ArrayList<SalesVO> writeOffAndCopy(ArrayList<SalesVO> table) {
		ArrayList<SalesVO> sList=new ArrayList<>();
		for (int i = 0; i < table.size(); i++) {
			SalesVO salesVO=redRush(table.get(i));
			salesVO.setState(BillState.COMMITED);
			salesBLService.save(salesVO);
			sList.add(salesVO);
		}		
		return sList;
	}

	public LocalDate StringtoDate(String id){//id是单据编号
		String s=id.split("-")[1];
		String date=s.substring(0,4)+"-"+s.substring(4,6)+"-"+s.substring(6, s.length());
		LocalDate l=null;
		LocalDateStringConverter localDate =new LocalDateStringConverter();
		l=localDate.fromString(date);
		return l;
	}
	
	public SalesVO redRush(SalesVO salesVO){
		String id=salesBLService.getBackSaleID();
		String retailer=salesVO.getRetailer();
		String saleMan=salesVO.getSaleMan();
		String operator=salesVO.getOperator();
		String note=salesVO.getNote();
		BillState billState=salesVO.getState();
		BillType billType=salesVO.getType();
		Warehouse warehouse=salesVO.getWarehouse();
		
		Double beforePrice=-salesVO.getBeforePrice();
		Double allowance=-salesVO.getAllowance();
		Double voucher=-salesVO.getVoucher();
		Double afterPrice=-salesVO.getAfterPrice();
		
		ArrayList<CommodityItemVO> commodity=salesVO.getCommodity();
		for (int i = 0; i < commodity.size(); i++) {
			Integer number=commodity.get(i).getNumber();
			commodity.get(i).setNumber(-number);
		}
		return new SalesVO(id, retailer, saleMan, operator, warehouse, commodity, beforePrice, allowance, voucher, afterPrice, note, billState, billType);
	}

	@Override
	public ResultMessage updateBill(ArrayList<SalesVO> table) {
		ArrayList<SalesVO> sList=new ArrayList<>();
		for (int i = 0; i < table.size(); i++) {
			SalesVO salesVO=table.get(i);
			salesVO.setState(BillState.COMMITED);
			salesBLService.save(salesVO);
			sList.add(salesVO);
		}
		try {
			examineBLService.passBills(sList);
			return ResultMessage.SUCCESS;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}
	
}
