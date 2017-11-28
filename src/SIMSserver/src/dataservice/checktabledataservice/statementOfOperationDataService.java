package SIMSserver.src.dataservice.checktabledataservice;

import SIMSclient.src.po.table.StatementOfOperationPO;

public interface statementOfOperationDataService {
	public void viewRport(StatementOfOperationPO statementOfOperationPO);

	public void exportReport();
}
