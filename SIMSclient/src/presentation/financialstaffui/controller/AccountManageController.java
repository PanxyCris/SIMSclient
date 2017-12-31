package presentation.financialstaffui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussinesslogic.accountbl.AccountController;
import bussinesslogicservice.accountblservice.AccountBLService;
import dataenum.Remind;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountType;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import presentation.common.EditingCell;
import vo.accountvo.AccountVO;
import vo.uservo.UserVO;

public class AccountManageController extends FinancialStaffController implements Initializable{

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
        protected TableColumn<AccountVO,Double> tableMoney;
        @FXML
        protected TableColumn<AccountVO,String> tableDelete;


        @FXML
        public void insert(){
             AccountVO vo = new AccountVO(idField.getText(), nameField.getText(), Double.parseDouble(moneyField.getText()));
                ResultMessage message = service.add(vo);
                Platform.runLater(new Runnable() {
                    public void run() {
                        try {
                        switch(message){
                        case EXISTED: Alert existed = new Alert(Alert.AlertType.WARNING,"���˻��Ѵ���");
                                      existed.showAndWait();break;
                        case SUCCESS:list.add(vo);table.setItems(list);initInsert();break;
                        default: Alert error = new Alert(Alert.AlertType.ERROR,message.value);
                        error.showAndWait();break;
                        }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
        }


        @FXML
        public void find(){
            ArrayList<AccountVO> accountList = service.find(findingField.getText(),FindAccountType.getFindType(findChoice.getValue()));
               if(accountList==null){
            	   Alert error = new Alert(Alert.AlertType.WARNING,ResultMessage.NOTFOUND.value);
                   error.showAndWait();
               }
               else{
                   list.clear();
                   list.addAll(accountList);
                   table.setItems(list);
                   initFind();
               }
        }

        public void initFind(){
        	  findingField.setText(null);
        	  findChoice.setValue(null);
        }

        public void initInsert(){
        	idField.setText(null);
            nameField.setText(null);
            moneyField.setText(null);
        }

        @Override
        public void initialize(URL location, ResourceBundle resources) {
        	list.clear();
            list.addAll(service.getAccountList());
            table.setItems(list);
            initFind();
            initInsert();
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
                   if(!update(newVO)){
                       ((AccountVO)t.getTableView().getItems().get(
                                  t.getTablePosition().getRow())
                                  ).setName(tmp);
                   }

            });


        }

        public boolean update(AccountVO vo){
             ResultMessage message = service.judgeLegal(vo);
             Boolean result = message == ResultMessage.SUCCESS?true:false;
                Platform.runLater(new Runnable() {
                    public void run() {
                        try {
                        switch(message){
                        case SUCCESS:break;
                        default: Alert error = new Alert(Alert.AlertType.ERROR,message.value);
                                       error.showAndWait();break;
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
                    new PropertyValueFactory<AccountVO,Double>("money"));
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
                                service.delete(clickedAccount);
                                list.remove(clickedAccount);
                                table.setItems(list);
                            });
                        }
                    }

                };
                return cell;
            });
        }

        public void initData(UserVO user) throws Exception {
               this.user = user;
        }


}
