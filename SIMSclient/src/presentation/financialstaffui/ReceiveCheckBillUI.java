package presentation.financialstaffui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.financialstaffui.controller.AccountManageController;
import presentation.financialstaffui.controller.ReceiveCheckBillController;
import vo.UserVO;

public class ReceiveCheckBillUI{

	  public void start(UserVO user) throws Exception{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/ReceiveCheckBillUI.fxml"));
	        Stage primaryStage = new Stage();
	        primaryStage.setScene( new Scene((Pane) loader.load()));
	        ReceiveCheckBillController controller = loader.<ReceiveCheckBillController>getController();
	        controller.initData(user);
	        primaryStage.show();
		}


}
