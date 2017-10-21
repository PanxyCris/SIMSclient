package SIMSserver.src.dataservice.commoditydataservice;

import java.rmi.RemoteException;

import SIMSclient.src.po.CommodityPO;

public interface CommodityDataService {
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

	public void insert(CommodityPO po) throws RemoteException;
	public void delelte(CommodityPO po) throws RemoteException;
	public void update(CommodityPO po) throws RemoteException;
	public void find(CommodityPO po) throws RemoteException;
	public void init() throws RemoteException;
	public void finish() throws RemoteException;
}
