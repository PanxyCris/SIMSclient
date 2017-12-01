package SIMSclient.src.presentation.accountui;

import java.net.URL;

import java.util.ResourceBundle;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.presentation.remindui.RemindExistUI;
import SIMSclient.src.presentation.remindui.RemindPrintUI;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class AccountInsertUI extends AccountManageUI{

	@FXML
	public void confirm(){
        String name = nameField.getText();
        int money = Integer.parseInt(moneyField.getText());
        ResultMessage message = service.newBuild(name,money);
        Platform.runLater(new Runnable() {
    	    public void run() {
    	        try {
    	        switch(message){
    	        case ILLEGALINPUTNAME:new RemindPrintUI().start(new Stage());break;
    	        case ILLEAGLINPUTDATA:new RemindPrintUI().start(new Stage());break;
    	        case EXISTED:new RemindExistUI().start(remind,true);break;
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
		nameField.setText(null);
		moneyField.setText(null);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		manageInit();
		cancel();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		changeStage("AccountInsertUI","AccountInsertUI.fxml");
	}


}
