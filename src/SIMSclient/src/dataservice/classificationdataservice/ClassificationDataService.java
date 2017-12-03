package SIMSserver.src.dataservice.classificationdataservice;

import java.rmi.RemoteException;

import SIMSserver.src.dataservice.CommonDataService;
import SIMSserver.src.po.ClassificationPO;

public interface ClassificationDataService extends CommonDataService<ClassificationPO> {

	public static final String NAME = "ClassificationData";
	
	public String getID(String fatherID) throws RemoteException;
}
