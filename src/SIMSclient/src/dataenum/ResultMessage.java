package SIMSclient.src.dataenum;

public enum ResultMessage {
	SUCCESS("�ɹ�"), FAIL("ʧ��"), REMOTEEXCEPTION("Զ�̵����쳣");

	public final String value;

	ResultMessage(String value) {
		this.value = value;
	}
}
