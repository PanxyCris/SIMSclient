package SIMSclient.src.vo;

public class PromotionVO {

	public String BillID; // ����ID
	public String clientID; // �ͻ�ID
	public String clientName; // �ͻ�����
	public String cellNumber; // �绰����
	public String user; // ����Ա
	public String saleMan; // ҵ��Ա
	public double beforePrice; // ����ǰ�۸�
	public double allowance; // ���ý��
	public double voucher; // ����ȯ���
	public double afterPrice; // ���ú���
	public String remark; // ��ע
	 
	public PromotionVO(String BillID, String clientID, String clientName, String cellNumber, String user, String saleMan,
			double beforePrice, double allowance, double voucher, double afterPrice, String remark) {
		super();
		this.BillID = BillID;
		this.clientID = clientID;
		this.clientName = clientName;
		this.user = user;
		this.saleMan = saleMan;
		this.beforePrice = beforePrice;
		this.allowance = allowance;
		this.voucher = voucher;
		this.afterPrice = afterPrice;
		this.remark = remark;
	}

}
