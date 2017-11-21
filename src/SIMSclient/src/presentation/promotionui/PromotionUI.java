package SIMSclient.src.presentation.promotionui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PromotionUI extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		    Parent root = FXMLLoader.load(getClass().getResource("PromotionUI.fxml"));
	        Scene scene = new Scene(root, 900, 600);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("总经理界面");
	        primaryStage.show();
	}

	public static void main(String[] args){
		launch(args);
	}

}
