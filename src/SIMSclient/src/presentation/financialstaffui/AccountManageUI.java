package SIMSclient.src.presentation.financialstaffui;

import java.net.URL;


import java.util.ResourceBundle;

import SIMSclient.src.bussinesslogic.accountbl.AccountController;
import SIMSclient.src.bussinesslogicservice.accountblservice.AccountBLService;
import SIMSclient.src.common.EditingCell;
import SIMSclient.src.vo.AccountVO;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AccountManageUI extends FinancialStaffUI implements Initializable{
	 ObservableList<AccountVO> list = FXCollections.observableArrayList();
	    AccountBLService service = AccountController.getInstance().getContoller();
	    @FXML
        protected TextField nameField;
	    @FXML
        protected TextField moneyField;
	    @FXML
	    protected TextField findingField;


		@FXML
		protected TableView<AccountVO> table;
		@FXML
		protected TableColumn<AccountVO,String> tableName;
		@FXML
		protected TableColumn<AccountVO,String> tableMoney;

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

		@FXML
		public void save(){


	    }

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			manageInit();
		}

		public void manageInit(){
	        tableName.setCellValueFactory(
	                new PropertyValueFactory<AccountVO,String>("name"));
	        tableMoney.setCellValueFactory(
	                new PropertyValueFactory<AccountVO,String>("money"));

	        tableName.setCellFactory(TextFieldTableCell.forTableColumn());
	        tableMoney.setCellFactory(TextFieldTableCell.forTableColumn());
            edit();
	        list.addAll(service.getAccountList());
	        table.setItems(list);
		}



		public void edit(){
			Callback<TableColumn<AccountVO, String>,
	            TableCell<AccountVO, String>> cellFactory
	                = (TableColumn<AccountVO, String> p) -> new EditingCell<AccountVO>();

	        tableName.setCellFactory(cellFactory);
	        tableName.setOnEditCommit(
	            (CellEditEvent<AccountVO, String> t) -> {
	                ((AccountVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setName(t.getNewValue());
	        });

	        tableMoney.setCellFactory(cellFactory);
	        tableMoney.setOnEditCommit(
	            (CellEditEvent<AccountVO, String> t) -> {
	                ((AccountVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setMoney(t.getNewValue());
	        });
		}

		@Override
		public void start(Stage primaryStage) throws Exception {
			   changeStage("AccountManageUI","AccountManageUI.fxml");
		}


}
