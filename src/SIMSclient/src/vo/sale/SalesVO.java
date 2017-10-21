package SIMSclient.src.vo.sale;

import java.util.ArrayList;

import SIMSclient.src.vo.ObjectVO;
import SIMSclient.src.vo.commodity.CommodityItemVO;

public class SalesVO extends ObjectVO{
	public String clientName;  //�ͻ�����
	public String user; // ����Ա
	public String saleMan; // ҵ��Ա
	public double beforePrice; // ����ǰ�۸�
	public double allowance; // ���ý��
	public double voucher; // ����ȯ���
	public double afterPrice; // ���ú���
	public String remark; // ��ע
	public BillType billType; // ��������
	public BillState state; // ����״̬
	public ArrayList<CommodityItemVO> commodities; // ��Ʒ�嵥

	public SalesVO(String ID, String clientName, String cellNumber, String user, String saleMan,
			double beforePrice, double allowance, double voucher, double afterPrice, String remark, BillType billType,
			BillState state, ArrayList<CommodityItemVO> commodities) {
		super();
		this.ID = ID;
		this.clientName = clientName;
		this.cellNumber = cellNumber;
		this.user = user;
		this.saleMan = saleMan;
		this.beforePrice = beforePrice;
		this.allowance = allowance;
		this.voucher = voucher;
		this.afterPrice = afterPrice;
		this.remark = remark;
		this.billType = billType;
		this.state = state;
		this.commodities = commodities;
	}

	@Override
	public String toString() {
		return "[����ID=" + ID + "��������=" + billType.value + ", �ͻ�ID=" + clientID + ", �ͻ�����=" + clientName
				+ ", ҵ��Ա=" + saleMan + ", ����Ա=" + user + ", ��Ʒ�б�=" + commodities + ",\r\n����ǰ�ܶ� =" + beforePrice
				+ ", ���ý��=" + allowance + ", ����ȯ�ܶ�=" + voucher + ", ���ú��ܶ�=" + afterPrice + ", ��ע=" + remark + ", ����״̬="
				+ state.value + "]";
	}

}