package SIMSclient.src.presentation.mainui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RemindUI {

	@FXML
	Button button;

	@FXML
	public void confirm(){
	    Stage stage = (Stage) button.getScene().getWindow();
	    stage.close();
	}

	public void start(Stage primaryStage) throws Exception {
		    Parent root = FXMLLoader.load(getClass().getResource("Remind.fxml"));
	        Scene scene = new Scene(root, 300, 200);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("提示界面");
	        primaryStage.show();
	}




}
