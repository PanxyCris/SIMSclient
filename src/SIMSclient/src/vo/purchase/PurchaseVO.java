package SIMSclient.src.vo.purchase;

import java.util.ArrayList;

import SIMSclient.src.enumeration.BillState;
import SIMSclient.src.enumeration.BillType;
import SIMSclient.src.vo.ObjectVO;
import SIMSclient.src.vo.commodity.CommodityItemVO;

/**  
* 类说明   
*  
* @author ****  
* @date 2017年10月22日    
*/
public class PurchaseVO extends ObjectVO{

	public String clientID;
	public String clientName;
	public String user;
	public ArrayList<CommodityItemVO> commodities;
	public double beforePrice;
	public String remark;
	public BillType type;
	public BillState state;


	

	/**
	 * @param clientID
	 * @param clientName
	 * @param user
	 * @param commodities
	 * @param beforePrice
	 * @param remark
	 * @param type
	 * @param state
	 */
	public PurchaseVO(String id, String date, String clientID, String clientName, String user, ArrayList<CommodityItemVO> commodities,
			double beforePrice, String remark, BillType type, BillState state) {
		super(id, date);
		this.clientID = clientID;
		this.clientName = clientName;
		this.user = user;
		this.commodities = commodities;
		this.beforePrice = beforePrice;
		this.remark = remark;
		this.type = type;
		this.state = state;
	}




	@Override
	public String toString() {
		return "[单据ID=" + ID + ", 客户ID=" + clientID + ", 客户姓名=" + clientName  + ", 操作员=" + user
				+ ", 商品列表=" + commodities + ",\r\n商品总价=" + beforePrice + ", 备注=" + remark + ", 单据类型=" + type.value
				+ ", 单据状态=" + state.value + "]";
	}


}
