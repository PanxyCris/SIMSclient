package SIMSclient.src.bussinesslogicservice.commodityblservice;

import SIMSclient.src.vo.commodity.ClassificationVO;

public interface ClassificationBLService {

	public void insert(ClassificationVO vo);
	public void delete(ClassificationVO vo);
	public void update(ClassificationVO vo);
	public void find(ClassificationVO vo);
}
