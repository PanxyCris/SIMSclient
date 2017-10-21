package SIMSclient.src.dataservice.promotiondataservice;

public interface PromotionDataService {
	public double getbeforePrice(); // 折让前价格
	public double getallowance(); // 折让金额
	public double getvoucher(); // 代金券金额
	public double getafterPrice(); // 折让后金额
}
