package dataenum;

public enum BillState {

	DRAFT("�ݸ�״̬"), COMMITED("���ύ״̬"), SUCCESS("�����ɹ�"), FAIL("����ʧ��");

	public final String value;

	BillState(String value) {
		this.value = value;
	}
}
