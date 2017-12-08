package SIMSserver.src.dataservice.checktabledataservice;

import SIMSserver.src.dataservice.CommonDataService;
import SIMSserver.src.po.table.StatementOfOperationPO;

public interface StatementOfOperationDataService extends CommonDataService<StatementOfOperationPO>{
	public static final String NAME = "statementOfOperationData";
	
	public void viewRport(StatementOfOperationPO statementOfOperationPO);

	public void exportReport();
}
