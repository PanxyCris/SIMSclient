package SIMSclient.src.presentation.userui;

import java.net.URL;


import java.util.ResourceBundle;

import SIMSclient.src.bussinesslogic.userbl.UserBL;
import SIMSclient.src.bussinesslogicservice.userblservice.UserBLService;
import SIMSclient.src.presentation.remindui.RemindExistUI;
import SIMSclient.src.presentation.remindui.RemindPrintUI;
import SIMSclient.src.vo.UserVO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class UserDeleteUI extends UserManagingUI {

	@FXML
	public void confirm(){
		  UserBLService service = UserBL.getInstance().getUserService();
		  if(!service.judgeLegal(findingField.getText())){
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
		  else if(!service.judgeExist(findingField.getText())){
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
			  UserVO user = service.delete(findingField.getText());
			  list.remove(user);
	          table.setItems(list);
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
		changeStage("UserDeleteUI","UserDeleteUI.fxml");
	}

}
