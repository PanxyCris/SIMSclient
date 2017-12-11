package presentation.salestockstaffui;

import vo.UserVO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Stack;

import dataenum.Remind;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.common.ControlledStage;
import presentation.common.StageController;
import presentation.mainui.MainUI;
import presentation.remindui.RemindExistController;


public class SaleStockStaffUI implements ControlledStage{


	public static final String mainID = "SaleStockStaffUI";
	public static final String pack = "../salestockstaffui/fxml/";
	public static final String mainFXML = pack+"SaleStockStaffUI.fxml";
	static String previous;
	static String current;
	static Stack<String> stack;


	UserVO user ;

    static StageController stageController;

	public void setStageController(StageController controller) {
        stageController = controller;
    }

	@FXML
	protected AnchorPane pane;
	@FXML
	private ImageView image;


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


	public void start(UserVO user) throws Exception {
		stageController = new StageController();
        stack = new Stack<>();

        stageController.loadStage(mainID, mainFXML);

        stageController.setStage(mainID);
        previous = current = mainID;
        stack.push(mainID);
        this.user = user;
    	BufferedWriter fw = new BufferedWriter(new FileWriter("src/presentation/salestockstaffui/doc/tmp.txt"));
		fw.write(user.getName());
		fw.close();
     //   image = user.getImage();
	}


	public void changeStage(String currentID,String fxml){
   		stageController.loadStage(currentID, pack+fxml);
   		stageController.setStage(currentID,current);
   		previous = current;
   		current = currentID;
   		stack.push(currentID);
	}



}
