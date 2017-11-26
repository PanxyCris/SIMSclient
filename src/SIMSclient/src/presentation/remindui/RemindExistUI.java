package SIMSclient.src.presentation.remindui;

import java.net.URL;
import java.util.ResourceBundle;

import SIMSclient.src.dataenum.Remind;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RemindExistUI{


	@FXML
	Button button;
	@FXML
	AnchorPane pane;
	@FXML
	Label info;

	@FXML
	public void confirm(){
	   exit();
	}

	@FXML
	public void exitKey(KeyEvent event){
		if(event.getCode()==KeyCode.ENTER)
			exit();
	}

	public void exit(){
		Stage stage = (Stage) button.getScene().getWindow();
	    stage.close();
	}

	public void start(Stage primaryStage,String remind) throws Exception {
		    Parent root = FXMLLoader.load(getClass().getResource("RemindExistUI.fxml"));
	        Scene scene = new Scene(root);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	        info.setText("¸Ã"+remind+"ÒÑ´æÔÚ");
	}





}
