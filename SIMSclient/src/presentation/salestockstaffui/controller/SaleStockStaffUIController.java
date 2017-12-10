package presentation.salestockstaffui.controller;

import java.util.Stack;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.common.StageController;
import presentation.mainui.MainUI;
import presentation.salestockstaffui.MemberManageUI;
import vo.UserVO;

public class SaleStockStaffUIController {

	public static final String mainID = "SaleStockStaffUI";
	public static final String pack = "../salestockstaffui/fxml/";
	public static final String mainFXML = pack+"SaleStockStaffUI.fxml";
	static String previous;
	static String current;
	static Stack<String> stack;

	UserVO user ;

	static StageController stageController;

	@FXML
	protected AnchorPane pane;
	@FXML
	private ImageView image;

	@FXML
	public void mainPage() throws Exception{
      stageController.setStage(mainID, current);
      previous = current;
      current = mainID;
      stack.push(current);
    }

	@FXML
	public void fresh(){
		stageController.setStage(current,current);
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
	public void memberManage() throws Exception{
         new MemberManageUI().start();
	}

	@FXML
	public void makeReceipt() throws Exception{

	}


	public void initData(UserVO user) {
		this.user = user;
		image = user.getImage();
	}

	public void changeStage(String currentID,String fxml){
   		stageController.loadStage(currentID, pack+fxml);
   		stageController.setStage(currentID,current);
   		previous = current;
   		current = currentID;
   		stack.push(currentID);
	}


}
