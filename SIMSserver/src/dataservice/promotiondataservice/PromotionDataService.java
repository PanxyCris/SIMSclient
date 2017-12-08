package SIMSserver.src.dataservice.promotiondataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import SIMSserver.src.dataenum.PromotionType;
import SIMSserver.src.dataservice.CommonDataService;
import SIMSserver.src.po.PromotionPO;

public interface PromotionDataService extends CommonDataService<PromotionPO>{

	public static final String NAME = "PromotionData";

	public ArrayList<PromotionPO> show(PromotionType type) throws RemoteException;

	
}
