package presentation.generalmanagerui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.generalmanagerui.controller.PromotionSumController;
import vo.uservo.UserVO;

public class PromotionSumUI {

	public void start(UserVO user) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/PromotionSumUI.fxml"));
		Stage primaryStage = new Stage();
		primaryStage.setScene(new Scene((Pane) loader.load()));
		PromotionSumController controller = loader.<PromotionSumController>getController();
		controller.initData(user);
		primaryStage.show();
	}

}
