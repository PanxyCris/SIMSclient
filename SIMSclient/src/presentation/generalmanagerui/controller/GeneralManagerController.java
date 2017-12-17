package presentation.generalmanagerui.controller;

import java.util.Stack;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.generalmanagerui.PromotionMakingUI;
import presentation.generalmanagerui.PromotionMemberUI;
import presentation.mainui.MainUI;
import presentation.usermanagerui.UserManagerUI;
import presentation.usermanagerui.UserManagingUI;
import presentation.usermanagerui.UserMessageUI;
import vo.UserVO;

public class GeneralManagerController {

	public static final String mainID = "GeneralManagerUI";
	static String previous;
	static String current;
	static Stack<String> stack;

	UserVO user;

	@FXML
	protected AnchorPane pane;
	@FXML
	protected ImageView image;


	@FXML
	public void returnLast() throws Exception{
        startUI(previous);
        if(!stack.isEmpty()){
        stack.pop();
        current = previous;
        }
        if(stack.size()>1)
            previous = stack.lastElement();
	}

	@FXML
	public void mainPage() throws Exception{
		changeStage(mainID);

    }

	@FXML
	public void fresh() throws Exception{
		startUI(current);
	}

	@FXML
	public void message() throws Exception{
       changeStage("UserMessageUI");
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
	public void checkBill() throws Exception{
		changeStage("ExamineBillUI");
	}

	@FXML
	public void checkTable() throws Exception{
		changeStage("FinanceTableUI");
	}


	@FXML
	public void makePromotion() throws Exception{
		changeStage("PromotionMakingUI");
	}

	@FXML
	public void checkDiary() throws Exception{
	//	changeStage("PromotionMakingUI");
	}




	public void initData(UserVO user) throws Exception {
        stack = new Stack<>();
        previous = current = mainID;
        stack.push(mainID);
        this.user = user;
     //   image = user.getImage();
	}


	public void changeStage(String currentID) throws Exception{

   	    startUI(currentID);
	    previous = current;
	    current = currentID;
	    stack.push(current);
	}

	public void startUI(String currentID){
	    Stage stage = (Stage) pane.getScene().getWindow();
	    stage.close();
			Platform.runLater(new Runnable() {
            public void run() {
                try {
                   switch(currentID){
   		            case mainID:new UserManagerUI().start(user);break;
   		            case "PromotionMakingUI":new PromotionMakingUI().start(user);break;
   		            case "PromotionMemberUI":new PromotionMemberUI().start(user);break;
   		         //   case "UserManagingUI":new UserManagingUI().start(user);break;
   		         //   case "UserMessageUI":new UserMessageUI().start();break;
   		           }
               } catch (Exception e) {
                       e.printStackTrace();
                    }
            }
       });

	}


}
