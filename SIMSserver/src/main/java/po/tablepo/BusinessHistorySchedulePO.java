package po.tablepo;

import dataenum.BillType;
import dataenum.Warehouse;
import po.PersistObject;

/**
 * ��Ӫ���̱�
 * �̳�PersistObjct
 * ��ԭ����������private���Σ�����serialVersionUID,ȥ��date, ��Ϊdate�ڸ���PersistObject�Զ�����
 * �޸��ߣ�lijie
 */
public class BusinessHistorySchedulePO extends PersistObject{
	private static final long serialVersionUID = 1L;
	//ɸѡ����
	private BillType type;
	private String customer;//�ͻ�
	private String clerkID;//ҵ��Ա
	private Warehouse warehouse;//�ֿ�
	
	/** 
	* @Description: TODO(������һ�仰�����������������) 
	* @param @param id
	* @param @param type
	* @param @param customer
	* @param @param clerkID
	* @param @param warehouse    �趨�ļ� 
	* @return   �������� 
	* @throws 
	*/
	public BusinessHistorySchedulePO(String id, BillType type, String customer, String clerkID, Warehouse warehouse) {
		super(id);
		this.type = type;
		this.customer = customer;
		this.clerkID = clerkID;
		this.warehouse = warehouse;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BillType getType() {
		return type;
	}

	public String getCustomer() {
		return customer;
	}

	public String getClerkID() {
		return clerkID;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setType(BillType type) {
		this.type = type;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public void setClerkID(String clerkID) {
		this.clerkID = clerkID;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	
	
	
		
}
