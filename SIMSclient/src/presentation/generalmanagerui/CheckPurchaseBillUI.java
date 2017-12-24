package presentation.generalmanagerui;

import dataenum.BillType;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.generalmanagerui.controller.CheckPurchaseBillController;
import presentation.generalmanagerui.controller.ExamineBillController;
import presentation.generalmanagerui.controller.ExaminePurchaseBillController;
import presentation.generalmanagerui.controller.GeneralManagerController;
import vo.uservo.UserVO;

public class CheckPurchaseBillUI{

	public void start(UserVO user) throws Exception{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/CheckPurchaseBillUI.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setScene( new Scene((Pane) loader.load()));
        CheckPurchaseBillController controller = loader.<CheckPurchaseBillController>getController();
        controller.initData(user);
        primaryStage.show();
	}

}
