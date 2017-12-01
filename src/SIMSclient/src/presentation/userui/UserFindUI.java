package SIMSclient.src.presentation.userui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import SIMSclient.src.presentation.remindui.RemindPrintUI;
import SIMSclient.src.vo.UserVO;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class UserFindUI extends UserManagingUI{

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
	    	   ObservableList<UserVO> newList = FXCollections.observableArrayList();
	    	   newList.addAll(list);
	    	   table.setItems(newList);
	       }

	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		findChoice.setItems(FXCollections.observableArrayList("ID","用户名","职务"));
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		changeStage("UserFindUI","UserFindUI.fxml");
	}



}
