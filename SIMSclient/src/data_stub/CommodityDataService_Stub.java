package data_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataenum.findtype.FindCommodityType;
import dataservice.commoditydataservice.CommodityDataService;
import po.commodity.CommodityPO;

public class CommodityDataService_Stub implements CommodityDataService{

	@Override
	public ResultMessage insertCommodity(CommodityPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updateCommodity(CommodityPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage deleteCommodity(String id) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<CommodityPO> showCommodity() throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<CommodityPO> findCommodity(String keywords, FindCommodityType type) throws RemoteException {
		return null;
	}

}
