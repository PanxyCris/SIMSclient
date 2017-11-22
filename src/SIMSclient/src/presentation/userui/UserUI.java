package SIMSclient.src.presentation.userui;

import java.io.IOException;
import java.util.*;

import SIMSclient.src.presentation.mainui.MainUI;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UserUI extends Application implements ControlledStage{


	public static final String mainID = "UserUI";
	public static final String mainFXML = "UserUI.fxml";
	static String previous;
	static String current;
	static Stack<String> stack;

	private StageController stageController;

	public void setStageController(StageController stageController) {
        this.stageController = stageController;
    }

	@FXML
	Label welcome;
	@FXML
	AnchorPane pane;

	@FXML
	public void returnLast(){
        stageController.setStage(previous,current);
        stack.pop();
        current = previous;
        if(stack.size()>1)
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
	public void userManage() throws IOException{

		String currentID = "UserManageUI";
		stageController.loadStage(currentID, "UserManageUI.fxml");
		stageController.setStage(currentID,mainID);
		previous = current;
		current = currentID;
		stack.push(mainID);
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

	public static void main(String[] args){
		launch(args);
	}

}
