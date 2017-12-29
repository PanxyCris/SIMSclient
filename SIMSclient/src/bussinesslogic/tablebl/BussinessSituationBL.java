package bussinesslogic.tablebl;

import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogicservice.checktableblservice.BussinessSituationBLService;
import bussinesslogicservice.salesblservice.SalesBLService;
import dataenum.MoneyType;
import javafx.util.converter.LocalDateStringConverter;
import vo.billvo.salesbillvo.SalesVO;
import vo.tablevo.PaymentTableVO;
import vo.tablevo.ReceiveTableVO;

public class BussinessSituationBL implements BussinessSituationBLService {

	SalesBLService salesBLService;
	
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
		//商品类支出(报溢报损)
		
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
		//商品类支出(报溢报损)
		
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
