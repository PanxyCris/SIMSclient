package dataservice.classificationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.ClassificationPO;


public interface ClassificationDataService extends Remote {
	
	public String getID(String fatherID) throws RemoteException;
}
