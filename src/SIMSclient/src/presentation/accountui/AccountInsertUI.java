package SIMSclient.src.presentation.accountui;

import java.net.URL;
import java.util.ResourceBundle;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.presentation.remindui.RemindExistUI;
import SIMSclient.src.presentation.remindui.RemindPrintUI;
import SIMSclient.src.vo.AccountVO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class AccountInsertUI extends AccountManageUI{

	@FXML
	public void confirm(){
        String name = nameField.getText();
        int money = Integer.parseInt(moneyField.getText());
        AccountVO account = new AccountVO(name,money);
        ResultMessage message = service.newBuild(name,money);
        if(message==ResultMessage.ILLEGALINPUTNAME||message == ResultMessage.ILLEAGLINPUTDATA){
        	Platform.runLater(new Runnable() {
	    	    public void run() {
	    	        try {
						new RemindPrintUI().start(new Stage());
					} catch (Exception e) {
						e.printStackTrace();
					}
	    	    }
	    	});
        }else if(message==ResultMessage.EXISTED){
        	Platform.runLater(new Runnable() {
	    	    public void run() {
	    	        try {
	    	        	new RemindExistUI().start(remind,true);
					} catch (Exception e) {
						e.printStackTrace();
					}
	    	    }
	    	});
        }else if(message == ResultMessage.SUCCESS){
        list.add(account);
        table.setItems(list);
        insertInit();
        }
	}

	@FXML
	public void cancel(){
		insertInit();
	}


	public void insertInit(){

		nameField.setText(null);
		moneyField.setText(null);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		manageInit();
		insertInit();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		changeStage("AccountInsertUI","AccountInsertUI.fxml");
	}


}
