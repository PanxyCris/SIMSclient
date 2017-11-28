package SIMSclient.src.presentation.remindui;

import SIMSclient.src.dataenum.Remind;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RemindExistUI{

	public void start(Remind remind,Boolean isExist) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("RemindExistUI.fxml"));
	        Stage primaryStage = new Stage();
	        primaryStage.setScene( new Scene((Pane) loader.load()));
	        RemindExistController controller = loader.<RemindExistController>getController();
	       controller.initData(remind,isExist);
	        primaryStage.show();
	}

}
