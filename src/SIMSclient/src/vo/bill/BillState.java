package SIMSclient.src.vo.bill;

public enum BillState {
	DRAFT("草稿状态"), COMMITED("已提交状态"), SUCCESS("审批成功");

	public final String value;

	BillState(String value) {
		this.value = value;
	}
}
