package SIMSclient.src.presentation.financialstaffui;

import java.net.URL;


import java.util.ArrayList;
import java.util.ResourceBundle;

import SIMSclient.src.bussinesslogic.accountbl.AccountController;
import SIMSclient.src.bussinesslogic.userbl.UserController;
import SIMSclient.src.bussinesslogicservice.accountblservice.AccountBLService;
import SIMSclient.src.bussinesslogicservice.userblservice.UserBLService;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.dataenum.UserRole;
import SIMSclient.src.presentation.remindui.RemindExistUI;
import SIMSclient.src.presentation.remindui.RemindPrintUI;
import SIMSclient.src.vo.AccountVO;
import SIMSclient.src.vo.UserVO;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
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
    protected ChoiceBox<String> findChoice;


	@FXML
	protected TableView<AccountVO> table;
	@FXML
	protected TableColumn<AccountVO,String> tableName;
	@FXML
	protected TableColumn<AccountVO,String> tableMoney;
	@FXML
	protected TableColumn<AccountVO,String> tableDelete;


	@FXML
	public void insert(){
		String name = nameField.getText();
		String money = moneyField.getText();
	        ResultMessage message = service.newBuild(name, money);
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
		ArrayList<AccountVO> list = service.find(findingField.getText());
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
		for(int i=0;i<list.size();i++){
		ResultMessage message = service.;
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
	}

	@FXML
	public void cancel(){
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

        tableName.setCellValueFactory(
                new PropertyValueFactory<AccountVO,String>("name"));

        tableMoney.setCellValueFactory(
                new PropertyValueFactory<AccountVO,String>("money"));
        deleteInit();
        findChoice.setItems(FXCollections.observableArrayList("Ãû³Æ","½ð¶î"));
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
	
	public class EditingCell<T> extends TableCell<T, String> {

	    private TextField textField;

	    public EditingCell() {
	    }

	    @Override
	    public void startEdit() {
	        if (!isEmpty()) {
	            super.startEdit();
	            createTextField();
	            setText(null);
	            setGraphic(textField);
	            textField.selectAll();
	        }
	    }

	    @Override
	    public void cancelEdit() {
	        super.cancelEdit();

	        setText((String) getItem());
	        setGraphic(null);
	       
	    }

	    @Override
	    public void updateItem(String item, boolean empty) {
	        super.updateItem(item, empty);

	        if (empty) {
	            setText(null);
	            setGraphic(null);
	        } else {
	            if (isEditing()) {
	                if (textField != null) {
	                    textField.setText(getString());
	                }
	                setText(null);
	                setGraphic(textField);
	            } else {
	                setText(getString());
	                setGraphic(null);
	            }
	        }
	    }

	    private void createTextField() {
	        textField = new TextField(getString());
	        textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()* 2);
	        textField.focusedProperty().addListener(
	            (ObservableValue<? extends Boolean> arg0,
	            Boolean arg1, Boolean arg2) -> {
	                if (!arg2) {
	                    commitEdit(textField.getText());
	                }
	        });
	    }

	    private String getString() {
	        return getItem() == null ? "" : getItem().toString();
	    }
	}


}
