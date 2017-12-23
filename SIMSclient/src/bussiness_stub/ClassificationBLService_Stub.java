package bussiness_stub;

import java.util.ArrayList;

import bussinesslogicservice.commodityblservice.ClassificationBLService;
import dataenum.ResultMessage;
import vo.commodityvo.ClassificationVO;

public class ClassificationBLService_Stub implements ClassificationBLService{

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "00001556";
	}

	@Override
	public ResultMessage insert(ClassificationVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public void delete(ClassificationVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultMessage update(ClassificationVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<ClassificationVO> show() {
	
		return null;
	}

	@Override
	public ArrayList<String> getAllChildrenClass() {
		ArrayList<String> children = new ArrayList<>();
		String c1 = "°×µÆ";
		String c2 = "ºÚµÆ";
		children.add(c1);
		children.add(c2);
		return children;
	}

	@Override
	public ClassificationVO getClass(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClassificationVO getRoot() {
		// TODO Auto-generated method stub
		ClassificationVO root = new ClassificationVO("0001","µÆ",null);
		ArrayList<ClassificationVO> children = new ArrayList<>();
		ArrayList<ClassificationVO> children1 = new ArrayList<>();
		ClassificationVO c1 = new ClassificationVO("0002","°×³ãµÆ",root);
		ClassificationVO c2 = new ClassificationVO("0003","ÕÕÃ÷µÆ",root);
		ClassificationVO c3 = new ClassificationVO("0004","ºÚµÆ",root);
		ClassificationVO c11 = new ClassificationVO("0005","°×°×³ãµÆ",c1);
		ClassificationVO c12 = new ClassificationVO("0006","ºÚ°×³ãµÆ",c1);
		children1.add(c11);
		children1.add(c12);
		c1.setChildren(children1);
		children.add(c1);
		children.add(c2);
		children.add(c3);
		
		root.setChildren(children);
		return root;
	}

}
