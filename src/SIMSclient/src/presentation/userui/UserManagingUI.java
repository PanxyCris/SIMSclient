package SIMSclient.src.presentation.userui;

import java.net.URL;


import java.util.ResourceBundle;

import SIMSclient.src.bussinesslogic.userbl.UserBL;
import SIMSclient.src.bussinesslogicservice.userblservice.UserBLService;
import SIMSclient.src.presentation.remindui.RemindPrintUI;
import SIMSclient.src.vo.UserVO;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class UserManagingUI extends UserUI implements Initializable{
	    ObservableList<UserVO> list = FXCollections.observableArrayList();
        UserBLService service = UserBL.getInstance().getUserService();
	    @FXML
	    protected TextField idField;
	    @FXML
        protected TextField nameField;
	    @FXML
        protected TextField passwordField;
	    @FXML
	    protected TextField findingField;
	    @FXML
        protected ChoiceBox<String> roleChoice;
    	@FXML
    	protected Label idLabel;


		@FXML
		protected TableView<UserVO> table;
		@FXML
		protected TableColumn<UserVO,String> tableID;
		@FXML
		protected TableColumn<UserVO,String> tablePassword;
		@FXML
		protected TableColumn<UserVO,String> tableName;
		@FXML
		protected TableColumn<UserVO,String> tableRole;

		@FXML
		public void insert() throws Exception{
			Stage stage = new Stage();
			new UserInsertUI().start(stage);
		}

		@FXML
		public void delete() throws Exception{
			Stage stage = new Stage();
			new UserDeleteUI().start(stage);
		}

		@FXML
		public void update() throws Exception{
			Stage stage = new Stage();
			new UserUpdateUI().start(stage);
		}

		@FXML
		public void find() throws Exception{
			Stage stage = new Stage();
			new UserFindUI().start(stage);
		}

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			manageInit();
		}

		public void manageInit(){
			tableID.setCellValueFactory(
	                new PropertyValueFactory<UserVO,String>("ID"));
	        tableName.setCellValueFactory(
	                new PropertyValueFactory<UserVO,String>("name"));
	        tablePassword.setCellValueFactory(
	                new PropertyValueFactory<UserVO,String>("password"));
	        tableRole.setCellValueFactory(
	                new PropertyValueFactory<UserVO,String>("roleName"));
            list.addAll(service.getUserList());
	        table.setItems(list);
		}


		@Override
		public void start(Stage primaryStage) throws Exception {
			   changeStage("UserManageUI","UserManagingUI.fxml");
		}


		/**
		 * 自动生成新id
		 * @param id
		 * @return 新id
		 */
		public String addOne(String id){
			int tmp = Integer.parseInt(id);
			int n = id.length();
			tmp++;
			String newID = String.valueOf(tmp);
			while(newID.length()<n)
				newID = "0"+newID;
			return newID;
		}

}
