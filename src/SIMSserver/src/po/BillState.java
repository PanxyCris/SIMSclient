package SIMSserver.src.po;

public enum BillState {
	DRAFT("�ݸ�״̬"), COMMITED("���ύ״̬"), SUCCESS("�����ɹ�");

	public final String value;

	BillState(String value) {
		this.value = value;
	}
}
