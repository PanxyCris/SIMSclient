package SIMSclient.src.vo.sale;

import java.util.ArrayList;
import java.util.Date;
import SIMSclient.src.vo.bill.PurchaseAndSalesBillVO;
import SIMSclient.src.vo.bill.WareHouse;
import SIMSclient.src.vo.commodity.CommodityVO;
/**
 *
 * @author
 *
 */
public class SalesVO extends PurchaseAndSalesBillVO{
	public String clientID;
	public String retailer;  //�ͻ�����
	public String saleMan; // ҵ��Ա
	public double beforePrice; // ����ǰ�۸�
	public double allowance; // ���ý��
	public double voucher; // ����ȯ���
	
	
	/**
	 * @param i
	 * @param d
	 * @param s
	 * @param t
	 * @param des
	 * @param warehouse
	 * @param operator
	 * @param amount
	 * @param commodityList
	 * @param clientID
	 * @param retailer
	 * @param saleMan
	 * @param beforePrice
	 * @param allowance
	 * @param voucher
	 */
	public SalesVO(String i, Date d, BillState s, BillType t, String des, WareHouse warehouse, String operator,
			int amount, ArrayList<CommodityVO> commodityList, String clientID, String retailer, String saleMan,
			double beforePrice, double allowance, double voucher) {
		super(i, d, s, t, des, warehouse, operator, amount, commodityList);
		this.clientID = clientID;
		this.retailer = retailer;
		this.saleMan = saleMan;
		this.beforePrice = beforePrice;
		this.allowance = allowance;
		this.voucher = voucher;
	}
	
	
	

	
}