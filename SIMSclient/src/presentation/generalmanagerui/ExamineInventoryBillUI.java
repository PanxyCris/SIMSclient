package presentation.generalmanagerui;

import dataenum.BillType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.generalmanagerui.controller.ExamineInventoryBillController;
import vo.uservo.UserVO;

public class ExamineInventoryBillUI{

	public void start(UserVO user,BillType type) throws Exception{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/InventoryBillUI.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setScene( new Scene((Pane) loader.load()));
        ExamineInventoryBillController controller = loader.<ExamineInventoryBillController>getController();
        controller.initData(user,type);
        primaryStage.show();
	}

}
