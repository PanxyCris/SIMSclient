package bussinesslogic.tablebl;

import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogic.billbl.inventory.InventoryBillController;
import bussinesslogic.commoditybl.CommodityBL;
import bussinesslogic.salesbl.SalesController;
import bussinesslogicservice.billblservice.inventory.InventoryBillBLService;
import bussinesslogicservice.checktableblservice.BussinessSituationBLService;
import bussinesslogicservice.commodityblservice.CommodityBLService;
import bussinesslogicservice.salesblservice.SalesBLService;
import dataenum.BillType;
import dataenum.MoneyType;
import dataenum.findtype.FindCommodityType;
import javafx.util.converter.LocalDateStringConverter;
import vo.billvo.inventorybillvo.InventoryBillVO;
import vo.billvo.salesbillvo.SalesVO;
import vo.commodityvo.CommodityVO;
import vo.commodityvo.GiftVO;
import vo.tablevo.PaymentTableVO;
import vo.tablevo.ReceiveTableVO;

//对商品类收入存在疑问
public class BussinessSituationBL implements BussinessSituationBLService {

	private SalesBLService salesBLService;
	private InventoryBillBLService inventoryBillBLService;
	private CommodityBLService commodityBLService;
	
	public BussinessSituationBL() {
		salesBLService=new SalesController();
		inventoryBillBLService=new InventoryBillController();
		commodityBLService=new CommodityBL();
	}
	
	@Override
	public void exportReport(ArrayList<PaymentTableVO> pay, ArrayList<ReceiveTableVO> receive) {//这个是导出为excel的方法
		
	}

	@Override
	public ArrayList<PaymentTableVO> showPay() {//支出类
		ArrayList<PaymentTableVO> paymentTableVOs=new ArrayList<>();
		
		ArrayList<SalesVO> salesVOs=salesBLService.show();//销售成本
		for (int i = 0; i < salesVOs.size(); i++) {
			LocalDate localDate=StringtoDate(salesVOs.get(i).getId());
			Double sum=salesVOs.get(i).getAfterPrice();//销售成本
			paymentTableVOs.add(new PaymentTableVO(localDate, MoneyType.SALES, sum));
		}
		//商品报损或赠出
		ArrayList<InventoryBillVO> inventoryBillVOs=inventoryBillBLService.show();
		for (int i = 0; i < inventoryBillVOs.size(); i++) {
			if(inventoryBillVOs.get(i).getType()==BillType.INVENTORYGIFTBILL||inventoryBillVOs.get(i).getType()==BillType.INVENTORYLOSSBILL){
				LocalDate localDate=StringtoDate(inventoryBillVOs.get(i).getId());
				double sum=0.0;
				ArrayList<GiftVO> giftVOs=inventoryBillVOs.get(i).getGifts();
				for (int j = 0; j < giftVOs.size(); j++) {
					try {//这里会多访问一次数据库，可以优化
						ArrayList<CommodityVO> commodityVOs=commodityBLService.find(giftVOs.get(i).getName(), FindCommodityType.NAME);
						sum+=commodityVOs.get(0).getPurPrice()*giftVOs.get(i).getNumber();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				paymentTableVOs.add(new PaymentTableVO(localDate, MoneyType.COMMODITY, sum));
			}
		}
		
		return paymentTableVOs;
	}

	@Override
	public ArrayList<ReceiveTableVO> showReceive() {//收入类
		ArrayList<ReceiveTableVO> receiveTableVOs=new ArrayList<>();
		
		ArrayList<SalesVO> salesVOs=salesBLService.show();//销售收入
		for (int i = 0; i < salesVOs.size(); i++) {
			LocalDate localDate=StringtoDate(salesVOs.get(i).getId());
			Double sum=salesVOs.get(i).getAfterPrice();//销售折让收入
			Double allowance=salesVOs.get(i).getAllowance();//销售折让金额
			receiveTableVOs.add(new ReceiveTableVO(localDate, MoneyType.SALES, allowance,sum));
		}
		
		return receiveTableVOs;
	}

	@Override
	public ArrayList<PaymentTableVO> siftPay(LocalDate start, LocalDate end) {
		ArrayList<PaymentTableVO> paymentTableVOs=new ArrayList<>();
		
		ArrayList<SalesVO> salesVOs=salesBLService.show();//销售成本
		for (int i = 0; i < salesVOs.size(); i++) {
			LocalDate localDate=StringtoDate(salesVOs.get(i).getId());
			if(localDate.isBefore(end)&&localDate.isAfter(start)){
				Double sum=salesVOs.get(i).getAfterPrice();//销售成本
				paymentTableVOs.add(new PaymentTableVO(localDate, MoneyType.SALES, sum));
			}
		}
		//商品报损或赠出
		ArrayList<InventoryBillVO> inventoryBillVOs=inventoryBillBLService.show();
		for (int i = 0; i < inventoryBillVOs.size(); i++) {
			LocalDate localDate=StringtoDate(inventoryBillVOs.get(i).getId());
			if(localDate.isBefore(end)&&localDate.isAfter(start)){
				if(inventoryBillVOs.get(i).getType()==BillType.INVENTORYGIFTBILL||inventoryBillVOs.get(i).getType()==BillType.INVENTORYLOSSBILL){
					double sum=0.0;
					ArrayList<GiftVO> giftVOs=inventoryBillVOs.get(i).getGifts();
					for (int j = 0; j < giftVOs.size(); j++) {
						try {//这里会多访问一次数据库，可以优化
							ArrayList<CommodityVO> commodityVOs=commodityBLService.find(giftVOs.get(i).getName(), FindCommodityType.NAME);
							sum+=commodityVOs.get(0).getPurPrice()*giftVOs.get(i).getNumber();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					paymentTableVOs.add(new PaymentTableVO(localDate, MoneyType.COMMODITY, sum));
				}
			}
		}
		
		return paymentTableVOs;
	}

	@Override
	public ArrayList<ReceiveTableVO> siftReceive(LocalDate start, LocalDate end) {
		ArrayList<ReceiveTableVO> receiveTableVOs=new ArrayList<>();
		
		ArrayList<SalesVO> salesVOs=salesBLService.show();//销售收入
		for (int i = 0; i < salesVOs.size(); i++) {
			LocalDate localDate=StringtoDate(salesVOs.get(i).getId());
			if(localDate.isAfter(start)&&localDate.isBefore(end)){
				Double sum=salesVOs.get(i).getAfterPrice();//销售折让收入
				Double allowance=salesVOs.get(i).getAllowance();//销售折让金额
				receiveTableVOs.add(new ReceiveTableVO(localDate, MoneyType.SALES, allowance,sum));
			}
		}
		
		return receiveTableVOs;
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
