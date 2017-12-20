package presentation.salestockstaffui;

import java.io.IOException;

import dataenum.BillType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.salestockstaffui.controller.SalesCheckBillController;
import vo.billvo.salesbillvo.SalesVO;
import vo.uservo.UserVO;

public class SalesCheckBillUI {

	public void start(UserVO user, BillType type, SalesVO sales) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/SalesCheckBillUI.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setScene( new Scene((Pane) loader.load()));
        SalesCheckBillController controller = loader.<SalesCheckBillController>getController();
        controller.initData(user,type,sales);
        primaryStage.show();

	}

}
