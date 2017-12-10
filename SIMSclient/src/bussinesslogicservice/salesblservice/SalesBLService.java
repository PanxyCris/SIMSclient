package bussinesslogicservice.salesblservice;

import java.util.*;

import vo.PromotionVO;
import vo.commodity.CommodityItemVO;
import vo.commodity.CommodityVO;
import vo.member.MemberVO;
import vo.sale.SalesAddVO;
import vo.sale.SalesVO;
public interface SalesBLService {

	/**
	 * ��ȡ���۵�ID�������˻���ID
	 * @return ID
	 */
	public String getSaleID();
	public String getBackSaleID();
	
	/**
	 * ͨ��ID��ȡ��Ʒ��Ϣ 
	 * @param ID
	 * @return ��Ʒ��ϸ��Ϣ
	 */
	public CommodityVO getCommodityByID(int ID);

	/**
	 * ������Ʒ
	 * @param item
	 */
	public void addCommodities(CommodityItemVO item);
	
	/**
	 * �鿴������Ʒ
	 * @param commodityID
	 * @return ������Ʒ�б�
	 */
	public ArrayList<PromotionVO> getCommodityPromotionListByID(int commodityID);

	/**
	 * ��ȡ�ͻ���Ϣ
	 * @return �ͻ���Ϣ
	 */
	public MemberVO getMember();

	/**
	 * �����ύ����(�˻�)��  
	 * (����״̬��
	 * @param mode
	 * @return ������Ϣ
	 */
	public SalesVO submit(SalesAddVO Info);

	/**
	 * ��������(�˻�)�� 
	 * (�ݸ�״̬)
	 * @param Info
	 * @return ������Ϣ
	 */
	public SalesVO save(SalesAddVO Info);

	/**
	 * �������۵����ƶ�
	 */
	public void endSales();
}
