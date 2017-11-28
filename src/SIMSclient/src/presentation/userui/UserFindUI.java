package SIMSclient.src.presentation.userui;

import java.net.URL;

import java.util.ResourceBundle;

import SIMSclient.src.bussinesslogic.userbl.UserBL;
import SIMSclient.src.bussinesslogicservice.userblservice.UserBLService;
import SIMSclient.src.dataenum.UserRole;
import SIMSclient.src.presentation.remindui.RemindNotPrintUI;
import SIMSclient.src.vo.UserVO;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class UserFindUI extends UserManagingUI{

	@FXML
	public void blurFind(){
		UserBLService service = UserBL.getInstance().getUserService();
	       UserVO user = service.blurFind(findingField.getText());
	       if(user==null){
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
	    	  findingField.setText(user.getID()+" "+user.getName()+" "+user.getPassword()+" "+user.getRoleName());
	       }

	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		manageInit();
        roleChoice.setItems(FXCollections.observableArrayList(UserRole.GENERAL_MANAGER.value,
                                                              UserRole.FINANCIAL_MANAGER.value,
                                                              UserRole.INVENTORY_MANAGER.value,
                                                              UserRole.PUR_SALE_MANAGER.value,
                                                              UserRole.USER_MANAGER.value));
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		changeStage("UserFindUI","UserFindUI.fxml");
	}



}
