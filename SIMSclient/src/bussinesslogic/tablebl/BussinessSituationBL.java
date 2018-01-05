package bussinesslogic.tablebl;

import java.io.File;
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
  

import jxl.Workbook;  
import jxl.write.Label;  
import jxl.write.WritableSheet;  
import jxl.write.WritableWorkbook;

//����Ʒ�������������
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
	public void exportReport(ArrayList<PaymentTableVO> pay, ArrayList<ReceiveTableVO> receive) {//����ǵ���Ϊexcel�ķ���
		WritableWorkbook wwb = null;  
	 	String fileName="C:/Users/user/Desktop/BussinessSituation.xlsx";
        try {  
            // ����һ����д��Ĺ�������WorkBook������,  
            //�����ø��෽��createWorkbook��������WritableWorkbook���������˹�������  
            wwb = Workbook.createWorkbook(new File(fileName));  
              
            // ����һ����д��Ĺ�����   
            // Workbook��createSheet������������������һ���ǹ���������ƣ��ڶ����ǹ������ڹ������е�λ��  
            WritableSheet pSheet = wwb.createSheet("PaymentTableVO", 0);
            WritableSheet rSheet = wwb.createSheet("ReceiptTableVO", 1);
            
            int pSheetL=pay.size();
            int rSheetL=receive.size();
           
            Label ini = new Label(0,0,"Date");  
            pSheet.addCell(ini);
            ini=new Label(0, 1, "Type");//initialize payment
            pSheet.addCell(ini);
            ini=new Label(0, 2, "Sum");
            pSheet.addCell(ini);
            
            ini = new Label(0,0,"Date");  
            rSheet.addCell(ini);
            ini=new Label(0, 1, "Type");//initialize receipt;
            rSheet.addCell(ini);
            ini=new Label(0, 2, "Allowance");
            rSheet.addCell(ini);
            ini=new Label(0, 3, "Sum");
            rSheet.addCell(ini);
          
            for(int i=1;i<pSheetL+1;i++){  
                for(int j=0;j<3;j++){
                	if(j==0){
                		Label labelC = new Label(j,i,String.valueOf(pay.get(i).getDate()));  
                        pSheet.addCell(labelC); 
                	}
                	else if(j==1){
                		Label labelC = new Label(j,i,pay.get(i).getTypeString());  
                        pSheet.addCell(labelC); 
                	}
                	else{
                		Label labelC = new Label(j,i,Double.toString(pay.get(i).getSum()));  
                        pSheet.addCell(labelC); 
                	}
                }  
            }  
            
            for(int i=1;i<rSheetL+1;i++){  
                for(int j=0;j<4;j++){
                	if(j==0){
                		 Label labelC = new Label(j,i,String.valueOf(receive.get(i).getDate()));  
                         rSheet.addCell(labelC);  
                	}
                	else if(j==1){
                		 Label labelC = new Label(j,i,receive.get(i).getTypeString());  
                         rSheet.addCell(labelC); 
                	}
                	else if(j==2){
                		 Label labelC = new Label(j,i,Double.toString(receive.get(i).getAllowance()));  
                         rSheet.addCell(labelC); 
                	}
                	else{
                		 Label labelC = new Label(j,i,Double.toString(receive.get(i).getSum()));  
                         rSheet.addCell(labelC); 
                	}
                }  
            }  
            wwb.write();// ���ڴ���д���ļ���  
            wwb.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        System.out.println("���ɵ�һ��Excel�ļ�"+fileName+"�ɹ�");  
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
		//��Ʒ���������
		ArrayList<InventoryBillVO> inventoryBillVOs=inventoryBillBLService.show();
		for (int i = 0; i < inventoryBillVOs.size(); i++) {
			if(inventoryBillVOs.get(i).getType()==BillType.INVENTORYGIFTBILL||inventoryBillVOs.get(i).getType()==BillType.INVENTORYLOSSBILL){
				LocalDate localDate=StringtoDate(inventoryBillVOs.get(i).getId());
				double sum=0.0;
				ArrayList<GiftVO> giftVOs=inventoryBillVOs.get(i).getGifts();
				for (int j = 0; j < giftVOs.size(); j++) {
					try {//���������һ�����ݿ⣬�����Ż�
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
		//��Ʒ���������
		ArrayList<InventoryBillVO> inventoryBillVOs=inventoryBillBLService.show();
		for (int i = 0; i < inventoryBillVOs.size(); i++) {
			LocalDate localDate=StringtoDate(inventoryBillVOs.get(i).getId());
			if(localDate.isBefore(end)&&localDate.isAfter(start)){
				if(inventoryBillVOs.get(i).getType()==BillType.INVENTORYGIFTBILL||inventoryBillVOs.get(i).getType()==BillType.INVENTORYLOSSBILL){
					double sum=0.0;
					ArrayList<GiftVO> giftVOs=inventoryBillVOs.get(i).getGifts();
					for (int j = 0; j < giftVOs.size(); j++) {
						try {//���������һ�����ݿ⣬�����Ż�
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
