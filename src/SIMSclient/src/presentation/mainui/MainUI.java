package SIMSclient.src.presentation.mainui;

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
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private AnchorPane pane;

	@FXML
	private void register(ActionEvent ev){


	}

	@FXML
	private void login(ActionEvent ev){


	}

	@FXML
	private void loginKey(KeyEvent ev){
		if(ev.getCode()==KeyCode.ENTER)
			System.out.println("Success!");
	}



	@Override
	public void start(Stage primaryStage) throws Exception {
		    Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
	        Scene scene = new Scene(root, 600, 400);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("µÇÂ¼½çÃæ");
	        primaryStage.show();

	}

	public static void main(String[] args){
		launch(args);
	}
}
