package vo.sale;
/**
* ��˵��
*
* @author ****
* @date 2017��10��21��
*/

import dataenum.Warehouse;

public class SalesInputVO {

	public Warehouse warehouse;
	public double allowance;
	public double voucher;
	public String remark;
	/** 
	* @Description: TODO(������һ�仰�����������������) 
	* @param @param warehouse
	* @param @param allowance
	* @param @param voucher
	* @param @param remark    �趨�ļ� 
	* @return   �������� 
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
