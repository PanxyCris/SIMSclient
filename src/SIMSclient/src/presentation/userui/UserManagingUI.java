package SIMSclient.src.presentation.userui;

import java.net.URL;

import java.util.ResourceBundle;

import SIMSclient.src.dataenum.UserRole;
import SIMSclient.src.vo.UserVO;
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
	    @FXML
	    protected TextField idField;
	    @FXML
        protected TextField nameField;
	    @FXML
        protected TextField passwordField;
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
		public void update(){
		/*	 UserVO user = new UserVO(idField.getText(), nameField.getText(), passwordField.getText(),roleChoice.getValue());
	         UserBLService service = UserBL.getInstance().getUserService();

	            if(!service.judgeLegal(user)){
	            	Platform.runLater(new Runnable() {
			    	    public void run() {
			    	        try {
								new RemindPrintUI().start(new Stage());
							} catch (Exception e) {
								e.printStackTrace();
							}
			    	    }
			    	});
	            }
	            else if(!service.judgeExist(idField.getText())){
					  Platform.runLater(new Runnable() {
				    	    public void run() {
				    	        try {
									new RemindnotExistUI().start(new Stage());
								} catch (Exception e) {
									e.printStackTrace();
								}
				    	    }
				    	});
				  }
	            else if(service.find(user)){
	            	Platform.runLater(new Runnable() {
			    	    public void run() {
			    	        try {
								new RemindRepeatUI().start(new Stage());
							} catch (Exception e) {
								e.printStackTrace();
							}
			    	    }
			    	});
	            }else{
	            list.remove(service.find(idField.getText(),nameField.getText()));
	            service.update(user);
	            list.add(user);
	            table.setItems(list);
	            }*/
		}

		@FXML
		public void find(){

		}

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			manageInit();
		}

		public void manageInit(){
			UserVO user1 = new UserVO("0000001","李杰","161250058",UserRole.PUR_SALE_MANAGER);
			UserVO user2 =new UserVO("0000002","王灿灿","161250136",UserRole.FINANCIAL_MANAGER);
			tableID.setCellValueFactory(
	                new PropertyValueFactory<UserVO,String>("ID"));
	        tableName.setCellValueFactory(
	                new PropertyValueFactory<UserVO,String>("name"));
	        tablePassword.setCellValueFactory(
	                new PropertyValueFactory<UserVO,String>("password"));
	        tableRole.setCellValueFactory(
	                new PropertyValueFactory<UserVO,String>("roleName"));
	        list.addAll(user1,user2);
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
