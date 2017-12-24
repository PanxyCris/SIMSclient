package bussinesslogic.classificationbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogicservice.commodityblservice.ClassificationBLService;
import dataenum.ResultMessage;
import dataservice.classificationdataservice.ClassificationDataService;
import po.ClassificationVPO;

public class ClassificationBL implements ClassificationBLService {

	ClassificationDataService classificationDataService;
	
	@Override
	public String getID() {//用于生成新创建的商品分类的id
		ClassificationVPO root=getRoot();
		int count=0;
		return null;
	}

	@Override
	public ArrayList<String> showName() {
		return null;
	}
	
	@Override
	public ResultMessage insert(ClassificationVPO vpo) {
		try {
			return classificationDataService.insertClassification(vpo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public void delete(ClassificationVPO vpo) {
		String id=vpo.getId();
		try {
			classificationDataService.deleteClassification(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultMessage update(ClassificationVPO vpo) {
		try {
			return classificationDataService.updateClassification(vpo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	@Override
	public ClassificationVPO getClass(String name) {
		try {
			return classificationDataService.findClassification(name);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ClassificationVPO getRoot() {
		try {
			return classificationDataService.getRoot();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}



}
