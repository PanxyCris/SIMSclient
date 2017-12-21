package presentation.generalmanagerui;

import dataenum.BillType;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.generalmanagerui.controller.ExamineBillController;
import presentation.generalmanagerui.controller.ExaminePaymentBillController;
import presentation.generalmanagerui.controller.GeneralManagerController;
import vo.uservo.UserVO;

public class ExaminePaymentBillUI{

	public void start(UserVO user,BillType type) throws Exception{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/ExaminePaymentBillUI.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setScene( new Scene((Pane) loader.load()));
        ExaminePaymentBillController controller = loader.<ExaminePaymentBillController>getController();
        controller.initData(user,type);
        primaryStage.show();
	}

}
