package presentation.salestockstaffui;

import presentation.salestockstaffui.controller.SaleStockStaffUIController;
import vo.UserVO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class SaleStockStaffUI{

	public void start(UserVO user) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/SaleStockStaffUI.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setScene( new Scene((Pane) loader.load()));
        SaleStockStaffUIController controller = loader.<SaleStockStaffUIController>getController();
        controller.initData(user);
        primaryStage.show();
	}



}
