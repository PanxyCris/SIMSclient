package presentation.generalmanagerui.controller;

import java.rmi.RemoteException;
import dataenum.Remind;
import dataenum.TableType;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import vo.uservo.UserVO;

public class FinanceTableController extends GeneralManagerController{

	public static final Remind remind = Remind.TABLE;
	@FXML
	ChoiceBox<String> tableChoice;

	@FXML
	public void chooseTable() throws Exception{
		TableType type = TableType.getType(tableChoice.getValue());
		switch(type){
		case BUSINESS_HISTORY_SCHEDULE:changeStage("BussinessHistoryTableUI",user,null);
		case SALE_SCHEDULE:changeStage("BussinessSituationTableUI",user,null);
	    default:changeStage("SaleDetailTableUI",user,null);
		}
	}

	public void initData(UserVO user) throws Exception {
           this.user = user;
           choiceInit();
	}


	public void choiceInit() throws RemoteException{
		tableChoice.setItems(FXCollections.observableArrayList(TableType.BUSINESS_HISTORY_SCHEDULE.value,
				TableType.SALE_SCHEDULE.value,TableType.STATEMENT_OF_OPERATION.value));
	}

}
