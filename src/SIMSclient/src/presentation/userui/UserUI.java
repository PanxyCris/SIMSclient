package SIMSclient.src.presentation.userui;

import java.io.IOException;


import java.util.*;

import SIMSclient.src.presentation.ControlledStage;
import SIMSclient.src.presentation.StageController;
import SIMSclient.src.presentation.mainui.MainUI;
import SIMSclient.src.vo.UserVO;
import SIMSclient.src.vo.UserVO.UserRole;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UserUI extends Application implements ControlledStage{

	public static final String mainID = "UserUI";
	public static final String pack = "userui/";
	public static final String mainFXML = pack+"UserUI.fxml";
	static String previous;
	static String current;
	static Stack<String> stack;

	private StageController stageController;

	public void setStageController(StageController stageController) {
        this.stageController = stageController;
    }

	@FXML
	private AnchorPane pane;
	@FXML
	private ImageView image;
/*
	@FXML
	private TextField findingobject;
	@FXML
	private TableView<UserVO> table;
	@FXML
	private TableColumn<UserVO,Integer> tableID;
	@FXML
	private TableColumn<UserVO,String> tableName;
	@FXML
	private TableColumn<UserVO,UserRole> tableRole;
*/
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
		stageController.loadStage(currentID, pack+"UserManageUI.fxml");
		stageController.setStage(currentID,mainID);
		previous = current;
		current = currentID;
		stack.push(mainID);
	}
/*
	@FXML
	public void insert(){

	}

	@FXML
	public void delete(){

	}

	@FXML
	public void update(){

	}

	@FXML
	public void find(){

	}
*/
	@FXML
	public void confirm(){

	}

	@FXML
	public void cancel(){

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




}
