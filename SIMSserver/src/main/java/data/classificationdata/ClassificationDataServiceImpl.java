package data.classificationdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataenum.ResultMessage;
import dataservice.classificationdataservice.ClassificationDataService;
import po.ClassificationVPO;

/**
 *
 * @author Lijie
 * @date 2017Äê12ÔÂ14ÈÕ
 */
public class ClassificationDataServiceImpl implements ClassificationDataService {

	private ClassificationData classfication;

	public ClassificationDataServiceImpl() {
		classfication = new ClassificationData();
	}

	@Override
	public ResultMessage insertClassification(ClassificationVPO po) throws RemoteException {
		return classfication.insert(po);
	}

	@Override
	public ResultMessage updateClassification(ClassificationVPO po) throws RemoteException {
		return classfication.update(po);
	}

	@Override
	public ResultMessage deleteClassification(String id) throws RemoteException {
		return classfication.delete(id);
	}

	@Override
	public ClassificationVPO getRoot() throws RemoteException {
		return classfication.getRoot();
	}

	@Override
	public ClassificationVPO findClassification(String keyword) throws RemoteException {
		return classfication.find(keyword).get(0);
	}

	@Override
	public String getId() throws RemoteException {
		if (classfication.show() != null) {
			for (int i = 1; i < classfication.show().size(); i++) {
				ClassificationVPO last = classfication.show().get(classfication.show().size() - i);
				if (last.getB()) {
					String oldId = last.getId();
					int count = Integer.parseInt(oldId);
					count++;
					String newId = String.valueOf(count);
					while (newId.length() < oldId.length())
						newId = "0" + newId;
					return newId;
				}
			}
		} else
			return "0001";
		return null;
	}

	@Override
	public ArrayList<ClassificationVPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return classfication.show();
	}

}
