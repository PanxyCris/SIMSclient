package bussinesslogicservice.checktableblservice;

import java.time.LocalDate;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindSaleScheduleType;
import vo.billvo.BillVO;

public interface BusinessHistoryScheduleBLService<B extends BillVO> {

    public ArrayList<B> show();

    public ArrayList<B> siftTime(LocalDate start,LocalDate end);

    public ArrayList<B> sift(String info,FindSaleScheduleType type);//�������Ʒ������

	public void exportReport(ArrayList<B> table);

	public ArrayList<B> writeOff(ArrayList<B> table);//���

	public ArrayList<B> writeOffAndCopy(ArrayList<B> table);//��岢����
	
	public ResultMessage updateBill(B table);//����岢���Ƶĵ�������

}
