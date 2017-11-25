package SIMSclient.src.dataenum;

public enum ResultMessage {
	SUCCESS("成功"), FAIL("失败"), REMOTEEXCEPTION("远程调用异常");

	public final String value;

	ResultMessage(String value) {
		this.value = value;
	}
}
