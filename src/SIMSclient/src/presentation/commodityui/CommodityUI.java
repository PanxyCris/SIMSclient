package SIMSclient.src.presentation.commodityui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommodityUI extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		    Parent root = FXMLLoader.load(getClass().getResource("CommodityUI.fxml"));
	        Scene scene = new Scene(root, 700, 500);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("库存管理人员界面");
	        primaryStage.show();
	}

	public static void main(String[] args){
		launch(args);
	}

}
