package dataenum;

public enum ResultMessage {

	SUCCESS("�ɹ�"), FAIL("ʧ��"), REMOTEEXCEPTION("Զ�̵����쳣"), EXISTED("�Ѵ���"), NOTFOUND("δ�ҵ�"), ILLEGALINPUTNAME(
			"�Ƿ�����"), ILLEAGLINPUTDATA("�Ƿ���ֵ");

	public final String value;

	ResultMessage(String value) {
		this.value = value;
	}
}
