package SIMSclient.src.presentation.accountui;

import java.net.URL;
import java.util.ResourceBundle;

import SIMSclient.src.bussinesslogic.accountbl.AccountController;
import SIMSclient.src.bussinesslogicservice.accountblservice.AccountBLService;
import SIMSclient.src.vo.AccountVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AccountManageUI extends AccountUI implements Initializable{
	 ObservableList<AccountVO> list = FXCollections.observableArrayList();
	    AccountBLService service = AccountController.getInstance().getAccountService();
        @FXML
	    protected TextField idField;
	    @FXML
        protected TextField nameField;
	    @FXML
        protected TextField passwordField;
	    @FXML
	    protected TextField findingField;
 	   @FXML
 	    protected Label idLabel;


		@FXML
		protected TableView<AccountVO> table;
		@FXML
		protected TableColumn<AccountVO,String> tableName;
		@FXML
		protected TableColumn<AccountVO,Integer> tableMoney;

		@FXML
		public void insert() throws Exception{
			Stage stage = new Stage();
			new AccountInsertUI().start(stage);
		}

		@FXML
		public void delete() throws Exception{
			Stage stage = new Stage();
			new AccountDeleteUI().start(stage);
		}

		@FXML
		public void update() throws Exception{
			Stage stage = new Stage();
			new AccountUpdateUI().start(stage);
		}

		@FXML
		public void find() throws Exception{
			Stage stage = new Stage();
			new AccountFindUI().start(stage);
		}

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			manageInit();
		}

		public void manageInit(){
	        tableName.setCellValueFactory(
	                new PropertyValueFactory<AccountVO,String>("name"));
	        tableMoney.setCellValueFactory(
	                new PropertyValueFactory<AccountVO,Integer>("money"));
         list.addAll(service.getAccountList());
	        table.setItems(list);
		}


		@Override
		public void start(Stage primaryStage) throws Exception {
			   changeStage("AccountManageUI","AccountManageUI.fxml");
		}


}
