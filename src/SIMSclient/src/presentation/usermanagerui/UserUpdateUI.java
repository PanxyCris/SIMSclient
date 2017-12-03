package SIMSclient.src.presentation.userui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.dataenum.UserRole;
import SIMSclient.src.presentation.remindui.RemindPrintUI;
import SIMSclient.src.vo.UserVO;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class UserUpdateUI extends UserManagingUI{

	@FXML
	public void confirm(){

		UserVO user = new UserVO(idLabel.getText(),nameField.getText(),passwordField.getText(),UserRole.getRole(roleChoice.getValue()));
		ResultMessage message = service.update(user);
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
       idLabel.setText(null);
       nameField.setText(null);
       roleChoice.setValue(null);
       findChoice.setValue(null);
	}

	@FXML
	public void blurFind(){
	       ArrayList<UserVO> list = service.find(findingField.getText(), findChoice.getValue());
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
              UserVO user = list.get(0);
	    	  idLabel.setText(user.getID());
	    	  nameField.setText(user.getName());
	    	  passwordField.setText(user.getPassword());
	    	  roleChoice.setValue(user.getRoleName());
	       }
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		manageInit();
        roleChoice.setItems(roleList);
        findChoice.setItems(FXCollections.observableArrayList("ID","ÓÃ»§Ãû"));
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		changeStage("UserUpdateUI","UserUpdateUI.fxml");
	}

}
