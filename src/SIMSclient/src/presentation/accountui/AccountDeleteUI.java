package SIMSclient.src.presentation.accountui;

import java.net.URL;
import java.util.ResourceBundle;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.presentation.remindui.RemindExistUI;
import SIMSclient.src.presentation.remindui.RemindPrintUI;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class AccountDeleteUI extends AccountManageUI{

	@FXML
	public void confirm(){
		ResultMessage message = service.delete(nameField.getText());
	    if(message == ResultMessage.ILLEGALINPUTNAME){
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
	    else if(message == ResultMessage.NOTFOUND){
			  Platform.runLater(new Runnable() {
		    	    public void run() {
		    	        try {
							new RemindExistUI().start(remind,false);
						} catch (Exception e) {
							e.printStackTrace();
						}
		    	    }
		    	});
		  }
		  else{
			table.refresh();
	          cancel();
		  }
	}

	@FXML
	public void cancel(){
		findingField.setText(null);
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		manageInit();
		cancel();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		changeStage("AccountDeleteUI","AccountDeleteUI.fxml");
	}


}
