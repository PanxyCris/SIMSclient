package SIMSclient.src.po;

import java.util.ArrayList;

import SIMSclient.src.vo.ObjectVO;
import SIMSclient.src.vo.commodity.CommodityItemVO;
import SIMSserver.src.po.BillState;
import SIMSserver.src.po.BillType;

/**  
* 类说明   
*  
* @author ****  
* @date 2017年10月22日    
*/
public class PurchasePO {

	public String ID;
	public String clientID;
	public String clientName;
	public String user;
	public ArrayList<CommodityItemVO> commodities;
	public double beforePrice;
	public String remark;
	public BillType type;
	public BillState state;


	/**
	 * @param iD
	 * @param clientID
	 * @param clientName
	 * @param user
	 * @param commodities
	 * @param beforePrice
	 * @param remark
	 * @param type
	 * @param state
	 */
	public PurchasePO(String iD, String clientID, String clientName, String user,
			ArrayList<CommodityItemVO> commodities, double beforePrice, String remark, BillType type, BillState state) {
		super();
		ID = iD;
		this.clientID = clientID;
		this.clientName = clientName;
		this.user = user;
		this.commodities = commodities;
		this.beforePrice = beforePrice;
		this.remark = remark;
		this.type = type;
		this.state = state;
	}


	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}


	public String getClientID() {
		return clientID;
	}


	public void setClientID(String clientID) {
		this.clientID = clientID;
	}


	public String getClientName() {
		return clientName;
	}


	public void setClientName(String clientName) {
		this.clientName = clientName;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public ArrayList<CommodityItemVO> getCommodities() {
		return commodities;
	}


	public void setCommodities(ArrayList<CommodityItemVO> commodities) {
		this.commodities = commodities;
	}


	public double getBeforePrice() {
		return beforePrice;
	}


	public void setBeforePrice(double beforePrice) {
		this.beforePrice = beforePrice;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public BillType getType() {
		return type;
	}


	public void setType(BillType type) {
		this.type = type;
	}


	public BillState getState() {
		return state;
	}


	public void setState(BillState state) {
		this.state = state;
	}

	
	
}
