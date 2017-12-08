package SIMSclient.src.vo.member;

import SIMSclient.src.dataenum.MemberCategory;
import SIMSclient.src.dataenum.MemberLevel;

public class MemberVO {
	public String ID;
	public MemberCategory category; // �ͻ����ࣺ�����̺�������
	public MemberLevel level; // �ͻ������弶��һ����ͨ�û����弶VIP�ͻ�
	public String name; // �ͻ�����
	public String cellNumber; // �绰����
	public String address;
	public String post; // �ʱ�
	public String email;
	public double receivableLimit; // Ӧ�ն��
	public double receivable; // Ӧ��
	public double payable; // Ӧ��
	public String saleMan; // Ĭ��ҵ��Ա

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
			String address, String post, String email, double receivableLimit, double receivable, double payable,
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
	}

}
