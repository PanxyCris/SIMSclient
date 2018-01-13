package po.tablepo;

import dataenum.Warehouse;
import po.PersistObject;

/**
 * ������ϸ�� �̳�PersistObjct ��ԭ����������private���Σ�����serialVersionUID,ȥ��date, ��Ϊdate�ڸ���PersistObject�Զ����� 
 * ��clerkIDתString
 * �޸��ߣ�lijie
 */
public class SaleSchedulePO extends PersistObject {
	private static final long serialVersionUID = 1L;
	// ɸѡ����
	private String tradeName;// ��Ʒ��
	private String customer;// �ͻ�
	private String clerkID;// ҵ��Ա
	private Warehouse warehouse;// �ֿ�

	
	public SaleSchedulePO(String id, String tradeName, String customer, String clerkID, Warehouse warehouse) {
		super(id);
		this.tradeName = tradeName;
		this.customer = customer;
		this.clerkID = clerkID;
		this.warehouse = warehouse;
	}

	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getClerkID() {
		return clerkID;
	}

	public void setClerkID(String clerkID) {
		this.clerkID = clerkID;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

}
