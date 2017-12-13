package po;

import java.io.Serializable;
import java.util.ArrayList;

import dataenum.MemberLevel;
import dataenum.PromotionType;
import po.commodity.CommodityItemPO;

/**
 * 
* @ClassName: PromotionPO 
* @author lijie 
* @date 2017��12��13�� ����5:31:20 
*
 */
public class PromotionPO implements Serializable{

	private static final long serialVersionUID = -1444427916106388960L;
	private String id;
	private String beginDate;
	private String endDate;
	private MemberLevel level;
	private ArrayList<CommodityItemPO> gifts;
	private ArrayList<CommodityItemPO> commodities;
	private ArrayList<CommodityItemPO> pricePacks;
	private double pricePacksSum;
	private double beforeSum;
	private double allowance;
	private double voucher;
	private double afterSum;
	private PromotionType type;
	
	/** 
	* @Description: TODO(������һ�仰�����������������) 
	* @param @param id
	* @param @param beginDate
	* @param @param endDate
	* @param @param level
	* @param @param gifts
	* @param @param commodities
	* @param @param pricePacks
	* @param @param pricePacksSum
	* @param @param beforeSum
	* @param @param allowance
	* @param @param voucher
	* @param @param afterSum
	* @param @param type    �趨�ļ� 
	* @return   �������� 
	* @throws 
	*/
	public PromotionPO(String id, String beginDate, String endDate, MemberLevel level, ArrayList<CommodityItemPO> gifts,
			ArrayList<CommodityItemPO> commodities, ArrayList<CommodityItemPO> pricePacks, double pricePacksSum,
			double beforeSum, double allowance, double voucher, double afterSum, PromotionType type) {
		super();
		this.id = id;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.level = level;
		this.gifts = gifts;
		this.commodities = commodities;
		this.pricePacks = pricePacks;
		this.pricePacksSum = pricePacksSum;
		this.beforeSum = beforeSum;
		this.allowance = allowance;
		this.voucher = voucher;
		this.afterSum = afterSum;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public MemberLevel getLevel() {
		return level;
	}

	public ArrayList<CommodityItemPO> getGifts() {
		return gifts;
	}

	public ArrayList<CommodityItemPO> getCommodities() {
		return commodities;
	}

	public ArrayList<CommodityItemPO> getPricePacks() {
		return pricePacks;
	}

	public double getPricePacksSum() {
		return pricePacksSum;
	}

	public double getBeforeSum() {
		return beforeSum;
	}

	public double getAllowance() {
		return allowance;
	}

	public double getVoucher() {
		return voucher;
	}

	public double getAfterSum() {
		return afterSum;
	}

	public PromotionType getType() {
		return type;
	}
	
	
}
