package SIMSserver.src.po.table;

import SIMSserver.src.dataenum.TableType;

public class TableTypePO {

	TableType tableType;

	public TableTypePO(TableType t) {
		tableType = t;
	}

	public TableType getTableType() {
		return tableType;
	}

	public void setTableType(TableType tableType) {
		this.tableType = tableType;
	}

}
