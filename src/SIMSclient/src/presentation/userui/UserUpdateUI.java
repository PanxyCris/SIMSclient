package SIMSclient.src.presentation.userui;

import java.net.URL;
import java.util.ResourceBundle;

import SIMSclient.src.bussinesslogic.userbl.UserBL;
import SIMSclient.src.bussinesslogicservice.userblservice.UserBLService;
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
           list.remove(updatingUser);
           list.add(user);
           table.setItems(list);
           updateInit();
        }
	  }
	}

	@FXML
	public void cancel(){
		updateInit();
	}

	@FXML
	public void blurFind(){
		UserBLService service = UserBL.getInstance().getUserService();
	       UserVO user = service.blurFind(findingField.getText());
	       if(user==null){
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

	    	  idLabel.setText(user.getID());
	    	  nameField.setText(user.getName());
	    	  passwordField.setText(user.getPassword());
	    	  roleChoice.setValue(user.getRoleName());
	    	  updatingUser = user;
	       }
	}


	public void updateInit(){

		idLabel.setText(null);
		nameField.setText(null);
		passwordField.setText(null);
		roleChoice.setValue(null);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		manageInit();
		updateInit();
        roleChoice.setItems(FXCollections.observableArrayList(UserRole.GENERAL_MANAGER.value,
                                                              UserRole.FINANCIAL_MANAGER.value,
                                                              UserRole.INVENTORY_MANAGER.value,
                                                              UserRole.PUR_SALE_MANAGER.value,
                                                              UserRole.USER_MANAGER.value));
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		changeStage("UserUpdateUI","UserUpdateUI.fxml");
	}

}
