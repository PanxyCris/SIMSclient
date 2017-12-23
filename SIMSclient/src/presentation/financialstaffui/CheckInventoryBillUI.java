package presentation.financialstaffui;

import dataenum.BillType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.generalmanagerui.controller.ExamineInventoryBillController;
import vo.uservo.UserVO;

public class CheckInventoryBillUI{

	public void start(UserVO user,BillType type) throws Exception{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/CheckInventoryBillUI.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setScene( new Scene((Pane) loader.load()));
        CheckInventoryBillController controller = loader.<CheckInventoryBillController>getController();
        controller.initData(user,type);
        primaryStage.show();
	}

}
