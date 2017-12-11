package vo.sale;
/**
* 类说明
*
* @author ****
* @date 2017年10月21日
*/

import dataenum.Warehouse;

public class SalesInputVO {

	public Warehouse warehouse;
	public double allowance;
	public double voucher;
	public String remark;
	/** 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param warehouse
	* @param @param allowance
	* @param @param voucher
	* @param @param remark    设定文件 
	* @return   返回类型 
	* @throws 
	*/
	public SalesInputVO(Warehouse warehouse, double allowance, double voucher, String remark) {
		super();
		this.warehouse = warehouse;
		this.allowance = allowance;
		this.voucher = voucher;
		this.remark = remark;
	}
	
	
}
