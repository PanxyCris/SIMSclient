package bussinesslogic.tablebl;

import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogic.billbl.inventory.InventoryBillBL;
import bussinesslogic.billbl.inventory.InventoryBillController;
import bussinesslogic.salesbl.SalesController;
import bussinesslogicservice.billblservice.inventory.InventoryBillBLService;
import bussinesslogicservice.billblservice.inventory.InventoryGiftBillBLService;
import bussinesslogicservice.checktableblservice.BussinessSituationBLService;
import bussinesslogicservice.salesblservice.SalesBLService;
import dataenum.MoneyType;
import javafx.util.converter.LocalDateStringConverter;
import vo.billvo.inventorybillvo.InventoryBillVO;
import vo.billvo.salesbillvo.SalesVO;
import vo.tablevo.PaymentTableVO;
import vo.tablevo.ReceiveTableVO;

public class BussinessSituationBL implements BussinessSituationBLService {

	SalesBLService salesBLService;
	InventoryBillBLService inventoryBillBLService;
	
	public BussinessSituationBL() {
		salesBLService=new SalesController();
		inventoryBillBLService=new InventoryBillController();
	}
	
	@Override
	public void exportReport(ArrayList<PaymentTableVO> pay, ArrayList<ReceiveTableVO> receive) {//����ǵ���Ϊexcel�ķ���
		
	}

	@Override
	public ArrayList<PaymentTableVO> showPay() {//֧����
		ArrayList<PaymentTableVO> paymentTableVOs=new ArrayList<>();
		
		ArrayList<SalesVO> salesVOs=salesBLService.show();//���۳ɱ�
		for (int i = 0; i < salesVOs.size(); i++) {
			LocalDate localDate=StringtoDate(salesVOs.get(i).getId());
			Double sum=salesVOs.get(i).getAfterPrice();//���۳ɱ�
			paymentTableVOs.add(new PaymentTableVO(localDate, MoneyType.SALES, sum));
		}
		//��Ʒ����
		ArrayList<InventoryBillVO> inventoryBillVOs1=inventoryBillBLService.
		
		
		return paymentTableVOs;
	}

	@Override
	public ArrayList<ReceiveTableVO> showReceive() {//������
		ArrayList<ReceiveTableVO> receiveTableVOs=new ArrayList<>();
		
		ArrayList<SalesVO> salesVOs=salesBLService.show();//��������
		for (int i = 0; i < salesVOs.size(); i++) {
			LocalDate localDate=StringtoDate(salesVOs.get(i).getId());
			Double sum=salesVOs.get(i).getAfterPrice();//������������
			Double allowance=salesVOs.get(i).getAllowance();//�������ý��
			receiveTableVOs.add(new ReceiveTableVO(localDate, MoneyType.SALES, allowance,sum));
		}
		
		return receiveTableVOs;
	}

	@Override
	public ArrayList<PaymentTableVO> siftPay(LocalDate start, LocalDate end) {
		ArrayList<PaymentTableVO> paymentTableVOs=new ArrayList<>();
		
		ArrayList<SalesVO> salesVOs=salesBLService.show();//���۳ɱ�
		for (int i = 0; i < salesVOs.size(); i++) {
			LocalDate localDate=StringtoDate(salesVOs.get(i).getId());
			if(localDate.isBefore(end)&&localDate.isAfter(start)){
				Double sum=salesVOs.get(i).getAfterPrice();//���۳ɱ�
				paymentTableVOs.add(new PaymentTableVO(localDate, MoneyType.SALES, sum));
			}
		}
		//��Ʒ��֧��(���籨��)
		
		return paymentTableVOs;
	}

	@Override
	public ArrayList<ReceiveTableVO> siftReceive(LocalDate start, LocalDate end) {
		ArrayList<ReceiveTableVO> receiveTableVOs=new ArrayList<>();
		
		ArrayList<SalesVO> salesVOs=salesBLService.show();//��������
		for (int i = 0; i < salesVOs.size(); i++) {
			LocalDate localDate=StringtoDate(salesVOs.get(i).getId());
			if(localDate.isAfter(start)&&localDate.isBefore(end)){
				Double sum=salesVOs.get(i).getAfterPrice();//������������
				Double allowance=salesVOs.get(i).getAllowance();//�������ý��
				receiveTableVOs.add(new ReceiveTableVO(localDate, MoneyType.SALES, allowance,sum));
			}
		}
		
		return receiveTableVOs;
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
