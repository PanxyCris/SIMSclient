package presentation.financialstaffui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.financialstaffui.controller.ReceiveCheckBillController;
import presentation.financialstaffui.controller.ReceiveMakeBillController;
import vo.UserVO;
import vo.FinancialBill.ReceiptBillVO;

public class ReceiveMakeBillUI {

	 public void start(UserVO user,ReceiptBillVO bill) throws Exception{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/ReceiveMakeBillUI.fxml"));
	        Stage primaryStage = new Stage();
	        primaryStage.setScene( new Scene((Pane) loader.load()));
	        ReceiveMakeBillController controller = loader.<ReceiveMakeBillController>getController();
	        controller.initData(user,bill);
	        primaryStage.show();
		}

}
