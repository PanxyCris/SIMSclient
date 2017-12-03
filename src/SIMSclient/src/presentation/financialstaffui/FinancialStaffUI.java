package SIMSclient.src.presentation.financialstaffui;

import java.util.Stack;

import SIMSclient.src.dataenum.Remind;
import SIMSclient.src.presentation.ControlledStage;
import SIMSclient.src.presentation.StageController;
import SIMSclient.src.presentation.mainui.MainUI;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FinancialStaffUI extends Application implements ControlledStage{

	public static final String mainID = "AccountUI";
	public static final String pack = "accountui/fxml/";
	public static final String mainFXML = pack+"AccountUI.fxml";
	static String previous;
	static String current;
	static Stack<String> stack;
	public static final Remind remind = Remind.ACCOUNT;

	static StageController stageController;

	public void setStageController(StageController controller) {
        stageController = controller;
    }
	@FXML
	private AnchorPane pane;
	@FXML
	private ImageView image;


	@FXML
	public void returnLast(){
        stageController.setStage(previous,current);
        if(!stack.isEmpty()){
        stack.pop();
        current = previous;
        }
        if(stack.size()>=1)
            previous = stack.lastElement();
	}

	@FXML
	public void mainPage() throws Exception{
      stageController.setStage(mainID, current);
      previous = current;
      current = mainID;
      stack.push(current);
    }

	@FXML
	public void message(){

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

		Stage stage = new Stage();
		new AccountManageUI().start(stage);
	}
	@FXML
	public void makeReceipt() throws Exception{

		Stage stage = new Stage();
		new MakeReceiptUI().start(stage);
	}
	@FXML
	public void viewTable() throws Exception{

		Stage stage = new Stage();
		new ViewTableUI().start(stage);
	}
	@FXML
	public void initAccount() throws Exception{

		Stage stage = new Stage();
		new InitAccountUI().start(stage);
	}



	@Override
	public void start(Stage primaryStage) throws Exception {


		stageController = new StageController();
        stack = new Stack<>();

        stageController.loadStage(mainID, mainFXML);

        stageController.setStage(mainID);
        previous = current = mainID;
        stack.push(mainID);

	}
/*
	public void showImage(ImageView image) {
		this.image = image;
	}
*/
	public static void main(String[] args){
		launch(args);
	}

	public void changeStage(String currentID,String fxml){
   		stageController.loadStage(currentID, pack+fxml);
   		stageController.setStage(currentID,current);
   		previous = current;
   		current = currentID;
   		stack.push(currentID);
	}


}
