package presentation.generalmanagerui.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import bussinesslogic.accountbillbl.PaymentBillController;
import bussinesslogic.examinebl.ExaminePaymentBL;
import bussinesslogicservice.accountbillblservice.PaymentBillBLService;
import bussinesslogicservice.examineblservice.ExamineBLService;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountBillType;
import dataenum.findtype.FindBillType;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import presentation.common.EditingCell;
import presentation.common.EditingCellChoice;
import presentation.common.EditingCellDouble;
import presentation.remindui.RemindPrintUI;
import vo.billvo.financialbillvo.EntryVO;
import vo.billvo.financialbillvo.PaymentBillVO;
import vo.uservo.UserVO;

public class ExaminePaymentBillController extends ExamineBillController{

	ExamineBLService<PaymentBillVO> service = new ExaminePaymentBL();
	ObservableList<PaymentBillVO> list = FXCollections.observableArrayList();
	ObservableList<EntryVO> entryList = FXCollections.observableArrayList();
	PaymentBillVO bill;

	@FXML
	ChoiceBox<String> findChoice;
	@FXML
	TextField findingField;

	@FXML
	TableView<PaymentBillVO> table;
	@FXML
	TableColumn<PaymentBillVO,String> tableID;
	@FXML
	TableColumn<PaymentBillVO,String> tableAccount;
	@FXML
	TableColumn<PaymentBillVO,Double> tableSum;
	@FXML
	TableColumn<PaymentBillVO,String> tableOperator;
	@FXML
	TableColumn<PaymentBillVO,String> tableRemark;
	@FXML
	TableColumn<PaymentBillVO,String> tableCheck;
	@FXML
	TableColumn<PaymentBillVO,CheckBox> tablePass;


	@FXML
	TableView<EntryVO> itemList;
	@FXML
	TableColumn<EntryVO,String> tableItem;
	@FXML
	TableColumn<EntryVO,Double> tableMoney;
	@FXML
	TableColumn<EntryVO,String> tableNote;

