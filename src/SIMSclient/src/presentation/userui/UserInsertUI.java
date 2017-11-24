package SIMSclient.src.presentation.userui;

import java.net.URL;
import java.util.ResourceBundle;

import SIMSclient.src.bussinesslogic.userbl.UserBL;
import SIMSclient.src.bussinesslogicservice.userblservice.UserBLService;
import SIMSclient.src.presentation.remindui.RemindPrintUI;
import SIMSclient.src.presentation.userui.UserManagingUI;
import SIMSclient.src.presentation.userui.remindui.RemindExistUI;
import SIMSclient.src.vo.UserVO;
import SIMSclient.src.vo.UserVO.UserRole;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class UserInsertUI extends UserManagingUI {

	@FXML
	public void confirm(){

        UserVO user = new UserVO(idLabel.getText(), nameField.getText(), passwordField.getText(),roleChoice.getValue());
        UserBLService service = UserBL.getInstance().getUserService();

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
						new RemindExistUI().start(new Stage());
					} catch (Exception e) {
						e.printStackTrace();
					}
	    	    }
	    	});
        }else{
        service.insert(user);
        list.add(user);
        table.setItems(list);
        }
	}

	@FXML
	public void cancel(){
		String initID = addOne(list.get(list.size()-1).getID());
		nameField.setText("admin");
        idLabel.setText(initID);
        passwordField.setText("admin");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cancel();
        roleChoice.setItems(FXCollections.observableArrayList(UserRole.COMMODITYPERSON,
        		                                              UserRole.FINANCIALSTAFF,
        		                                              UserRole.MANAGER,
        		                                              UserRole.SALESPERSON,
        		                                              UserRole.USERMANAGER));
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		changeStage("UserInsertUI","UserInsertUI.fxml");
	}

}
