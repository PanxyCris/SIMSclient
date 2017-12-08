package SIMSclient.src.presentation.financialstaffui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import SIMSclient.src.bussinesslogic.accountbl.AccountController;
import SIMSclient.src.bussinesslogic.userbl.UserController;
import SIMSclient.src.bussinesslogicservice.accountblservice.AccountBLService;
import SIMSclient.src.bussinesslogicservice.userblservice.UserBLService;
import SIMSclient.src.presentation.common.EditingCell;
import SIMSclient.src.presentation.common.EditingCellChoice;
import SIMSclient.src.dataenum.Remind;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.dataenum.UserRole;
import SIMSclient.src.dataenum.findtype.FindAccountType;
import SIMSclient.src.dataenum.findtype.FindUserType;
import SIMSclient.src.presentation.remindui.RemindExistUI;
import SIMSclient.src.presentation.remindui.RemindPrintUI;
import SIMSclient.src.vo.AccountVO;
import SIMSclient.src.vo.UserVO;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class AccountManageUI extends FinancialStaffUI implements Initializable{
	    AccountBLService service = new AccountController();
		public static final Remind remind = Remind.ACCOUNT;
	    ObservableList<AccountVO> list = FXCollections.observableArrayList();
	    @FXML
	    protected TextField idField;
	    @FXML
        protected TextField nameField;
	    @FXML
        protected TextField moneyField;
	    @FXML
	    protected TextField findingField;
	    @FXML
	    protected ChoiceBox<String> findChoice;


		@FXML
		protected TableView<AccountVO> table;
		@FXML
		protected TableColumn<AccountVO,String> tableID;
		@FXML
		protected TableColumn<AccountVO,String> tableName;
		@FXML
		protected TableColumn<AccountVO,String> tableMoney;
		@FXML
		protected TableColumn<AccountVO,String> tableDelete;


		@FXML
		public void insert(){
			 AccountVO vo = new AccountVO(idField.getText(), nameField.getText(), moneyField.getText());
		        ResultMessage message = service.newBuild(idField.getText(), nameField.getText(), moneyField.getText());
		        Platform.runLater(new Runnable() {
		    	    public void run() {
		    	        try {
		    	        switch(message){
		    	        case ILLEGALINPUTNAME:new RemindPrintUI().start(message);break;
		    	        case ILLEAGLINPUTDATA:new RemindPrintUI().start(message);break;
		    	        case EXISTED:new RemindExistUI().start(remind,true);break;
		    	        case SUCCESS:list.add(vo);table.setItems(list);break;
		    	        default:break;
		    	        }
						} catch (Exception e) {
							e.printStackTrace();
						}
		    	    }
		    	});
		}


		@FXML
		public void find(){
			ArrayList<AccountVO> list = service.find(findingField.getText(),FindAccountType.getFindType(findChoice.getValue()));
		       if(list==null){
		    	   Platform.runLater(new Runnable() {
			    	    public void run() {
			    	        try {
			    	        	new RemindPrintUI().start(ResultMessage.ILLEAGLINPUTDATA);
							} catch (Exception e) {
								e.printStackTrace();
							}
			    	    }
			    	});
		       }
		       else{
		    	   table.getItems().clear();
		    	   table.getItems().addAll(list);
		       }
		}

		@FXML
		public void fresh(){
			findingField.setText(null);
			list.clear();
			list.addAll(service.getAccountList());
			table.setItems(list);
			idField.setText(null);
			nameField.setText(null);
		}

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			fresh();
			edit();
			manageInit();

		}

		public void edit(){
			Callback<TableColumn<AccountVO, String>,
	            TableCell<AccountVO, String>> cellFactory
	                = (TableColumn<AccountVO, String> p) -> new EditingCell<AccountVO>();

	        tableName.setCellFactory(cellFactory);
	        tableName.setOnEditCommit(
	            (CellEditEvent<AccountVO, String> t) -> {
	            	String tmp = t.getOldValue();
	               ((AccountVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setName(t.getNewValue());
	               AccountVO newVO = ((AccountVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow()));
	               if(update(newVO)){
	                   ((AccountVO)t.getTableView().getItems().get(
	  	                        t.getTablePosition().getRow())
	  	                        ).setName(tmp);
	               }

	        });

	        tableID.setCellFactory(cellFactory);
	        tableID.setOnEditCommit(
	            (CellEditEvent<AccountVO, String> t) -> {
	            	String tmp = t.getOldValue();
		               ((AccountVO) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setId(t.getNewValue());
		               AccountVO newVO = ((AccountVO) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow()));
		               if(!update(newVO))
		                	  (t.getTableView().getItems().get(
		  	                        t.getTablePosition().getRow())
		  	                        ).setId(tmp);
	        });

	        tableMoney.setCellFactory(cellFactory);
	        tableMoney.setOnEditCommit(
	            (CellEditEvent<AccountVO, String> t) -> {
	            	String tmp = t.getOldValue();
		               ((AccountVO) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow())
		                        ).setMoney(t.getNewValue());
		               AccountVO newVO = ((AccountVO) t.getTableView().getItems().get(
		                        t.getTablePosition().getRow()));
		               if(!update(newVO))
		                	  (t.getTableView().getItems().get(
		  	                        t.getTablePosition().getRow())
		  	                        ).setMoney(tmp);
	        });



		}

		public boolean update(AccountVO vo){
			 ResultMessage message = service.;
			 Boolean result = message == ResultMessage.SUCCESS?true:false;
		        Platform.runLater(new Runnable() {
		    	    public void run() {
		    	        try {
		    	        switch(message){
		    	        case ILLEGALINPUTNAME:new RemindPrintUI().start(message);break;
		    	        case ILLEAGLINPUTDATA:new RemindPrintUI().start(message);break;
		    	        case SUCCESS:break;
		    	        default:break;
		    	        }
						} catch (Exception e) {
							e.printStackTrace();
						}
		    	    }
		    	});
		     return result;
		}

		public void manageInit(){
			tableID.setCellValueFactory(
	                new PropertyValueFactory<AccountVO,String>("id"));
	        tableName.setCellValueFactory(
	                new PropertyValueFactory<AccountVO,String>("name"));
	        tableMoney.setCellValueFactory(
	                new PropertyValueFactory<AccountVO,String>("money"));
	        deleteInit();
	        findChoice.setItems(FXCollections.observableArrayList(FindAccountType.ID.value,FindAccountType.NAME.value));
		}

		public void deleteInit(){
			tableDelete.setCellFactory((col) -> {
	            TableCell<AccountVO, String> cell = new TableCell<AccountVO, String>() {

	                @Override
	                public void updateItem(String item, boolean empty) {
	                    super.updateItem(item, empty);
	                    this.setText(null);
	                    this.setGraphic(null);

	                    if (!empty) {
	                        Button delBtn = new Button("ɾ��");
	                        this.setGraphic(delBtn);
	                        delBtn.setOnMouseClicked((me) -> {
	                        	AccountVO clickedAccount = this.getTableView().getItems().get(this.getIndex());
	                            service.;
	                            list.remove(clickedAccount);
	                            table.setItems(list);
	                        });
	                    }
	                }

	            };
	            return cell;
	        });
		}

		public void start() throws Exception {
			   changeStage("AccountManageUI","AccountManageUI.fxml");
		}

}
