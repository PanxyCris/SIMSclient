package SIMSclient.src.presentation.generalmanagerui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GeneralManagerUI extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		    Parent root = FXMLLoader.load(getClass().getResource("GeneralManagerUI.fxml"));
	        Scene scene = new Scene(root);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("总经理界面");
	        primaryStage.show();
	}

	public static void main(String[] args){
		launch(args);
	}

}
