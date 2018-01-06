package presentation.generalmanagerui.controller;

import java.rmi.RemoteException;
import dataenum.Remind;
import dataenum.TableType;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import vo.uservo.UserVO;

public class FinanceTableController extends GeneralManagerController{

	@FXML
	ChoiceBox<String> tableChoice;

	@FXML
	public void chooseTable() throws Exception{
		if(tableChoice.getValue()==null){
			Alert warning = new Alert(Alert.AlertType.WARNING,"��ѡ����Ҫ�鿴�ı��");
			warning.showAndWait();
		}
		else{
		TableType type = TableType.getType(tableChoice.getValue());
		switch(type){
		case BUSINESS_HISTORY_SCHEDULE:changeStage("BussinessProcessTableUI",user,null);break;
		case SALE_SCHEDULE:changeStage("BussinessSituationTableUI",user,null);break;
	    default:changeStage("SaleDetailTableUI",user,null);
		}
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
