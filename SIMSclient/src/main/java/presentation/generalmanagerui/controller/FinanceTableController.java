package presentation.generalmanagerui.controller;

import java.rmi.RemoteException;

import dataenum.TableType;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import vo.uservo.UserVO;

/**
 * 查看表格的选择界面
 * 
 * @author 潘星宇 2017-12-15
 */
public class FinanceTableController extends GeneralManagerController {

	@FXML
	protected ChoiceBox<String> tableChoice;

	@FXML
	public void chooseTable() throws Exception {
		if (tableChoice.getValue() == null) {
			Alert warning = new Alert(Alert.AlertType.WARNING, "请选择你要查看的表格");
			warning.showAndWait();
		} else {
			TableType type = TableType.getType(tableChoice.getValue());
			switch (type) {
			case BUSINESS_HISTORY_SCHEDULE:
				changeStage("BussinessProcessTableUI", user, null);
				break;
			case STATEMENT_OF_OPERATION:
				changeStage("BussinessSituationTableUI", user, null);
				break;
			case SALE_SCHEDULE:
				changeStage("SaleDetailTableUI", user, null);
			}
		}
	}

	public void initData(UserVO user) throws Exception {
		this.user = user;
		judgeMessage();
		tableChoiceInit();
	}

	public void tableChoiceInit() throws RemoteException {
		tableChoice.setItems(FXCollections.observableArrayList(TableType.BUSINESS_HISTORY_SCHEDULE.value,
				TableType.SALE_SCHEDULE.value, TableType.STATEMENT_OF_OPERATION.value));
	}

}
