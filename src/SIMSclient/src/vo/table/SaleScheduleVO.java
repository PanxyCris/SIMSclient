package SIMSclient.src.vo.table;

public class SaleScheduleVO {
	//ɸѡ����
	String date;//ʱ��,��ȷ����
	String tradeName;//��Ʒ��
	String customer;//�ͻ�
	String clerkID;//ҵ��Ա
	String repertory;//�ֿ�
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public String getRepertory() {
		return repertory;
	}

	public void setRepertory(String repertory) {
		this.repertory = repertory;
	}

	public SaleScheduleVO(String d,String t,String cu,String cl,String r){
		date=d;
		tradeName=t;
		customer=cu;
		clerkID=cl;
		repertory=r;
	}
	
}
