package bussinesslogicservice.checktableblservice;

import java.time.LocalDate;
import java.util.ArrayList;
import dataenum.findtype.FindSaleScheduleType;
import vo.tablevo.SaleScheduleVO;

public interface SaleScheduleBLService {
    /**
     * �������
     */
	public void exportReport();
    /**
     * չʾ��ȫ���б�
     * @return
     */
	public ArrayList<SaleScheduleVO> show();
    /**
     * ͨ��ʱ����б��ɸѡ
     * @param start
     * @param end
     * @return
     */
	public ArrayList<SaleScheduleVO> siftTime(LocalDate start,LocalDate end);
    /**
     * ͨ���������Խ��б��ɸѡ
     * @param info
     * @param type
     * @return
     */
	public ArrayList<SaleScheduleVO> sift(String info,FindSaleScheduleType type);

}
