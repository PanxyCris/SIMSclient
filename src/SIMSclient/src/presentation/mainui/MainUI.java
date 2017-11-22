package SIMSclient.src.presentation.mainui;

import SIMSclient.src.bussinesslogic.userbl.UserBL;
import SIMSclient.src.bussinesslogicservice.userblservice.UserBLService;
import SIMSclient.src.presentation.accountui.AccountUI;
import SIMSclient.src.presentation.commodityui.CommodityUI;
import SIMSclient.src.presentation.promotionui.PromotionUI;
import SIMSclient.src.presentation.salesui.SalesUI;
import SIMSclient.src.presentation.userui.UserUI;
import SIMSclient.src.vo.UserVO.UserRole;
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
		    Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
	        Scene scene = new Scene(root, 600, 400);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("µÇÂ¼½çÃæ");
	        primaryStage.show();
	}

    public void login(){
		    String userName = username.toString();
		    String passWord = password.toString();

		    UserBLService service = UserBL.getInstance().getUserService();

		    if(service.judge(userName,passWord)){

		    	UserRole role = service.getRole();

		    	switch(role){

		    	case MANAGER:Platform.runLater(new Runnable() {
		    	                public void run() {
		    	                   try {
							              new PromotionUI().start(new Stage());
						           } catch (Exception e) {
							                 e.printStackTrace();
						                    }
		    	                  }
		    	                 });break;
		    	case FINANCIALSTAFF:Platform.runLater(new Runnable() {
	                             public void run() {
 	                             try {
					                  new AccountUI().start(new Stage());
				                  } catch (Exception e) {
					                 e.printStackTrace();
				                    }
 	                                }
 	                              });break;
		    	case SALESPERSON:Platform.runLater(new Runnable() {
	                              public void run() {
 	                              try {
					              new SalesUI().start(new Stage());
				                  } catch (Exception e) {
					                 e.printStackTrace();
				                    }
 	                               }
 	                             });break;
		    	case COMMODITYPERSON:Platform.runLater(new Runnable() {
	                                       public void run() {
 	                                          try {
					                              new CommodityUI().start(new Stage());
				                              } catch (Exception e) {
					                                  e.printStackTrace();
				                                   }
 	                                      }
 	                                 });break;
		    	case USERMANAGER:Platform.runLater(new Runnable() {
	                                    public void run() {
					                                 try {
														new UserUI().start(new Stage());
													} catch (Exception e) {
														e.printStackTrace();
													}
 	                                         }
 	                                  });break;

		    	}
		    	Stage stage = (Stage) pane.getScene().getWindow();
			    stage.close();

		    }else{
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
