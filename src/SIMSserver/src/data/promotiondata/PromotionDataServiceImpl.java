package SIMSserver.src.data.promotiondata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import SIMSserver.src.dataenum.PromotionType;
import SIMSserver.src.dataenum.ResultMessage;
import SIMSserver.src.dataservice.promotiondataservice.PromotionDataService;
import SIMSserver.src.po.PromotionPO;

public class PromotionDataServiceImpl extends UnicastRemoteObject implements PromotionDataService{

	private PromotionData promotion;
	
	protected PromotionDataServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public ResultMessage insert(PromotionPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage delete(String ID) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage update(PromotionPO po) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<PromotionPO> show() throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage createTable() throws RemoteException {
		return null;
	}

	@Override
	public void init() throws RemoteException {
	}

	@Override
	public String getID() throws RemoteException {
		return null;
	}

	@Override
	public PromotionPO find(String ID) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<PromotionPO> show(PromotionType type) throws RemoteException {
		return null;
	}

}
