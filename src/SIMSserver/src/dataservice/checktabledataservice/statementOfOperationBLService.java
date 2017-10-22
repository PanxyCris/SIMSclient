package SIMSserver.src.dataservice.checktabledataservice;

import SIMSclient.src.po.table.StatementOfOperationPO;

public interface statementOfOperationBLService {
	public void viewRport(StatementOfOperationPO statementOfOperationPO);

	public void exportReport();
}
