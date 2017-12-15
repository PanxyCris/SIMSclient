package presentation.financialstaffui;

import vo.UserVO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.financialstaffui.controller.PaymentMakeBillController;

public class PaymentMakeBillUI{

	 public void start(UserVO user) throws Exception{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/PaymentMakeBillUI.fxml"));
	        Stage primaryStage = new Stage();
	        primaryStage.setScene( new Scene((Pane) loader.load()));
	        PaymentMakeBillController controller = loader.<PaymentMakeBillController>getController();
	        controller.initData(user);
	        primaryStage.show();
		}
}
