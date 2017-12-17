package bussinesslogicservice.commodityblservice;

import dataenum.ResultMessage;

import vo.commodityvo.ClassificationVO;

public interface ClassificationBLService {

	public String getID();

	public ResultMessage insert(ClassificationVO vo);

	public void delete(ClassificationVO vo);

	public ResultMessage update(ClassificationVO vo);

}
