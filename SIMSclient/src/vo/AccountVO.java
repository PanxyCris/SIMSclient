package SIMSclient.src.vo;
import java.io.Serializable;

/**
 *
 * @author ���Ӳ�
 * @version 2017-12-1
 */
public class AccountVO implements Serializable{

	private String id;//���п���
	private String name;//�����˻�����
	private String money;//�˻����

	public AccountVO(String id,String name,String money){
		this.id=id;
		this.name=name;
		this.money=money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}





}