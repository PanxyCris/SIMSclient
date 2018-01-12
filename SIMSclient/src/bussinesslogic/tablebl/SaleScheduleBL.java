package bussinesslogic.tablebl;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogic.salesbl.SalesController;
import bussinesslogicservice.checktableblservice.SaleScheduleBLService;
import bussinesslogicservice.salesblservice.SalesBLService;
import dataenum.BillType;
import dataenum.findtype.FindSaleScheduleType;
import javafx.util.converter.LocalDateStringConverter;
import vo.billvo.salesbillvo.SalesVO;
import vo.commodityvo.CommodityItemVO;
import vo.tablevo.SaleScheduleVO;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class SaleScheduleBL implements SaleScheduleBLService {

	private SalesBLService salesBLService;

	public SaleScheduleBL() {
		salesBLService = new SalesController();
	}

	@Override
	public void exportReport(ArrayList<SaleScheduleVO> sale) {// ����ǵ���Ϊexcel�ķ���
		WritableWorkbook wwb = null;
		String fileName = "C:/Users/user/Desktop/SaleSchedule.xlsx";
		try {
			// ����һ����д��Ĺ�������WorkBook������,
			// �����ø��෽��createWorkbook��������WritableWorkbook���������˹�������
			wwb = Workbook.createWorkbook(new File(fileName));

			// ����һ����д��Ĺ�����
			// Workbook��createSheet������������������һ���ǹ���������ƣ��ڶ����ǹ������ڹ������е�λ��
			WritableSheet sSheet = wwb.createSheet("SaleTable", 0);

			int sSheetL = sale.size();

			Label ini = new Label(0, 0, "Date");
			sSheet.addCell(ini);
			ini = new Label(1, 0, "Name");// initialize payment
			sSheet.addCell(ini);
			ini = new Label(2, 0, "Model");
			sSheet.addCell(ini);
			ini = new Label(3, 0, "Number");
			sSheet.addCell(ini);
			ini = new Label(4, 0, "Price");
			sSheet.addCell(ini);
			ini = new Label(5, 0, "Sum");
			sSheet.addCell(ini);

			for (int i = 1; i < sSheetL + 1; i++) {
				for (int j = 0; j < 6; j++) {
					if (j == 0) {
						Label labelC = new Label(j, i, String.valueOf(sale.get(i - 1).getDate()));
						sSheet.addCell(labelC);
					} else if (j == 1) {
						Label labelC = new Label(j, i, sale.get(i - 1).getName());
						sSheet.addCell(labelC);
					} else if (j == 2) {
						Label labelC = new Label(j, i, sale.get(i - 1).getModel());
						sSheet.addCell(labelC);
					} else if (j == 3) {
						Label labelC = new Label(j, i, String.valueOf(sale.get(i - 1).getNumber()));
						sSheet.addCell(labelC);
					} else if (j == 4) {
						Label labelC = new Label(j, i, String.valueOf(sale.get(i - 1).getPrice()));
						sSheet.addCell(labelC);
					} else {
						Label labelC = new Label(j, i, String.valueOf(sale.get(i - 1).getSum()));
						sSheet.addCell(labelC);
					}
				}
			}
			wwb.write();// ���ڴ���д���ļ���
			wwb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("����Excel�ļ�" + fileName + "�ɹ�");
	}

	@Override
	public ArrayList<SaleScheduleVO> show() {
		ArrayList<SalesVO> salesVOs = salesBLService.show();

		ArrayList<SaleScheduleVO> saleScheduleVOs = new ArrayList<>();
		for (int i = 0; i < salesVOs.size(); i++) {
			if (BillType.SALESBILL == salesVOs.get(i).getType()) {
				LocalDate localDate = StringtoDate(salesVOs.get(i).getId());
				ArrayList<CommodityItemVO> commodityItemVOs = salesVOs.get(i).getCommodity();
				for (int j = 0; j < commodityItemVOs.size(); j++) {
					String name = commodityItemVOs.get(j).getName();
					String model = commodityItemVOs.get(j).getModel();
					Integer number = commodityItemVOs.get(j).getNumber();
					Double price = commodityItemVOs.get(j).getPrice();
					SaleScheduleVO saleScheduleVO = new SaleScheduleVO(localDate, name, model, number, price);
					saleScheduleVOs.add(saleScheduleVO);
				}
			}
		}
		return saleScheduleVOs;
	}

	@Override
	public ArrayList<SaleScheduleVO> siftTime(LocalDate start, LocalDate end) {
		ArrayList<SalesVO> salesVOs = salesBLService.show();

		SaleScheduleVO saleScheduleVO = null;
		ArrayList<SaleScheduleVO> saleScheduleVOs = new ArrayList<>();
		for (int i = 0; i < salesVOs.size(); i++) {
			if (BillType.SALESBILL == salesVOs.get(i).getType()) {
				LocalDate localDate = StringtoDate(salesVOs.get(i).getId());
				if ((localDate.isEqual(start) || localDate.isAfter(start))
						&& (localDate.isEqual(end) || localDate.isBefore(end))) {
					ArrayList<CommodityItemVO> commodityItemVOs = salesVOs.get(i).getCommodity();
					for (int j = 0; j < commodityItemVOs.size(); j++) {
						String name = commodityItemVOs.get(j).getName();
						String model = commodityItemVOs.get(j).getModel();
						Integer number = commodityItemVOs.get(j).getNumber();
						Double price = commodityItemVOs.get(j).getPrice();
						saleScheduleVO = new SaleScheduleVO(localDate, name, model, number, price);
						saleScheduleVOs.add(saleScheduleVO);
					}
				}
			}
		}
		return saleScheduleVOs;
	}

	@Override
	public ArrayList<SaleScheduleVO> sift(String info, FindSaleScheduleType type) {
		ArrayList<SalesVO> salesVOs = salesBLService.show();

		SaleScheduleVO saleScheduleVO = null;
		ArrayList<SaleScheduleVO> saleScheduleVOs = new ArrayList<>();
		for (int i = 0; i < salesVOs.size(); i++) {
			if (BillType.SALESBILL == salesVOs.get(i).getType()) {
				LocalDate localDate = StringtoDate(salesVOs.get(i).getId());
				String member = salesVOs.get(i).getRetailer();// ����ֱ���õĿͻ�string
				String operator = salesVOs.get(i).getOperator();
				String wareHouse = salesVOs.get(i).getWarehouseString();
				ArrayList<CommodityItemVO> commodityItemVOs = salesVOs.get(i).getCommodity();
				for (int j = 0; j < commodityItemVOs.size(); j++) {
					String name = commodityItemVOs.get(j).getName();
					String model = commodityItemVOs.get(j).getModel();
					Integer number = commodityItemVOs.get(j).getNumber();
					Double price = commodityItemVOs.get(j).getPrice();
					if (type == FindSaleScheduleType.NAME && name.equals(info)) {
						saleScheduleVO = new SaleScheduleVO(localDate, name, model, number, price);
						saleScheduleVOs.add(saleScheduleVO);
						continue;
					}
					if (type == FindSaleScheduleType.MEMBER && member.equals(info)) {
						saleScheduleVO = new SaleScheduleVO(localDate, name, model, number, price);
						saleScheduleVOs.add(saleScheduleVO);
						continue;
					}
					if (type == FindSaleScheduleType.OPERATOR && operator.equals(info)) {
						saleScheduleVO = new SaleScheduleVO(localDate, name, model, number, price);
						saleScheduleVOs.add(saleScheduleVO);
						continue;
					}
					if (type == FindSaleScheduleType.WAREHOUSE && wareHouse.equals(info)) {
						saleScheduleVO = new SaleScheduleVO(localDate, name, model, number, price);
						saleScheduleVOs.add(saleScheduleVO);
						continue;
					}
				}
			}
		}
		return saleScheduleVOs;
	}

	public LocalDate StringtoDate(String id) {// id�ǵ��ݱ��
		String s = id.split("-")[1];
		String date = s.substring(0, 4) + "-" + s.substring(4, 6) + "-" + s.substring(6, s.length());
		LocalDate l = null;
		LocalDateStringConverter localDate = new LocalDateStringConverter();
		l = localDate.fromString(date);
		return l;
	}

}
