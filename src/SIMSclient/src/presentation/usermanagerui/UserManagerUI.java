package SIMSclient.src.presentation.userui;


import java.util.*;

import SIMSclient.src.dataenum.Remind;
import SIMSclient.src.presentation.ControlledStage;
import SIMSclient.src.presentation.StageController;
import SIMSclient.src.presentation.mainui.MainUI;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UserUI extends Application implements ControlledStage{

	public static final String mainID = "UserUI";
	public static final String pack = "userui/fxml/";
	public static final String mainFXML = pack+"UserUI.fxml";
	static String previous;
	static String current;
	static Stack<String> stack;
	public static final Remind remind = Remind.USER;

	static StageController stageController;

	public void setStageController(StageController controller) {
        stageController = controller;
    }
	@FXML
	protected AnchorPane pane;
	@FXML
	private ImageView image;
	@FXML
	Button ret;


	@FXML
	public void returnLast(){
        stageController.setStage(previous,current);
        if(!stack.isEmpty()){
        stack.pop();
        current = previous;
        }
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
	public void userManage() throws Exception{

		Stage stage = new Stage();
		new UserManagingUI().start(stage);
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
