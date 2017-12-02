package SIMSserver.src.dataservice.salesdataservice;

import java.util.ArrayList;

import SIMSclient.src.vo.PromotionVO;
import SIMSclient.src.vo.commodity.CommodityVO;
import SIMSclient.src.vo.member.MemberVO;
import SIMSclient.src.vo.sale.SalesAddVO;
import SIMSclient.src.vo.sale.SalesVO;
import SIMSserver.src.dataservice.CommonDataService;
import SIMSserver.src.po.SalesPO;

public interface SalesDataService extends CommonDataService<SalesPO> {

	/**
	 * ��ȡ���۵�ID�������˻���ID
	 * @return ID
	 */
	public String getSaleID();
	public String getBackID();
	
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
	public void addCommodities(CommodityVO item);
	
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
