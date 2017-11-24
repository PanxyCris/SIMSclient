package SIMSclient.src.presentation.userui;

import java.net.URL;
import java.util.ResourceBundle;
import SIMSclient.src.vo.UserVO;
import SIMSclient.src.vo.UserVO.UserRole;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class UserManagingUI extends UserUI implements Initializable{
	 ObservableList<UserVO> list = FXCollections.observableArrayList();
		@FXML
		private Pagination pagination;
		@FXML
		private TableView<UserVO> table;
		@FXML
		private TableColumn<UserVO,String> tableID;
		@FXML
		private TableColumn<UserVO,String> tableName;
		@FXML
		private TableColumn<UserVO,String> tableRole;

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

		@FXML
		public void confirm(){

		}

		@FXML
		public void cancel(){

		}

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			UserVO user1 = new UserVO("161250058","¿ÓΩ‹","161250058",UserRole.SALESPERSON);
			UserVO user2 =new UserVO("161250136","Õı≤”≤”","161250136",UserRole.FINANCIALSTAFF);
			tableID.setCellValueFactory(
	                new PropertyValueFactory<UserVO,String>("idPro"));
	        tableName.setCellValueFactory(
	                new PropertyValueFactory<UserVO,String>("namePro"));
	        tableRole.setCellValueFactory(
	                new PropertyValueFactory<UserVO,String>("rolePro"));
	        list.addAll(user1,user2);
	        table.setItems(list);

		}

		@Override
		public void start(Stage primaryStage) throws Exception {

			    String currentID = "UserManageUI";
	    		stageController.loadStage(currentID, pack+"UserManagingUI.fxml");
	    		stageController.setStage(currentID,mainID);
	    		previous = current;
	    		current = currentID;
	    		stack.push(currentID);

		}
}
