package SIMSclient.src.presentation.accountui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import SIMSclient.src.presentation.remindui.RemindPrintUI;
import SIMSclient.src.vo.AccountVO;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class AccountFindUI extends AccountManageUI{

	@FXML
	public void nameFind(){
	       ArrayList<AccountVO> accountList = service.find(findingField.getText());
	       if(list==null){
	    	   Platform.runLater(new Runnable() {
		    	    public void run() {
		    	        try {
		    	        	new RemindPrintUI().start(new Stage());
						} catch (Exception e) {
							e.printStackTrace();
						}
		    	    }
		    	});
	       }
	       else{
	    	   ObservableList<AccountVO> newList = FXCollections.observableArrayList();
	    	   newList.addAll(accountList);
	    	   table.setItems(newList);
	       }

	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		findingField.setText(null);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		changeStage("UserFindUI","UserFindUI.fxml");
	}


}
