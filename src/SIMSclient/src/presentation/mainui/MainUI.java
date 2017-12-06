package SIMSclient.src.presentation.mainui;

import SIMSclient.src.bussinesslogic.userbl.UserController;
import SIMSclient.src.bussinesslogicservice.userblservice.UserBLService;
import SIMSclient.src.dataenum.UserRole;
import SIMSclient.src.dataenum.findtype.FindUserType;
import SIMSclient.src.presentation.financialstaffui.FinancialStaffUI;
import SIMSclient.src.presentation.generalmanagerui.GeneralManagerUI;
import SIMSclient.src.presentation.inventorymanagerui.InventoryManagerUI;
import SIMSclient.src.presentation.salestockstaffui.SaleStockStaffUI;
import SIMSclient.src.presentation.usermanagerui.UserManagerUI;
import SIMSclient.src.vo.UserVO;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainUI extends Application{

	@FXML
	TextField username;
	@FXML
	PasswordField password;
	@FXML
	AnchorPane pane;

	@FXML
	public void enterButton(ActionEvent event){
		login();
	}

	@FXML
	public void enterKey(KeyEvent event){
		if(event.getCode()==KeyCode.ENTER)
			login();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		    Parent root = FXMLLoader.load(getClass().getResource("fxml/Login.fxml"));
	        Scene scene = new Scene(root);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("µÇÂ¼½çÃæ");
	        primaryStage.show();
	}

    public void login(){
		    String userName = username.toString();
		    String passWord = password.toString();

		    UserBLService service = UserController.getInstance().getUserService();

		    if(service.login(userName,passWord)){

		    	Platform.runLater(new Runnable() {
		    	                public void run() {
		    	                   try {
		    	   UserVO user = service.find(userName, FindUserType.NAME).get(0);
		    	   UserRole role = user.getRole();
		    	                      switch(role){
		    	                         case GENERAL_MANAGER:new GeneralManagerUI().start(user);break;
		    	                         case FINANCIAL_MANAGER:new FinancialStaffUI().start(user);break;
		    	                         case PUR_SALE_MANAGER: new SaleStockStaffUI().start(user);break;
		    	                         case INVENTORY_MANAGER: new InventoryManagerUI().start(user);break;
				                         case USER_MANAGER: new UserManagerUI().start(user);
													    //	userUI.showImage(service.getImage());
														   break;
		    	                      }
													} catch (Exception e) {
														e.printStackTrace();
													}
 	                                         }
 	                                  });
 	                       Stage stage = (Stage) pane.getScene().getWindow();
			              stage.close();
                	}
		     else{
		    	username.setText(null);
		    	password.setText(null);
		    	Platform.runLater(new Runnable() {
		    	    public void run() {
		    	        try {
							new RemindUI().start(new Stage());
						} catch (Exception e) {
							e.printStackTrace();
						}
		    	    }
		    	});

		    }

	}

	public static void main(String[] args){
		launch(args);
	}
}
