package SIMSserver.src.po;

import java.util.ArrayList;

import SIMSclient.src.vo.commodity.CommodityItemVO;

/**
 * ��˵��
 * 
 * @author ****
 * @date 2017��10��22��
 */
public class PurchasePO {

	public String ID;
	public String clientID;
	public String clientName;
	public String user;
	public ArrayList<CommodityItemVO> commodities;
	public double beforePrice;
	public String remark;
	public BillType type;
	public BillState state;


	/**
	 * @param iD
	 * @param clientID
	 * @param clientName
	 * @param user
	 * @param commodities
	 * @param beforePrice
	 * @param remark
	 * @param type
	 * @param state
	 */
	public PurchasePO(String iD, String clientID, String clientName, String user,
			ArrayList<CommodityItemVO> commodities, double beforePrice, String remark, BillType type, BillState state) {
		super();
		ID = iD;
		this.clientID = clientID;
		this.clientName = clientName;
		this.user = user;
		this.commodities = commodities;
		this.beforePrice = beforePrice;
		this.remark = remark;
		this.type = type;
		this.state = state;
	}

	@Override
	public String toString() {
		return "[����ID=" + ID + ", �ͻ�ID=" + clientID + ", �ͻ�����=" + clientName  + ", ����Ա=" + user
				+ ", ��Ʒ�б�=" + commodities + ",\r\n��Ʒ�ܼ�=" + beforePrice + ", ��ע=" + remark + ", ��������=" + type.value
				+ ", ����״̬=" + state.value + "]";
	}


}
