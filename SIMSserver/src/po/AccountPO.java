package po;

public class AccountPO extends PersistObject {
	private static final long serialVersionUID = 1L;
	private String name;
	private double money;

	/**
	 * @Description: TODO(������һ�仰�����������������) @param @param id @param @param
	 * name @param @param money �趨�ļ� @return �������� @throws
	 */
	public AccountPO(String id, String name, double money) {
		super(id);
		this.name = name;
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	/**
	 * ����ģ������
	 */
	@Override
	public String toString() {
		return id + "," + name + "," + money;
	}

}