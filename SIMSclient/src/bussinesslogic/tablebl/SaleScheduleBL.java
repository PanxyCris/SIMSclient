package bussinesslogic.tablebl;

import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogicservice.checktableblservice.SaleScheduleBLService;
import bussinesslogicservice.salesblservice.SalesBLService;
import dataenum.findtype.FindSaleScheduleType;
import javafx.util.converter.LocalDateStringConverter;
import vo.billvo.salesbillvo.SalesVO;
import vo.commodityvo.CommodityItemVO;
import vo.tablevo.SaleScheduleVO;

public class SaleScheduleBL implements SaleScheduleBLService {

	SalesBLService salesBLService;
	
	
	@Override
	public void exportReport() {//这个是导出为excel的方法
		
	}

	@Override
	public ArrayList<SaleScheduleVO> show() {
		ArrayList<SalesVO> salesVOs=salesBLService.show();
		
		SaleScheduleVO saleScheduleVO=null;
		ArrayList<SaleScheduleVO> saleScheduleVOs=new ArrayList<>();
		for (int i = 0; i < salesVOs.size(); i++) {
			LocalDate localDate=StringtoDate(salesVOs.get(i).getId());
			ArrayList<CommodityItemVO> commodityItemVOs=salesVOs.get(i).getCommodity();
			for (int j = 0; j < commodityItemVOs.size(); j++) {
				String name=commodityItemVOs.get(i).getName();
				String model=commodityItemVOs.get(i).getModel();
				Integer number=commodityItemVOs.get(i).getNumber();
				Double price=commodityItemVOs.get(i).getPrice();
				saleScheduleVO=new SaleScheduleVO(localDate, name, model, number, price);
				saleScheduleVOs.add(saleScheduleVO);
			}
		}
		return saleScheduleVOs;
	}

	@Override
	public ArrayList<SaleScheduleVO> siftTime(LocalDate start, LocalDate end) {
		ArrayList<SalesVO> salesVOs=salesBLService.show();
		
		SaleScheduleVO saleScheduleVO=null;
		ArrayList<SaleScheduleVO> saleScheduleVOs=new ArrayList<>();
		for (int i = 0; i < salesVOs.size(); i++) {
			LocalDate localDate=StringtoDate(salesVOs.get(i).getId());
			if(localDate.isAfter(start)&&localDate.isBefore(end)){
				ArrayList<CommodityItemVO> commodityItemVOs=salesVOs.get(i).getCommodity();
				for (int j = 0; j < commodityItemVOs.size(); j++) {
					String name=commodityItemVOs.get(i).getName();
					String model=commodityItemVOs.get(i).getModel();
					Integer number=commodityItemVOs.get(i).getNumber();
					Double price=commodityItemVOs.get(i).getPrice();
					saleScheduleVO=new SaleScheduleVO(localDate, name, model, number, price);
					saleScheduleVOs.add(saleScheduleVO);
				}
			}
		}
		return saleScheduleVOs;
	}

	@Override
	public ArrayList<SaleScheduleVO> sift(String info, FindSaleScheduleType type) {
		ArrayList<SalesVO> salesVOs=salesBLService.show();
		
		SaleScheduleVO saleScheduleVO=null;
		ArrayList<SaleScheduleVO> saleScheduleVOs=new ArrayList<>();
		for (int i = 0; i < salesVOs.size(); i++) {
			LocalDate localDate=StringtoDate(salesVOs.get(i).getId());
			String member=salesVOs.get(i).getRetailer();//这里直接用的客户string
			String operator=salesVOs.get(i).getOperator();
			String wareHouse=salesVOs.get(i).getWarehouseString();
			ArrayList<CommodityItemVO> commodityItemVOs=salesVOs.get(i).getCommodity();
			for (int j = 0; j < commodityItemVOs.size(); j++) {
				String name=commodityItemVOs.get(i).getName();
				String model=commodityItemVOs.get(i).getModel();
				Integer number=commodityItemVOs.get(i).getNumber();
				Double price=commodityItemVOs.get(i).getPrice();
				if(type==FindSaleScheduleType.NAME&&name==info){
					saleScheduleVO=new SaleScheduleVO(localDate, name, model, number, price);
					saleScheduleVOs.add(saleScheduleVO);
					continue;
				}
				if(type==FindSaleScheduleType.MEMBER&&member==info){
					saleScheduleVO=new SaleScheduleVO(localDate, name, model, number, price);
					saleScheduleVOs.add(saleScheduleVO);
					continue;
				}
				if(type==FindSaleScheduleType.OPERATOR&&operator==info){
					saleScheduleVO=new SaleScheduleVO(localDate, name, model, number, price);
					saleScheduleVOs.add(saleScheduleVO);
					continue;
				}
				if(type==FindSaleScheduleType.WAREHOUSE&&wareHouse==info){
					saleScheduleVO=new SaleScheduleVO(localDate, name, model, number, price);
					saleScheduleVOs.add(saleScheduleVO);
					continue;
				}
			}
		}
		return saleScheduleVOs;
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
