package presentation.inventorymanagerui.controller;

import java.util.Stack;

import dataenum.BillType;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.inventorymanagerui.InventoryManagerUI;
import presentation.mainui.MainUI;
import vo.billvo.inventorybillvo.InventoryBillVO;
import vo.uservo.UserVO;

public class InventoryManagerController {


	public static final String mainID = "InventoryManagerUI";
	static String previous;
	static String current;
	static Stack<String> stack;
	UserVO user;
	BillType type;
	InventoryBillVO inv;

	@FXML
	protected AnchorPane pane;
	@FXML
	private ImageView image;


	@FXML
	public void returnLast() throws Exception{
        startUI(previous,user,type,inv);
        if(!stack.isEmpty()){
        stack.pop();
        current = previous;
        }
        if(stack.size()>1)
            previous = stack.lastElement();
	}

	@FXML
	public void mainPage() throws Exception{
		changeStage(mainID,user,type,inv);

    }

	@FXML
	public void fresh() throws Exception{
		startUI(current,user,type,inv);
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
	public void classManage() throws Exception{
         changeStage("ClassManageUI",user,type,inv);
	}

	@FXML
	public void commodityManage() throws Exception{
         changeStage("CommodityManageUI",user,type,inv);
	}

	@FXML
	public void inventoryCheck() throws Exception{
         changeStage("InventoryCheckUI",user,type,inv);
	}

	@FXML
	public void inventoryStock() throws Exception{
         changeStage("InventoryStockUI",user,type,inv);
	}

	@FXML
	public void makeReceipt() throws Exception{
		 changeStage("MakeReceiptUI",user,type,inv);
	}


	public void initData(UserVO user) throws Exception {
        stack = new Stack<>();
        previous = current = mainID;
        stack.push(mainID);
        this.user = user;
     //   image = user.getImage();
	}


	public void changeStage(String currentID,UserVO user,BillType type,InventoryBillVO inv) throws Exception{

   	    startUI(currentID,user,type,inv);
	    previous = current;
	    current = currentID;
	    stack.push(current);
	}

	public void startUI(String currentID,UserVO user,BillType type,InventoryBillVO inv){
	    Stage stage = (Stage) pane.getScene().getWindow();
	    stage.close();
			Platform.runLater(new Runnable() {
            public void run() {
                try {
                   switch(currentID){
   		            case mainID:new InventoryManagerUI().start(user);break;

   		           }
               } catch (Exception e) {
                       e.printStackTrace();
                    }
            }
       });

	}


}