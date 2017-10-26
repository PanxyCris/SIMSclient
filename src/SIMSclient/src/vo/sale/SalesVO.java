package SIMSclient.src.vo.sale;

import java.util.ArrayList;
import java.util.Date;

import SIMSclient.src.vo.BillVO;
import SIMSclient.src.vo.commodity.CommodityVO;
/**
 *
 * @author
 *
 */
public class SalesVO extends BillVO{
	public String clientID;
	public String clientName;  //�ͻ�����
	public String user; // ����Ա
	public String saleMan; // ҵ��Ա
	public double beforePrice; // ����ǰ�۸�
	public double allowance; // ���ý��
	public double voucher; // ����ȯ���
	public double afterPrice; // ���ú���
	public String remark; // ��ע
	public BillState state; // ����״̬
	public ArrayList<CommodityVO> commodities; // ��Ʒ�嵥

	public SalesVO(int ID, Date date, String clientID, String clientName, String cellNumber, String user, String saleMan,
			double beforePrice, double allowance, double voucher, double afterPrice, String remark,
			BillState state, ArrayList<CommodityVO> commodities) {
	    super(ID, date, state, remark);
		this.id = ID;
		this.date = date;
		this.clientID = clientID;
		this.clientName = clientName;
		this.user = user;
		this.saleMan = saleMan;
		this.beforePrice = beforePrice;
		this.allowance = allowance;
		this.voucher = voucher;
		this.afterPrice = afterPrice;
		this.remark = remark;
		this.state = state;
		this.commodities = commodities;
	}

	public String toString() {
		return "[����ID=" + id +",����="+date+ ", �ͻ�ID=" + clientID + ", �ͻ�����=" + clientName
				+ ", ҵ��Ա=" + saleMan + ", ����Ա=" + user + ", ��Ʒ�б�=" + commodities + ",\r\n����ǰ�ܶ� =" + beforePrice
				+ ", ���ý��=" + allowance + ", ����ȯ�ܶ�=" + voucher + ", ���ú��ܶ�=" + afterPrice + ", ��ע=" + remark + ", ����״̬="
				+ state.value + "]";
	}

}