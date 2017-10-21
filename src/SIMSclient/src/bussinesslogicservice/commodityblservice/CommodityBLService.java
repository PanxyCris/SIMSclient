package SIMSclient.src.bussinesslogicservice.commodityblservice;

import SIMSclient.src.vo.commodity.CommodityVO;

public interface CommodityBLService {
	public void setID(int id);
	public int getID();

	public void setName(String name);
	public String getName();

    public void setModel(String model);
	public String getModel();

	public void setClassification(String classification);
	public String getClassification();

	public void setNumber(int number);
	public int getNumber();

    public void setPurPrice(double purPrice);
	public double getPurPrice();

	public void setRetailedPrice(double retailedPrice);
	public double getRetailedPrice();

	public void setRecentPurPrice(double recentPurPrice);
	public double getRecentPurPrice();

	public void setRecentRetailedPrice(double recentRetailedPrice);
	public double getRecentRetailedPrice();

	public void setWarmingValue(int warmingValue);
	public int getWarmingValue();

	public void insert(CommodityVO vo);
	public void delelte(CommodityVO vo);
	public void update(CommodityVO vo);
	public void find(CommodityVO vo);
	public void check();   //ø‚¥Ê≤Èø¥
	public void stock();   //ø‚¥Ê≈Ãµ„

}
