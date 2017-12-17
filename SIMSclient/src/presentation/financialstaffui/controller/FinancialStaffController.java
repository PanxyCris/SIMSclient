package presentation.financialstaffui.controller;

import java.util.Stack;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.financialstaffui.AccountManageUI;
import presentation.financialstaffui.FinancialStaffUI;
import presentation.financialstaffui.InitAccountUI;
import presentation.financialstaffui.MakeReceiptUI;
import presentation.financialstaffui.PaymentCheckBillUI;
import presentation.financialstaffui.PaymentMakeBillUI;
import presentation.financialstaffui.ReceiveCheckBillUI;
import presentation.financialstaffui.ReceiveMakeBillUI;
import presentation.financialstaffui.ViewTableUI;
import presentation.mainui.MainUI;
import vo.billvo.financialbillvo.PaymentBillVO;
import vo.billvo.financialbillvo.ReceiptBillVO;
import vo.uservo.UserVO;

public class FinancialStaffController {


	public static final String mainID = "FinancialStaffUI";
	static String previous;
	static String current;
	static Stack<String> stack;
	UserVO user;

	@FXML
	protected AnchorPane pane;
	@FXML
	private ImageView image;


	@FXML
	public void returnLast() throws Exception{
        startUI(previous,user,null,null);
        if(!stack.isEmpty()){
        stack.pop();
        current = previous;
        }
        if(stack.size()>1)
            previous = stack.lastElement();
	}

	@FXML
	public void mainPage() throws Exception{
		changeStage(mainID,user,null,null);

    }

	@FXML
	public void fresh() throws Exception{
		startUI(current,user,null,null);
	}


	@FXML
	public void message() throws Exception{

	}

	@FXML
	public void logout(){
		Platform.runLater(new Runnable() {
            public void run() {
                try {
                   new MainUI().start(new Stage());
               } catch (Exception e) {
                       e.printStackTrace();
                    }
            }
       });
		Stage stage = (Stage) pane.getScene().getWindow();
	    stage.close();
	}

	@FXML
	public void accountManage() throws Exception{
		changeStage("AccountManageUI",user,null,null);
	}
	@FXML
	public void makeReceipt() throws Exception{
		changeStage("MakeReceiptUI",user,null,null);
	}
	@FXML
	public void viewTable() throws Exception{
		changeStage("ViewTableUI",user,null,null);
	}
	@FXML
	public void initAccount() throws Exception{
		changeStage("InitAccountUI",user,null,null);
	}

	public void initData(UserVO user) throws Exception {
        stack = new Stack<>();
        previous = current = mainID;
        stack.push(mainID);
        this.user = user;
     //   image = user.getImage();
	}


	public void changeStage(String currentID,UserVO user,PaymentBillVO bill1,ReceiptBillVO bill2) throws Exception{

   	    startUI(currentID,user,bill1,bill2);
	    previous = current;
	    current = currentID;
	    stack.push(current);
	}

	public void startUI(String currentID,UserVO user,PaymentBillVO bill1,ReceiptBillVO bill2){
	    Stage stage = (Stage) pane.getScene().getWindow();
	    stage.close();
			Platform.runLater(new Runnable() {
            public void run() {
                try {
                   switch(currentID){
   		            case mainID:new FinancialStaffUI().start(user);break;
   		            case "AccountManageUI":new AccountManageUI().start(user);break;
   		            case "MakeReceiptUI":new MakeReceiptUI().start(user);break;
   		            case "PaymentMakeBillUI":new PaymentMakeBillUI().start(user,bill1);break;
   		            case "PaymentCheckBillUI":new PaymentCheckBillUI().start(user);break;
   		            case "ReceiveMakeBillUI":new ReceiveMakeBillUI().start(user,bill2);break;
   		            case "ReceiveCheckBillUI":new ReceiveCheckBillUI().start(user);break;
   		         //   case "ViewTableUI":new ViewTableUI().start(user,type);break;
   		        //    case "InitAccountUI":new InitAccountUI().start(user,type);break;
   		           }
               } catch (Exception e) {
                       e.printStackTrace();
                    }
            }
       });

	}




}
