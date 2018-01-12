package presentation.financialstaffui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.financialstaffui.controller.BussinessSituationTableController;
import vo.uservo.UserVO;

public class BussinessSituationTableUI {

	 public void start(UserVO user) throws Exception{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/BussinessSituationTableUI.fxml"));
	        Stage primaryStage = new Stage();
	        primaryStage.setScene( new Scene((Pane) loader.load()));
	        BussinessSituationTableController controller = loader.<BussinessSituationTableController>getController();
	        controller.initData(user);
	        primaryStage.show();
		}

}
