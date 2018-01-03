package dataservice.classificationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataenum.ResultMessage;
import po.ClassificationVPO;


public interface ClassificationDataService extends Remote {

	public ResultMessage insertClassification(ClassificationVPO po) throws RemoteException;

	public ResultMessage updateClassification(ClassificationVPO po) throws RemoteException;

	public ResultMessage deleteClassification(String id) throws RemoteException;

	public ClassificationVPO getRoot() throws RemoteException;

	public ClassificationVPO findClassification(String name) throws RemoteException;

	public String getId() throws RemoteException;

}
