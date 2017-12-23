package bussinesslogic.classificationbl;

import java.util.ArrayList;

import bussinesslogicservice.commodityblservice.ClassificationBLService;
import dataenum.ResultMessage;
import dataservice.classificationdataservice.ClassificationDataService;
import vo.commodityvo.ClassificationVO;

public class ClassificationBL implements ClassificationBLService {

	ClassificationDataService classificationDataService;
	
	@Override
	public String getID() {//用于生成新创建的商品分类的id
		return null;
	}

	@Override
	public ResultMessage insert(ClassificationVO vo) {
		
		return null;
	}

	@Override
	public void delete(ClassificationVO vo) {
		
	}

	@Override
	public ResultMessage update(ClassificationVO vo) {
		return null;
	}

	@Override
	public ArrayList<ClassificationVO> show() {
		return null;
	}

	@Override
	public ArrayList<String> getAllChildrenClass() {
		return null;
	}

	@Override
	public ClassificationVO getClass(String name) {
		return null;
	}

	@Override
	public ClassificationVO getRoot() {
		return null;
	}



}
