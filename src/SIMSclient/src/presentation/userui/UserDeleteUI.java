package SIMSclient.src.presentation.userui;

import java.net.URL;
import java.util.ResourceBundle;

import SIMSclient.src.bussinesslogic.userbl.UserBL;
import SIMSclient.src.bussinesslogicservice.userblservice.UserBLService;
import SIMSclient.src.presentation.remindui.RemindPrintUI;
import SIMSclient.src.presentation.userui.remindui.RemindnotExistUI;
import SIMSclient.src.vo.UserVO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class UserDeleteUI extends UserManagingUI {

	@FXML
	public void confirm(){
		  UserBLService service = UserBL.getInstance().getUserService();
		  if(!service.judgeLegal(idField.getText(), nameField.getText())){
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
		  else if(!service.judgeExist(idField.getText())){
			  Platform.runLater(new Runnable() {
		    	    public void run() {
		    	        try {
							new RemindnotExistUI().start(new Stage());
						} catch (Exception e) {
							e.printStackTrace();
						}
		    	    }
		    	});
		  }
		  else{
			  UserVO user = service.delete(idField.getText(), nameField.getText());
			  list.remove(user);
	          table.setItems(list);
		  }
	}

	@FXML
	public void cancel(){
		nameField.setText("ÓÃ»§Ãû");
		idField.setText("ID");
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cancel();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		changeStage("UserDeleteUI","UserDeleteUI.fxml");
	}

}
