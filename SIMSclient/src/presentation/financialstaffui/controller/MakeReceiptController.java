package presentation.financialstaffui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import dataenum.BillType;
import dataenum.Remind;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import vo.UserVO;

public class MakeReceiptController extends FinancialStaffController implements Initializable{

	public static final Remind remind = Remind.BILL;
	UserVO user;
	@FXML
	ChoiceBox<String> receiptChoice;

	@FXML
	public void chooseReceipt() throws Exception{
		BillType type = BillType.getType(receiptChoice.getValue());
		switch(type){
		case SKD:changeStage("ReceiveMakeBillUI",user,null,null);break;
		case XJFYD:changeStage("PaymentMakeBillUI",user,null,null);break;
		default:break;
		}
	}

	public void initData(UserVO user) throws Exception {
           this.user = user;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		choiceInit();
	}

	public void choiceInit(){
		receiptChoice.setItems(FXCollections.observableArrayList(BillType.SKD.value,BillType.XJFYD.value));
	}

}
