package vo.accountvo;

/**
 *
 * @author ���Ӳ�
 * @version 2017-12-1
 */
public class AccountVO {

	private String id;// ���п���
	private String name;// �����˻�����
	private Double money;// �˻����

	public AccountVO(String id, String name, Double money) {
		this.id = id;
		this.name = name;
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}