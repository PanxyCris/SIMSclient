package SIMSclient.src.bussinesslogicservice.promotionblservice;

import java.util.ArrayList;

import SIMSclient.src.vo.PromotionVO;

public interface PromotionBLService {
//dffff
	public ArrayList<PromotionVO> getCommodityPromotionListByID(int commodityID);
	public String getBillID(); // ����ID
	public String getclientID(); // �ͻ�ID
	public String getclientName(); // �ͻ�����
	public String getcellNumber(); // �绰����
	public String getuser(); // ����Ա
	public String getsaleMan(); // ҵ��Ա

}
