package SIMSclient.src.presentation.userui;

import java.net.URL;

import java.util.ArrayList;
import java.util.ResourceBundle;
import SIMSclient.src.dataenum.UserRole;
import SIMSclient.src.presentation.remindui.RemindExistUI;
import SIMSclient.src.presentation.remindui.RemindNotPrintUI;
import SIMSclient.src.presentation.remindui.RemindPrintUI;
import SIMSclient.src.vo.UserVO;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class UserUpdateUI extends UserManagingUI{

	UserVO updatingUser;
	@FXML
	public void confirm(){

		if(updatingUser==null){
			Platform.runLater(new Runnable() {
	    	    public void run() {
	    	        try {
						new RemindNotPrintUI().start(new Stage());
					} catch (Exception e) {
						e.printStackTrace();
					}
	    	    }
	    	});
		}
		else{

        UserVO user = new UserVO(idLabel.getText(), nameField.getText(), passwordField.getText(),UserRole.getRole(roleChoice.getValue()));

        if(!service.judgeLegal(user)){
        	Platform.runLater(new Runnable() {
	    	    public void run() {
	    	        try {
						new RemindPrintUI().start(new Stage());
					} catch (Exception e) {
						e.printStackTrace();
					}
	    	    }
	    	});
        }else if(service.judgeExist(idLabel.getText())){
        	Platform.runLater(new Runnable() {
	    	    public void run() {
	    	        try {
	    	        	new RemindExistUI().start(remind,true);
					} catch (Exception e) {
						e.printStackTrace();
					}
	    	    }
	    	});
        }else{
           service.update(user);
           table.refresh();
        }
	  }
	}

	@FXML
	public void cancel(){

	}

	@FXML
	public void blurFind(){
	       ArrayList<UserVO> list = service.blurFind(findingField.getText(),findChoice.getValue());
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
	    	  updatingUser = user;
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
