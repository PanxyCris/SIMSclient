package SIMSclient.src.presentation.financialstaffui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import SIMSclient.src.bussinesslogic.accountbl.AccountController;
import SIMSclient.src.bussinesslogicservice.accountblservice.AccountBLService;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.dataenum.findtype.FindAccountType;
import SIMSclient.src.presentation.common.EditingCell;
import SIMSclient.src.presentation.remindui.RemindExistUI;
import SIMSclient.src.presentation.remindui.RemindPrintUI;
import SIMSclient.src.vo.AccountVO;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class AccountManageUI extends FinancialStaffUI implements Initializable{
	ObservableList<AccountVO> list = FXCollections.observableArrayList();
    AccountBLService service = AccountController.getInstance().getContoller();
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
		String id = idField.getText();
		String name = nameField.getText();
		String money = moneyField.getText();
	        ResultMessage message = service.newBuild(id, name, money);
	        Platform.runLater(new Runnable() {
	    	    public void run() {
	    	        try {
	    	        switch(message){
	    	        case ILLEGALINPUTNAME:new RemindPrintUI().start(message);break;
	    	        case ILLEAGLINPUTDATA:new RemindPrintUI().start(message);break;
	    	        case EXISTED:new RemindExistUI().start(remind,true);break;
	    	        case SUCCESS:table.refresh();cancel();break;
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
		ArrayList<AccountVO> list = service.find(findingField.getText(), FindAccountType.getFindType(findChoice.getValue()));
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
	    	   ObservableList<AccountVO> newList = FXCollections.observableArrayList();
	    	   newList.addAll(list);
	    	   deleteInit();
	    	   table.setItems(newList);
	       }
	}

	@FXML
	public void save(){
		ArrayList<AccountVO> newList = new ArrayList<>();
		newList.addAll(list);
		ResultMessage message = service.saveChange(newList);
			Platform.runLater(new Runnable() {
	    	    public void run() {
	    	        try {
	    	        	switch(message){
	    	        	case ILLEGALINPUTNAME:new RemindPrintUI().start(message);break;
	    	        	case ILLEAGLINPUTDATA:new RemindPrintUI().start(message);break;
	    	        	case SUCCESS:table.refresh();cancel();break;
	    	        	default:break;
	    	        	}

					} catch (Exception e) {
						e.printStackTrace();
					}
	    	    }
	    	});
	}

	@FXML
	public void cancel(){
		idField.setText(null);
		nameField.setText(null);
		moneyField.setText(null);
		findingField.setText(null);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		manageInit();
		edit();
		cancel();
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
        list.addAll(service.getAccountList());
        table.setItems(list);
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
                        Button delBtn = new Button("É¾³ý");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	AccountVO clickedAccount = this.getTableView().getItems().get(this.getIndex());
                            service.delete(clickedAccount.getName());
            		    	table.refresh();
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
