package SIMSclient.src.presentation.mainui;

import SIMSclient.src.vo.UserVO;
import javafx.application.Application;
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

	}

	public static void main(String[] args){
		launch(args);
	}
}
