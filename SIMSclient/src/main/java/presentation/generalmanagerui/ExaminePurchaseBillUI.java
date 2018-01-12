package presentation.generalmanagerui;

import dataenum.BillType;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.generalmanagerui.controller.ExamineBillController;
import presentation.generalmanagerui.controller.ExaminePurchaseBillController;
import presentation.generalmanagerui.controller.GeneralManagerController;
import vo.uservo.UserVO;

public class ExaminePurchaseBillUI{

	public void start(UserVO user) throws Exception{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/ExaminePurchaseBillUI.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setScene( new Scene((Pane) loader.load()));
        ExaminePurchaseBillController controller = loader.<ExaminePurchaseBillController>getController();
        controller.initData(user);
        primaryStage.show();
	}

}
