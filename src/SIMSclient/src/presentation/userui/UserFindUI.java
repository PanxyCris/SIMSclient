package SIMSclient.src.presentation.userui;

import java.net.URL;
import java.util.ResourceBundle;
import SIMSclient.src.presentation.remindui.RemindPrintUI;
import SIMSclient.src.vo.UserVO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class UserFindUI extends UserManagingUI{

	@FXML
	public void blurFind(){
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
	    	  findingField.setText(user.getID()+" "+user.getName()+" "+user.getPassword()+" "+user.getRoleName());
	       }

	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		manageInit();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		changeStage("UserFindUI","UserFindUI.fxml");
	}



}
