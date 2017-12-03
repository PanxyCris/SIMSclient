package SIMSclient.src.presentation.accountui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.presentation.remindui.RemindExistUI;
import SIMSclient.src.presentation.remindui.RemindPrintUI;
import SIMSclient.src.vo.AccountVO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class AccountUpdateUI extends AccountManageUI{

	@FXML
	public void confirm(){
        String name = nameField.getText();
        int money = Integer.parseInt(moneyField.getText());

        ResultMessage message = service.modify(name,money);
        Platform.runLater(new Runnable() {
    	    public void run() {
    	        try {
    	        	switch(message){
    	        	case ILLEGALINPUTNAME:new RemindPrintUI().start(new Stage());break;
    	        	case ILLEAGLINPUTDATA:new RemindPrintUI().start(new Stage());break;
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
           nameField.setText(null);
           moneyField.setText(null);
	}

	@FXML
	public void nameFind(){
		ArrayList<AccountVO> accountList = service.find(nameField.getText());
	    if (list==null){
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
	    	  nameField.setText(accountList.get(0).getName());
	    	  moneyField.setText(String.valueOf(accountList.get(0).getMoney()));
	       }
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cancel();
		manageInit();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		changeStage("AccountUpdateUI","AccountUpdateUI.fxml");
	}


}
