package SIMSclient.src.presentation.userui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UserUI extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		    Parent root = FXMLLoader.load(getClass().getResource("UserUI.fxml"));
	        Scene scene = new Scene(root, 900, 600);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("用户管理人员界面");
	        primaryStage.show();
	}

	public static void main(String[] args){
		launch(args);
	}

}
