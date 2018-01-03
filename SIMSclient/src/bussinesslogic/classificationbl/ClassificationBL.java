package bussinesslogic.classificationbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bussinesslogicservice.commodityblservice.ClassificationBLService;
import dataenum.ResultMessage;
import dataservice.classificationdataservice.ClassificationDataService;
import po.ClassificationVPO;
import rmi.RemoteHelper;

public class ClassificationBL implements ClassificationBLService {

	private ClassificationDataService classificationDataService;

	public ClassificationBL() {
		classificationDataService=RemoteHelper.getInstance().getClassificationDataService();
	}

	@Override
	public String getID() {//���������´�������Ʒ�����id
		try {
			return classificationDataService.getId();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<String> showName() {
		nameList=new ArrayList<>();
		ClassificationVPO root=getRoot();
		addName(root);
		return nameList;
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

	static int idCount=0;

	public int count(ClassificationVPO classificationVPO){
		if(classificationVPO.getChildren()==null){
			return 0;
		}
		ArrayList<ClassificationVPO> childrenVPOs=classificationVPO.getChildren();
		for (int i = 0; i < childrenVPOs.size(); i++) {
			count(childrenVPOs.get(i));
			idCount++;
		}
		return idCount;
	}

	static ArrayList<String> nameList=null;

	public void addName(ClassificationVPO classificationVPO){
		ArrayList<ClassificationVPO> childrenVPOs=classificationVPO.getChildren();
		nameList.add(classificationVPO.getName());
		if(childrenVPOs!=null||classificationVPO.getB()==false){
		for (int i = 0; i < childrenVPOs.size(); i++) {
			addName(childrenVPOs.get(i));
			}
		}
	}

}
