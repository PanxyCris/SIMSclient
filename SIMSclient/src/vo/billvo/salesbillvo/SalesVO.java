package vo.billvo.salesbillvo;

import java.util.ArrayList;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.Warehouse;
import vo.billvo.BillVO;
import vo.commodityvo.CommodityItemVO;

public class SalesVO extends BillVO {
	private String retailerID;
	private String retailer; // 客户姓名
	private String saleMan; // 业务员
	private String operator;
	private Warehouse warehouse;
	private ArrayList<CommodityItemVO> commodity;
	private Double beforePrice; // 折让前价格
	private Double allowance; // 折让金额
	private Double voucher; // 代金券金额
	private Double afterPrice;


	public SalesVO(String id, String retailerID, String retailer, String saleMan, String operator, Warehouse warehouse,
			ArrayList<CommodityItemVO> commodity, Double beforePrice, Double allowance, Double voucher,
			Double afterPrice, String note, BillState state, BillType type) {
		super(id,type,state,note);
		this.setRetailerID(retailerID);
		this.setRetailer(retailer);
		this.setSaleMan(saleMan);
		this.setOperator(operator);
		this.setWarehouse(warehouse);
		this.setCommodity(commodity);
		this.setBeforePrice(beforePrice);
		this.setAllowance(allowance);
		this.setVoucher(voucher);
		this.setAfterPrice(afterPrice);
	}


	public String getRetailerID() {
		return retailerID;
	}


	public void setRetailerID(String retailerID) {
		this.retailerID = retailerID;
	}


	public String getRetailer() {
		return retailer;
	}


	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}


	public String getSaleMan() {
		return saleMan;
	}


	public void setSaleMan(String saleMan) {
		this.saleMan = saleMan;
	}


	public String getOperator() {
		return operator;
	}


	public void setOperator(String operator) {
		this.operator = operator;
	}


	public Warehouse getWarehouse() {
		return warehouse;
	}


	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}


	public ArrayList<CommodityItemVO> getCommodity() {
		return commodity;
	}


	public void setCommodity(ArrayList<CommodityItemVO> commodity) {
		this.commodity = commodity;
	}


	public Double getBeforePrice() {
		return beforePrice;
	}


	public void setBeforePrice(Double beforePrice) {
		this.beforePrice = beforePrice;
	}


	public Double getAllowance() {
		return allowance;
	}


	public void setAllowance(Double allowance) {
		this.allowance = allowance;
	}


	public Double getVoucher() {
		return voucher;
	}


	public void setVoucher(Double voucher) {
		this.voucher = voucher;
	}


	public Double getAfterPrice() {
		return afterPrice;
	}


	public void setAfterPrice(Double afterPrice) {
		this.afterPrice = afterPrice;
	}

}