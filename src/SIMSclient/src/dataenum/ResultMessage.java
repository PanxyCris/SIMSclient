package SIMSclient.src.dataenum;

public enum ResultMessage {
	SUCCESS("�ɹ�"), FAIL("ʧ��"), REMOTEEXCEPTION("Զ�̵����쳣"),NOTFOUND("δ�ҵ�"),ILLEGALINPUTNAME("�Ƿ�����"),ILLEAGLINPUTDATA("�Ƿ���ֵ");

	public final String value;

	ResultMessage(String value) {
		this.value = value;
	}
}
