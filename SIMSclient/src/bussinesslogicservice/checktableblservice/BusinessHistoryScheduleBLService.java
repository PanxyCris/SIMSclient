package bussinesslogicservice.checktableblservice;

import java.time.LocalDate;
import java.util.ArrayList;

import dataenum.findtype.FindSaleScheduleType;
import vo.billvo.BillVO;

public interface BusinessHistoryScheduleBLService<B extends BillVO> {

    public ArrayList<B> show();

    public ArrayList<B> siftTime(LocalDate start,LocalDate end);

    public ArrayList<B> sift(String info,FindSaleScheduleType type);//里面的商品名除外

	public void exportReport(ArrayList<B> table);

	public void writeOff(ArrayList<B> table);//红冲

	public void writeOffAndCopy(ArrayList<B> table);//红冲并复制

}
