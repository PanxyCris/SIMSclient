package SIMSserver.src.po.table;


public class BusinessHistorySchedulePO {
	//ɸѡ����
	String date;//ʱ��
	String billType;
	String customer;//�ͻ�
	int clerkID;//ҵ��Ա
	String repertory;//�ֿ�
	
	public BusinessHistorySchedulePO(String d,String b,String cu,int cl,String r){
		date=d;
		billType=b;
		customer=cu;
		clerkID=cl;
		repertory=r;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public int getClerkID() {
		return clerkID;
	}

	public void setClerkID(int clerkID) {
		this.clerkID = clerkID;
	}

	public String getRepertory() {
		return repertory;
	}

	public void setRepertory(String repertory) {
		this.repertory = repertory;
	}
	
}
