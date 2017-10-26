package SIMSclient.src.dataservice.commoditydataservice;

import SIMSclient.src.po.ClassificationPO;

public interface ClassificationDataService {

	public void insert(ClassificationPO po);
	public void delete(ClassificationPO po);
	public void update(ClassificationPO po);
	public void find(ClassificationPO po);
}
