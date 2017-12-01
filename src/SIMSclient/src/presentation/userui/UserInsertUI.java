package SIMSclient.src.presentation.userui;

import java.net.URL;
import java.util.ResourceBundle;

import SIMSclient.src.dataenum.UserRole;
import SIMSclient.src.presentation.remindui.RemindPrintUI;
import SIMSclient.src.presentation.userui.UserManagingUI;
import SIMSclient.src.presentation.remindui.RemindExistUI;
import SIMSclient.src.vo.UserVO;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class UserInsertUI extends UserManagingUI{

	@FXML
	public void confirm(){

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
        service.insert(user);
        list.add(user);
        table.setItems(list);
        insertInit();
        }
	}

	@FXML
	public void cancel(){
		insertInit();
	}


	public void insertInit(){

		nameField.setText("admin");
		passwordField.setText("admin");
		if(!list.isEmpty()){
	       String initID = addOne(list.get(list.size()-1).getID());
           idLabel.setText(initID);
        }else{
           idLabel.setText("0000001");
        }
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		manageInit();
		insertInit();
        roleChoice.setItems(FXCollections.observableArrayList(roleList));
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		changeStage("UserInsertUI","UserInsertUI.fxml");
	}


}
