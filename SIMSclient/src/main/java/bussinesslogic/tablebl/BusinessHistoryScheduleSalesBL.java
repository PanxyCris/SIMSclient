package bussinesslogic.tablebl;

import java.io.File;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogic.examinebl.ExamineSalesBL;
import bussinesslogic.salesbl.SalesController;
import bussinesslogicservice.examineblservice.ExamineBLService;
import bussinesslogicservice.salesblservice.SalesBLService;
import bussinesslogicservice.tableblservice.BusinessHistoryScheduleBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.Warehouse;
import dataenum.findtype.FindSaleScheduleType;
import javafx.util.converter.LocalDateStringConverter;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import vo.billvo.salesbillvo.SalesVO;
import vo.commodityvo.CommodityItemVO;
import vo.commodityvo.GiftVO;

public class BusinessHistoryScheduleSalesBL implements BusinessHistoryScheduleBLService<SalesVO> {

	private SalesBLService salesBLService;
	private ExamineBLService<SalesVO> examineBLService;

	public BusinessHistoryScheduleSalesBL() {
		salesBLService = new SalesController();
		examineBLService = new ExamineSalesBL();
	}

	@Override
	public ArrayList<SalesVO> show() {
		ArrayList<SalesVO> out = new ArrayList<>();
		ArrayList<SalesVO> salesVOs = salesBLService.show();
		for (int i = 0; i < salesVOs.size(); i++) {
			if (salesVOs.get(i).getState() == BillState.SUCCESS) {
				out.add(salesVOs.get(i));
			}
		}
		return out;
	}

	@Override
	public ArrayList<SalesVO> siftTime(LocalDate start, LocalDate end) {
		ArrayList<SalesVO> out = new ArrayList<>();
		ArrayList<SalesVO> salesVOs = show();
		for (int i = 0; i < salesVOs.size(); i++) {
			LocalDate localDate = StringtoDate(salesVOs.get(i).getId());
			if ((localDate.isAfter(start) || localDate.isEqual(start))
					&& (localDate.isBefore(end) || localDate.isEqual(end))
					&& salesVOs.get(i).getState() == BillState.SUCCESS) {
				out.add(salesVOs.get(i));
			}
		}
		return out;
	}

