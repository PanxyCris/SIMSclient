package presentation.salestockstaffui;

import dataenum.BillType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.salestockstaffui.controller.PurchaseMakeBillController;
import vo.UserVO;

public class PurchaseMakeBillUI extends MakeReceiptUI {

	public void start(UserVO user,BillType type) throws Exception{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/PurchaseMakeBillUI.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setScene( new Scene((Pane) loader.load()));
        PurchaseMakeBillController controller = loader.<PurchaseMakeBillController>getController();
        controller.initData(user,type);
        primaryStage.show();
	}

}