	@FXML
	public void find(){

		ArrayList<PaymentBillVO> list = service.find(findingField.getText(),FindBillType.getType(findChoice.getValue()));
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
	public void success(){
        ArrayList<PaymentBillVO> choiceList = new ArrayList<>();
        for(int i=0;i<list.size();i++)
        	if(list.get(i).getBox().isSelected()){
        		choiceList.add(list.get(i));
        		list.remove(i);
        		}
        service.passBills(choiceList);
	}

	@FXML
	public void fail(){
		ArrayList<PaymentBillVO> choiceList = new ArrayList<>();
        for(int i=0;i<list.size();i++)
        	if(list.get(i).getBox().isSelected()){
        		choiceList.add(list.get(i));
        		list.remove(i);
        		}
        service.notPassBills(choiceList);
	}


	public void initData(UserVO user,BillType type) throws RemoteException {
		this.user = user;
		this.billType = type;
		receiptChoice.setValue(type.value);
		list.addAll(service.getCommitedBills());
		table.setItems(list);
		edit();
		manageInit();
		listInit();
		findChoice.setItems(FXCollections.observableArrayList(FindAccountBillType.BILLID.value,FindAccountBillType.CUSTOMER.value,
				FindAccountBillType.OPERATOR.value));

	}

	public void manageInit(){
		tableID.setCellValueFactory(
                new PropertyValueFactory<PaymentBillVO,String>("id"));
		tableAccount.setCellValueFactory(
                new PropertyValueFactory<PaymentBillVO,String>("accountID"));
		tableSum.setCellValueFactory(
                new PropertyValueFactory<PaymentBillVO,Double>("total"));
		tableOperator.setCellValueFactory(
                new PropertyValueFactory<PaymentBillVO,String>("userID"));
		tableRemark.setCellValueFactory(
                new PropertyValueFactory<PaymentBillVO,String>("note"));
		tablePass.setCellValueFactory(
                new PropertyValueFactory<PaymentBillVO,CheckBox>("box"));
		checkInit();
	}

	public void checkInit(){

		tableCheck.setCellFactory((col) -> {
            TableCell<PaymentBillVO, String> cell = new TableCell<PaymentBillVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        Button delBtn = new Button("查看商品列表");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	PaymentBillVO clickedItem = this.getTableView().getItems().get(this.getIndex());
                            entryList.clear();
                            entryList.addAll(clickedItem.getEntryListVO());
                            itemList.setItems(entryList);

                        });
                    }
                }

            };
            return cell;
        });

	}

	public void edit() throws RemoteException{
		PaymentBillBLService accountService = new PaymentBillController();

		ObservableList<String> accountList = FXCollections.observableArrayList(accountService.getAccountList());

		Callback<TableColumn<PaymentBillVO, String>,
            TableCell<PaymentBillVO, String>> cellFactory
                = (TableColumn<PaymentBillVO, String> p) -> new EditingCell<PaymentBillVO>();
        Callback<TableColumn<PaymentBillVO, String>,
            TableCell<PaymentBillVO, String>> cellFactoryChoice
                = (TableColumn<PaymentBillVO, String> p) -> new EditingCellChoice<PaymentBillVO>(accountList);
        Callback<TableColumn<PaymentBillVO, Double>,
            TableCell<PaymentBillVO, Double>> cellFactoryDouble
                    = (TableColumn<PaymentBillVO, Double> p) -> new EditingCellDouble<PaymentBillVO>();

        tableSum.setCellFactory(cellFactoryDouble);
        tableSum.setOnEditCommit(
             (CellEditEvent<PaymentBillVO, Double> t) -> {
            	   double tmp = t.getOldValue();
                   ((PaymentBillVO) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setTotal(t.getNewValue());
                   PaymentBillVO newVO = ((PaymentBillVO) t.getTableView().getItems().get(
                            t.getTablePosition().getRow()));
                   if(!update(newVO)){
                       ((PaymentBillVO)t.getTableView().getItems().get(
                                  t.getTablePosition().getRow())
                                  ).setTotal(tmp);
                   }
            });

        tableAccount.setCellFactory(cellFactoryChoice);
        tableAccount.setOnEditCommit(
                (CellEditEvent<PaymentBillVO, String> t) -> {
                	  String tmp = t.getOldValue();
                      ((PaymentBillVO) t.getTableView().getItems().get(
                               t.getTablePosition().getRow())
                               ).setAccountID(t.getNewValue());
                      PaymentBillVO newVO = ((PaymentBillVO) t.getTableView().getItems().get(
                               t.getTablePosition().getRow()));
                      if(!update(newVO)){
                          ((PaymentBillVO)t.getTableView().getItems().get(
                                     t.getTablePosition().getRow())
                                     ).setAccountID(tmp);
                      }
               });


        tableRemark.setCellFactory(cellFactory);
        tableRemark.setOnEditCommit(
            (CellEditEvent<PaymentBillVO, String> t) -> {
            	  String tmp = t.getOldValue();
                  ((PaymentBillVO) t.getTableView().getItems().get(
                           t.getTablePosition().getRow())
                           ).setNote(t.getNewValue());
                  PaymentBillVO newVO = ((PaymentBillVO) t.getTableView().getItems().get(
                           t.getTablePosition().getRow()));
                  if(!update(newVO)){
                      ((PaymentBillVO)t.getTableView().getItems().get(
                                 t.getTablePosition().getRow())
                                 ).setNote(tmp);
                  }
        });

		Callback<TableColumn<EntryVO, String>,
            TableCell<EntryVO, String>> cellFactoryItem
                = (TableColumn<EntryVO, String> p) -> new EditingCell<EntryVO>();




                tableNote.setCellFactory(cellFactoryItem);
                tableNote.setOnEditCommit(
                    (CellEditEvent<EntryVO, String> t) -> {
        	               ((EntryVO) t.getTableView().getItems().get(
        	                        t.getTablePosition().getRow())
        	                        ).setNote(t.getNewValue());
                });

        tableItem.setCellFactory(cellFactoryItem);
        tableItem.setOnEditCommit(
             (CellEditEvent<EntryVO, String> t) -> {
            	 String tmp = t.getOldValue();
    	               ((EntryVO) t.getTableView().getItems().get(
    	                        t.getTablePosition().getRow())
    	                        ).setEntryName(t.getNewValue());
    	               EntryVO accountVO = ((EntryVO) t.getTableView().getItems().get(
   	                        t.getTablePosition().getRow())
   	                        );
    	              entryList.set(t.getTablePosition().getRow(),accountVO);
    	              PaymentBillVO newVO = bill;
    	              ArrayList<EntryVO> entryVO = new ArrayList<>();
    	              entryVO.addAll(entryList);
    	              newVO.setEntryListVO(entryVO);
    	              if(!update(newVO)){
    	            	  ((EntryVO) t.getTableView().getItems().get(
      	                        t.getTablePosition().getRow())
      	                        ).setEntryName(tmp);
                      }
            });


        tableNote.setCellFactory(cellFactoryItem);
        tableNote.setOnEditCommit(
            (CellEditEvent<EntryVO, String> t) -> {
            	 String tmp = t.getOldValue();
	               ((EntryVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setNote(t.getNewValue());
	               EntryVO accountVO = ((EntryVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        );
	              entryList.set(t.getTablePosition().getRow(),accountVO);
	              PaymentBillVO newVO = bill;
	              ArrayList<EntryVO> accountListVO = new ArrayList<>();
	              accountListVO.addAll(entryList);
	              newVO.setEntryListVO(accountListVO);
	              if(!update(newVO)){
	            	  ((EntryVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setNote(tmp);
                }
        });
	}

    public boolean update(PaymentBillVO vo){
        ResultMessage message = service.updateBill(vo);
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


	public void listInit(){
		tableItem.setCellValueFactory(
                new PropertyValueFactory<EntryVO,String>("entryName"));
        tableMoney.setCellValueFactory(
                new PropertyValueFactory<EntryVO,Double>("transferAmount"));
        tableNote.setCellValueFactory(
                new PropertyValueFactory<EntryVO,String>("note"));
	}


}
