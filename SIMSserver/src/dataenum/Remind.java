package dataenum;

/**
 * 
 * @author Lijie
 * @date 2017��12��2��
 */
public enum Remind {

	USER("�û�"), MEMBER("�ͻ�"), ACCOUNT("�˻�"), TABLE("���"), BILL("����"), COMMODITY("��Ʒ"), CLASSIFICATION("����"), PROMOTION(
			"����");

	public final String value;

	Remind(String value) {
		this.value = value;
	}
}
