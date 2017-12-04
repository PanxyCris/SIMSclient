package SIMSclient.src.presentation.usermanagerui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import SIMSclient.src.bussinesslogic.userbl.UserController;
import SIMSclient.src.bussinesslogicservice.userblservice.UserBLService;
import SIMSclient.src.presentation.common.EditingCell;
import SIMSclient.src.dataenum.ResultMessage;
import SIMSclient.src.dataenum.UserRole;
import SIMSclient.src.presentation.remindui.RemindExistUI;
import SIMSclient.src.presentation.remindui.RemindPrintUI;
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

public class UserManagingUI extends UserManagerUI implements Initializable{
	    ObservableList<UserVO> list = FXCollections.observableArrayList();
	    ObservableList<String> roleList = FXCollections.observableArrayList(UserRole.GENERAL_MANAGER.value,
                UserRole.FINANCIAL_MANAGER.value,
                UserRole.INVENTORY_MANAGER.value,
                UserRole.PUR_SALE_MANAGER.value,
                UserRole.USER_MANAGER.value);
	    UserBLService service = UserController.getInstance().getUserService();
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
	    protected ChoiceBox<String> findChoice;
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
		protected TableColumn<UserVO,String> tableDelete;


		@FXML
		public void insert(){
			 UserVO vo = new UserVO(idLabel.getText(), nameField.getText(), passwordField.getText(),UserRole.getRole(roleChoice.getValue()));
		        ResultMessage message = service.insert(vo);
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
			ArrayList<UserVO> list = service.find(findingField.getText(),findChoice.getValue());
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
		    	   ObservableList<UserVO> newList = FXCollections.observableArrayList();
		    	   newList.addAll(list);
		    	   deleteInit();
		    	   table.setItems(newList);
		       }
		}

		@FXML
		public void save(){
			for(int i=0;i<list.size();i++){
			ResultMessage message = service.update(list.get(i));
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
			nameField.setText("admin");
			passwordField.setText("admin");
			if(!list.isEmpty()){
		       String initID = addOne(list.get(list.size()-1).getID());
	           idLabel.setText(initID);
	        }else{
	           idLabel.setText("0000001");
	        }
			findingField.setText(null);
		}

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			manageInit();
			edit();
			cancel();
		}

		public void edit(){
			Callback<TableColumn<UserVO, String>,
	            TableCell<UserVO, String>> cellFactory
	                = (TableColumn<UserVO, String> p) -> new EditingCell<UserVO>();

	        tableName.setCellFactory(cellFactory);
	        tableName.setOnEditCommit(
	            (CellEditEvent<UserVO, String> t) -> {
	                ((UserVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setName(t.getNewValue());
	        });

	        tablePassword.setCellFactory(cellFactory);
	        tablePassword.setOnEditCommit(
	            (CellEditEvent<UserVO, String> t) -> {
	                ((UserVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setName(t.getNewValue());
	        });

	        tableRole.setCellFactory(cellFactory);
	        tableRole.setOnEditCommit(
	            (CellEditEvent<UserVO, String> t) -> {
	                ((UserVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setName(t.getNewValue());
	        });


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
	        deleteInit();
	        findChoice.setItems(FXCollections.observableArrayList("ID","用户名","职务"));
            list.addAll(service.getUserList());
            roleChoice.setItems(roleList);
	        table.setItems(list);
		}

		public void deleteInit(){
			tableDelete.setCellFactory((col) -> {
	            TableCell<UserVO, String> cell = new TableCell<UserVO, String>() {

	                @Override
	                public void updateItem(String item, boolean empty) {
	                    super.updateItem(item, empty);
	                    this.setText(null);
	                    this.setGraphic(null);

	                    if (!empty) {
	                        Button delBtn = new Button("删除");
	                        this.setGraphic(delBtn);
	                        delBtn.setOnMouseClicked((me) -> {
	                            UserVO clickedUser = this.getTableView().getItems().get(this.getIndex());
	                            service.delete(clickedUser);
	            		    	table.refresh();
	                        });
	                    }
	                }

	            };
	            return cell;
	        });
		}



		public void start() throws Exception {
			   changeStage("UserManagingUI","UserManagingUI.fxml");
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
