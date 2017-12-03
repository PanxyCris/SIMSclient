package SIMSclient.src.presentation.userui;

import java.net.URL;
import java.util.ResourceBundle;

import SIMSclient.src.dataenum.ResultMessage;
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
        ResultMessage message = service.insert(user);
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
		cancel();
        roleChoice.setItems(FXCollections.observableArrayList(roleList));
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		changeStage("UserInsertUI","UserInsertUI.fxml");
	}

}
