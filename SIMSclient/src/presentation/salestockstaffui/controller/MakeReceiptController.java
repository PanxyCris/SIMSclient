package presentation.salestockstaffui.controller;

import java.net.URL;

import java.rmi.RemoteException;
import java.util.ResourceBundle;

import dataenum.BillType;
import dataenum.Remind;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import vo.uservo.UserVO;

public class MakeReceiptController extends SaleStockStaffController implements Initializable {

	public static final Remind remind = Remind.BILL;
	@FXML
	ChoiceBox<String> receiptChoice;


	@FXML
	public void returnLast() throws Exception{
        startUI(previous,user,type,purchase,sale);
        if(!stack.isEmpty()){
        stack.pop();
        current = previous;
        }
        if(stack.size()>1)
            previous = stack.lastElement();
	}

	@FXML
	public void mainPage() throws Exception{
		changeStage(mainID,user,type,purchase,sale);

    }

	@FXML
	public void fresh() throws Exception{
		startUI(current,user,type,purchase,sale);
	}

    @FXML
	public void memberManage() throws Exception{
         changeStage("MemberManageUI",user,type,null,null);
	}

	@FXML
	public void makeReceipt() throws Exception{
		 changeStage("MakeReceiptUI",user,type,null,null);
	}

	@FXML
	public void chooseReceipt() throws Exception{
		BillType type = BillType.getType(receiptChoice.getValue());
		switch(type){
		case PURCHASEBILL:changeStage("PurchaseMakeBillUI",user,type,null,null);break;
		case PURCHASEBACKBILL:changeStage("PurchaseMakeBillUI",user,type,null,null);break;
		case SALESBILL:changeStage("SakesMakeBillUI",user,type,null,null);break;
		case SALESBACKBILL:changeStage("SalesMakeBillUI",user,type,null,null);break;
		default:break;
		}
	}

	public void initData(UserVO user) throws Exception {
           this.user = user;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			choiceInit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void choiceInit() throws Exception{
		receiptChoice.setItems(FXCollections.observableArrayList(BillType.PURCHASEBILL.value,BillType.PURCHASEBACKBILL.value,
				BillType.SALESBILL.value,BillType.SALESBACKBILL.value));
	}

}
