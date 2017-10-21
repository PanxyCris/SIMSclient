package SIMSserver.src.po;

import java.io.Serializable;

import SIMSclient.src.vo.bill.ClientCategory;
import SIMSclient.src.vo.bill.MemberLevel;

public class MemberPO implements Serializable {

	private String ID;
	private ClientCategory category; // �ͻ����ࣺ�����̺�������
	private MemberLevel level; // �ͻ������弶��һ����ͨ�û����弶VIP�ͻ�
	private String name; // �ͻ�����
	private String cellNumber; // �绰����
	private String address;
	private String post; // �ʱ�
	private String email;
	private double receivableLimit; // Ӧ�ն��
	private double receivable; // Ӧ��
	private double payable; // Ӧ��
	private String saleMan; // Ĭ��ҵ��Ա

	/**
	 * @param iD
	 * @param category
	 * @param level
	 * @param name
	 * @param cellNumber
	 * @param address
	 * @param post
	 * @param email
	 * @param receivableLimit
	 * @param receivable
	 * @param payable
	 * @param saleMan
	 */
	public MemberPO(String iD, ClientCategory category, MemberLevel level, String name, String cellNumber,
			String address, String post, String email, double receivableLimit, double receivable, double payable,
			String saleMan) {
		super();
		ID = iD;
		this.category = category;
		this.level = level;
		this.name = name;
		this.cellNumber = cellNumber;
		this.address = address;
		this.post = post;
		this.email = email;
		this.receivableLimit = receivableLimit;
		this.receivable = receivable;
		this.payable = payable;
		this.saleMan = saleMan;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getID() {
		return ID;
	}

	public MemberLevel getLevel() {
		return level;
	}

	public void setLevel(MemberLevel level) {
		this.level = level;
	}

	public ClientCategory getCategory() {
		return category;
	}

	public void setCategory(ClientCategory category) {
		this.category = category;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setReceivableLimit(double receivableLimit) {
		this.receivableLimit = receivableLimit;
	}

	public double getReceivableLimit() {
		return receivableLimit;
	}

	public void setReceivable(double receivable) {
		this.receivable = receivable;
	}

	public double getReceivable() {
		return receivable;
	}

	public void setPayable(double payable) {
		this.payable = payable;
	}

	public double getPayable() {
		return payable;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getPost() {
		return post;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}

	public String getCellNumber() {
		return cellNumber;
	}

	public void setSaleMan(String saleMan) {
		this.saleMan = saleMan;
	}

	public String getSaleMan() {
		return saleMan;
	}
}
