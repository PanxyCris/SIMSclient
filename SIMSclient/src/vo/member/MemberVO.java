package vo.member;

import dataenum.MemberCategory;
import dataenum.MemberLevel;

public class MemberVO {
	private String ID;
	private String categoryString;
	private MemberCategory category; // �ͻ����ࣺ�����̺�������
	private String levelString;
	private MemberLevel level; // �ͻ������弶��һ����ͨ�û����弶VIP�ͻ�
	private String name; // �ͻ�����
	private String cellNumber; // �绰����
	private String address;
	private String post; // �ʱ�
	private String email;
	private String receivableLimit; // Ӧ�ն��
	private String receivable; // Ӧ��
	private String payable; // Ӧ��
	private String saleMan; // Ĭ��ҵ��Ա

	/**
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
	public MemberVO(String ID, MemberCategory category, MemberLevel level, String name, String cellNumber,
			String address, String post, String email, String receivableLimit, String receivable, String payable,
			String saleMan) {
		super();
		this.ID = ID;
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
		categoryString = category.value;
		levelString = level.value;
	}

	public String getID() {
		return ID;
	}


	public MemberCategory getCategory() {
		return category;
	}


	public MemberLevel getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = MemberLevel.getLevel(level);
		this.levelString = level;
	}

	public String getName() {
		return name;
	}


	public String getCellNumber() {
		return cellNumber;
	}

	public String getAddress() {
		return address;
	}

	public String getPost() {
		return post;
	}


	public String getEmail() {
		return email;
	}

	public String getReceivableLimit() {
		return receivableLimit;
	}

	public String getReceivable() {
		return receivable;
	}

	public String getPayable() {
		return payable;
	}

	public String getSaleMan() {
		return saleMan;
	}

	public String categoryString(){
		return categoryString;
	}

	public String getLevelString(){
		return levelString;
	}

}
