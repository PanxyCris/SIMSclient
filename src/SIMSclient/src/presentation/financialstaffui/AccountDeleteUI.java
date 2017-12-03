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
		Platform.runLater(new Runnable() {
    	    public void run() {
    	        try {
    	        switch(message){
    	        case ILLEGALINPUTNAME:new RemindPrintUI().start(new Stage());break;
    	        case ILLEAGLINPUTDATA:new RemindPrintUI().start(new Stage());break;
    	        case NOTFOUND:new RemindExistUI().start(remind,false);break;
    	        case SUCCESS:table.refresh();cancel();break;
    	        default:break;
    	        }
				} catch (Exception e) {
					e.printStackTrace();
				}
    	    }
    	});
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
