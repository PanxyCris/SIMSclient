package bussinesslogic.tablebl;

import java.time.LocalDate;
import java.util.ArrayList;

import bussinesslogicservice.checktableblservice.BussinessSituationBLService;
import javafx.util.converter.LocalDateStringConverter;
import vo.tablevo.PaymentTableVO;
import vo.tablevo.ReceiveTableVO;

public class BussinessSituationBL implements BussinessSituationBLService {

	@Override
	public void exportReport(ArrayList<PaymentTableVO> pay, ArrayList<ReceiveTableVO> receive) {//����ǵ���Ϊexcel�ķ���
		
	}

	@Override
	public ArrayList<PaymentTableVO> showPay() {//֧����
		ArrayList<PaymentTableVO> paymentTableVOs=new ArrayList<>();
		
		
		return null;
	}

	@Override
	public ArrayList<ReceiveTableVO> showReceive() {//������
		return null;
	}

	@Override
	public ArrayList<PaymentTableVO> siftPay(LocalDate start, LocalDate end) {
		return null;
	}

	@Override
	public ArrayList<ReceiveTableVO> siftReceive(LocalDate start, LocalDate end) {
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
