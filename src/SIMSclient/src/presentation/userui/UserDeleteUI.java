package SIMSclient.src.presentation.userui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import SIMSclient.src.presentation.remindui.RemindExistUI;
import SIMSclient.src.vo.UserVO;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class UserDeleteUI extends UserManagingUI {

	@FXML
	public void confirm(){
		ArrayList<UserVO> userList = service.blurFind(findingField.getText(), findChoice.getValue());
	    if(userList==null){
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
			  service.delete(userList.get(0));
			  list.remove(userList.get(0));
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
		roleChoice.setItems(FXCollections.observableArrayList("ID","ÓÃ»§Ãû"));
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		changeStage("UserDeleteUI","UserDeleteUI.fxml");
	}

}
