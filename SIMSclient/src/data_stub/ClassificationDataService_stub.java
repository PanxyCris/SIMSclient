package data_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataservice.classificationdataservice.ClassificationDataService;
import po.ClassificationVPO;

/**     
*  
* @author Lijie 
* @date 2018Äê1ÔÂ10ÈÕ    
*/
public class ClassificationDataService_stub implements ClassificationDataService {

	@Override
	public ResultMessage insertClassification(ClassificationVPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updateClassification(ClassificationVPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage deleteClassification(String id) throws RemoteException {
		return null;
	}

	@Override
	public ClassificationVPO getRoot() throws RemoteException {
		return null;
	}

	@Override
	public ClassificationVPO findClassification(String name) throws RemoteException {
		return null;
	}

	@Override
	public String getId() throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<ClassificationVPO> show() throws RemoteException {
		return null;
	}

}
