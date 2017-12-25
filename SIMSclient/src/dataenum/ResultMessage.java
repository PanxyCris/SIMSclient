package dataenum;

public enum ResultMessage {
	SUCCESS("成功"), FAIL("失败"), REMOTEEXCEPTION("远程调用异常"),EXISTED("已存在"),
	NOTFOUND("未找到"),ILLEGALINPUTNAME("非法名称"),ILLEAGLINPUTDATA("非法数值"),
	COULDNOTUPDATE("模糊查找不能进行修改操作"),SAVED("已保存"),COMMITED("已提交");

	public final String value;

	ResultMessage(String value) {
		this.value = value;
	}
}
