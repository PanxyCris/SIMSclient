package SIMSserver.src.po;

import java.io.Serializable;

import SIMSclient.src.vo.bill.ClientCategory;
import SIMSclient.src.vo.bill.MemberLevel;

public class MemberPO implements Serializable {

	private String ID;
	private ClientCategory category; // 客户分类：进货商和销售商
	private MemberLevel level; // 客户级别：五级，一级普通用户，五级VIP客户
	private String name; // 客户名字
	private String cellNumber; // 电话号码
	private String address;
	private String post; // 邮编
	private String email;
	private double receivableLimit; // 应收额度
	private double receivable; // 应收
	private double payable; // 应付
	private String saleMan; // 默认业务员

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
