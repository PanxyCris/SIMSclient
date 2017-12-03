package SIMSserver.src.dataservice.classificationdataservice;

public interface ClassificationDataService {

	public void insert(ClassificationPO po);
	public void delete(ClassificationPO po);
	public void update(ClassificationPO po);
	public void find(ClassificationPO po);
}
