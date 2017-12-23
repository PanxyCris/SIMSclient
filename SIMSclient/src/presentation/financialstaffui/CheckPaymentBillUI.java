package presentation.financialstaffui;

import dataenum.BillType;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.generalmanagerui.controller.ExamineBillController;
import presentation.generalmanagerui.controller.ExaminePaymentBillController;
import presentation.generalmanagerui.controller.GeneralManagerController;
import vo.uservo.UserVO;

public class CheckPaymentBillUI{

	public void start(UserVO user,BillType type) throws Exception{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/CheckPaymentBillUI.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setScene( new Scene((Pane) loader.load()));
        CheckPaymentBillController controller = loader.<CheckPaymentBillController>getController();
        controller.initData(user,type);
        primaryStage.show();
	}

}