	@Override
	public ArrayList<SalesVO> sift(String info, FindSaleScheduleType type) {
		ArrayList<SalesVO> out = new ArrayList<>();
		ArrayList<SalesVO> salesVOs = show();
		if (FindSaleScheduleType.OPERATOR == type) {// ����Ա��ҵ��Ա��
			for (int i = 0; i < salesVOs.size(); i++) {
				if (salesVOs.get(i).getSaleMan().equals(info)) {
					out.add(salesVOs.get(i));
				}
			}
		}
		if (FindSaleScheduleType.WAREHOUSE == type) {// �ֿ�
			for (int i = 0; i < salesVOs.size(); i++) {
				if (salesVOs.get(i).getWarehouse().equals(info)) {
					out.add(salesVOs.get(i));
				}
			}
		}
		if (FindSaleScheduleType.MEMBER == type) {// �ͻ�������Ҫע��ͻ�Ϊretailer������μ�salesvo
			for (int i = 0; i < salesVOs.size(); i++) {
				if (salesVOs.get(i).getRetailer().equals(info)) {
					out.add(salesVOs.get(i));
				}
			}
		}
		if (FindSaleScheduleType.NAME == type) {// ��Ʒ���������д��и���Ʒ�ĵ���
			for (int i = 0; i < salesVOs.size(); i++) {
				ArrayList<CommodityItemVO> commodityItemVOs = salesVOs.get(i).getCommodity();
				for (int j = 0; j < commodityItemVOs.size(); j++) {
					if (commodityItemVOs.get(i).getName().equals(info)) {
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
		WritableWorkbook wwb = null;
		String fileName = "C:/Users/user/Desktop/SaleSchedule.xlsx";
		try {
			// ����һ����д��Ĺ�������WorkBook������,
			// �����ø��෽��createWorkbook��������WritableWorkbook���������˹�������
			wwb = Workbook.createWorkbook(new File(fileName));

			// ����һ����д��Ĺ�����
			// Workbook��createSheet������������������һ���ǹ���������ƣ��ڶ����ǹ������ڹ������е�λ��
			WritableSheet bSheet = wwb.createSheet("SaleTable", 0);

			int bSheetL = table.size();

			Label ini = new Label(0, 0, "Date");
			bSheet.addCell(ini);
			ini = new Label(1, 0, "Id");// initialize
			bSheet.addCell(ini);
			ini = new Label(2, 0, "Type");
			bSheet.addCell(ini);
			ini = new Label(3, 0, "Operator");
			bSheet.addCell(ini);

			for (int i = 1; i < bSheetL + 1; i++) {
				for (int j = 0; j < 4; j++) {
					if (j == 0) {
						Label labelC = new Label(j, i, String.valueOf(StringtoDate(table.get(i-1).getId())));
						bSheet.addCell(labelC);
					} else if (j == 1) {
						Label labelC = new Label(j, i, table.get(i - 1).getId());
						bSheet.addCell(labelC);
					} else if (j == 2) {
						Label labelC = new Label(j, i, table.get(i - 1).getTypeString());
						bSheet.addCell(labelC);
					} else {
						Label labelC = new Label(j, i, table.get(i - 1).getOperator());
						bSheet.addCell(labelC);
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
	public ArrayList<SalesVO> writeOff(ArrayList<SalesVO> table) {
		ArrayList<SalesVO> sList = new ArrayList<>();
		for (int i = 0; i < table.size(); i++) {
			SalesVO salesVO = redRush(table.get(i));
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
		ArrayList<SalesVO> sList = new ArrayList<>();
		for (int i = 0; i < table.size(); i++) {
			SalesVO salesVO = redRush(table.get(i));
			salesBLService.save(salesVO);
			sList.add(salesVO);
		}
		return sList;
	}

	public LocalDate StringtoDate(String id) {// id�ǵ��ݱ��
		String s = id.split("-")[1];
		String date = s.substring(0, 4) + "-" + s.substring(4, 6) + "-" + s.substring(6, s.length());
		LocalDate l = null;
		LocalDateStringConverter localDate = new LocalDateStringConverter();
		l = localDate.fromString(date);
		return l;
	}

	public SalesVO redRush(SalesVO salesVO) {
		String id = "";
		if (salesVO.getType() == BillType.SALESBACKBILL)
			id = salesBLService.getBackSaleID();
		else
			id = salesBLService.getSaleID();
		String retailer = salesVO.getRetailer();
		String saleMan = salesVO.getSaleMan();
		String operator = salesVO.getOperator();
		String note = salesVO.getNote();
		BillState billState = salesVO.getState();
		BillType billType = salesVO.getType();
		Warehouse warehouse = salesVO.getWarehouse();

		Double beforePrice = -salesVO.getBeforePrice();
		Double allowance = -salesVO.getAllowance();
		Double voucher = -salesVO.getVoucher();
		Double afterPrice = -salesVO.getAfterPrice();

		ArrayList<CommodityItemVO> commodity = salesVO.getCommodity();
		for (int i = 0; i < commodity.size(); i++) {
			Integer number = commodity.get(i).getNumber();
			commodity.get(i).setNumber(-number);
		}

		ArrayList<GiftVO> giftVOs = salesVO.getGifts();
		for (int i = 0; i < giftVOs.size(); i++) {
			Integer number = giftVOs.get(i).getNumber();
			giftVOs.get(i).setNumber(number);
		}

		return new SalesVO(id, retailer, saleMan, operator, warehouse, commodity, giftVOs, beforePrice, allowance,
				voucher, afterPrice, note, billState, billType);
	}

	@Override
	public ResultMessage updateBill(SalesVO table) {
		ArrayList<SalesVO> sList = new ArrayList<>();
		SalesVO salesVO = table;
		salesVO.setState(BillState.COMMITED);
		salesBLService.save(salesVO);
		sList.add(salesVO);
		try {
			examineBLService.passBills(sList);
			return ResultMessage.SUCCESS;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

}
