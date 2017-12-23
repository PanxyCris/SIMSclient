package presentation.financialstaffui.controller;

import java.rmi.RemoteException;
import dataenum.Remind;
import dataenum.TableType;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import vo.uservo.UserVO;

public class ViewTableController extends FinancialStaffController{

	public static final Remind remind = Remind.TABLE;
	@FXML
	ChoiceBox<String> tableChoice;

	@FXML
	public void chooseTable() throws Exception{
		TableType type = TableType.getType(tableChoice.getValue());
		switch(type){
		case BUSINESS_HISTORY_SCHEDULE:
		case SALE_SCHEDULE:
	    default:
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
