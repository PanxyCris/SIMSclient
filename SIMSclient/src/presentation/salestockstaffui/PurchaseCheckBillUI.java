package presentation.salestockstaffui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.salestockstaffui.controller.PurchaseCheckBillController;
import vo.UserVO;

public class PurchaseCheckBillUI {

	public void start(UserVO user) throws Exception{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/PurchaseCheckBillUI.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setScene( new Scene((Pane) loader.load()));
        PurchaseCheckBillController controller = loader.<PurchaseCheckBillController>getController();
        controller.initData(user);
        primaryStage.show();
	}

}
