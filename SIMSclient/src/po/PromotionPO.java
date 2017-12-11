package po;

public class PromotionPO extends PersistObject{

	private static final long serialVersionUID = 1L;
	
	public PromotionPO(String id) {
		super(id);
	}
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
	
}
