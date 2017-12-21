package presentation.generalmanagerui.controller;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussiness_stub.ReceiptBillBLService_Stub;
import bussinesslogic.accountbillbl.ReceiptBillController;
import bussinesslogic.accountbl.AccountController;
import bussinesslogic.examinebl.ExamineReceiptBL;
import bussinesslogic.memberbl.MemberController;
import bussinesslogicservice.accountbillblservice.ReceiptBillBLService;
import bussinesslogicservice.accountblservice.AccountBLService;
import bussinesslogicservice.examineblservice.ExamineBLService;
import bussinesslogicservice.memberblservice.MemberBLService;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindBillType;
import dataenum.findtype.FindReceiptBillType;
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
import vo.accountvo.AccountVO;
import vo.billvo.financialbillvo.AccountListVO;
import vo.billvo.financialbillvo.ReceiptBillVO;
import vo.membervo.MemberVO;
import vo.uservo.UserVO;

public class ExamineReceiveBillController extends ExamineBillController{

	ExamineBLService<ReceiptBillVO> service = new ExamineReceiptBL();
	ObservableList<ReceiptBillVO> list = FXCollections.observableArrayList();
	ObservableList<AccountListVO> accountVOList = FXCollections.observableArrayList();
	ReceiptBillVO bill;

	@FXML
	ChoiceBox<String> findChoice;
	@FXML
	TextField findingField;


	@FXML
	TableView<ReceiptBillVO> table;
	@FXML
	TableColumn<ReceiptBillVO,String> tableID;
	@FXML
	TableColumn<ReceiptBillVO,String> tableMember;
	@FXML
	TableColumn<ReceiptBillVO,Double> tableSum;
	@FXML
	TableColumn<ReceiptBillVO,String> tableOperator;
	@FXML
	TableColumn<ReceiptBillVO,String> tableRemark;
	@FXML
	TableColumn<ReceiptBillVO,String> tableCheck;
	@FXML
	TableColumn<ReceiptBillVO,CheckBox> tablePass;


	@FXML
	TableView<AccountListVO> accountList;
	@FXML
	TableColumn<AccountListVO,String> tableAccount;
	@FXML
	TableColumn<AccountListVO,String> tableMoney;
	@FXML
	TableColumn<AccountListVO,String> tableDescription;

	@FXML
	public void find(){

		ArrayList<ReceiptBillVO> list = service.find(findingField.getText(),FindBillType.getType(findChoice.getValue()));
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
        ArrayList<ReceiptBillVO> choiceList = new ArrayList<>();
        for(int i=0;i<list.size();i++)
        	if(list.get(i).getBox().isSelected()){
        		choiceList.add(list.get(i));
        		list.remove(i);
        		}
        service.passBills(choiceList);
	}

	@FXML
	public void fail(){
		ArrayList<ReceiptBillVO> choiceList = new ArrayList<>();
        for(int i=0;i<list.size();i++)
        	if(list.get(i).getBox().isSelected()){
        		choiceList.add(list.get(i));
        		list.remove(i);
        		}
        service.notPassBills(choiceList);
	}


	public void initData(UserVO user) throws RemoteException {
		this.user = user;
		list.addAll(service.getCommitedBills());
		table.setItems(list);
		manageInit();
		listInit();
		findChoice.setItems(FXCollections.observableArrayList(FindReceiptBillType.ID.value,FindReceiptBillType.MEMBER.value,
				FindReceiptBillType.ACCOUNT.value,FindReceiptBillType.OPERATOR.value,FindReceiptBillType.TOTAL.value));
	}



	public void manageInit() throws RemoteException{
		tableID.setCellValueFactory(
                new PropertyValueFactory<ReceiptBillVO,String>("id"));
		tableMember.setCellValueFactory(
                new PropertyValueFactory<ReceiptBillVO,String>("customerID"));
		tableSum.setCellValueFactory(
                new PropertyValueFactory<ReceiptBillVO,Double>("total"));
		tableOperator.setCellValueFactory(
                new PropertyValueFactory<ReceiptBillVO,String>("userID"));
		tableRemark.setCellValueFactory(
                new PropertyValueFactory<ReceiptBillVO,String>("note"));
		tablePass.setCellValueFactory(
                new PropertyValueFactory<ReceiptBillVO,CheckBox>("box"));
		checkInit();
		edit();
	}

	public void checkInit(){

		tableCheck.setCellFactory((col) -> {
            TableCell<ReceiptBillVO, String> cell = new TableCell<ReceiptBillVO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);

                    if (!empty) {
                        Button delBtn = new Button("查看转账列表");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	ReceiptBillVO clickedItem = this.getTableView().getItems().get(this.getIndex());
                            accountVOList.clear();
                            accountVOList.addAll(clickedItem.getAccountListVOs());
                            accountList.setItems(accountVOList);
                            bill = clickedItem;

                        });
                    }
                }

            };
            return cell;
        });

	}


	public void edit() throws RemoteException{
		MemberBLService memberService = new MemberController();

		ObservableList<String> memberList = FXCollections.observableArrayList(memberService.getIDandName());

		Callback<TableColumn<ReceiptBillVO, String>,
            TableCell<ReceiptBillVO, String>> cellFactory
                = (TableColumn<ReceiptBillVO, String> p) -> new EditingCell<ReceiptBillVO>();
        Callback<TableColumn<ReceiptBillVO, String>,
            TableCell<ReceiptBillVO, String>> cellFactoryChoice
                = (TableColumn<ReceiptBillVO, String> p) -> new EditingCellChoice<ReceiptBillVO>(memberList);
        Callback<TableColumn<ReceiptBillVO, Double>,
            TableCell<ReceiptBillVO, Double>> cellFactoryDouble
                    = (TableColumn<ReceiptBillVO, Double> p) -> new EditingCellDouble<ReceiptBillVO>();

        tableSum.setCellFactory(cellFactoryDouble);
        tableSum.setOnEditCommit(
             (CellEditEvent<ReceiptBillVO, Double> t) -> {
            	   double tmp = t.getOldValue();
                   ((ReceiptBillVO) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setTotal(t.getNewValue());
                   ReceiptBillVO newVO = ((ReceiptBillVO) t.getTableView().getItems().get(
                            t.getTablePosition().getRow()));
                   if(!update(newVO)){
                       ((ReceiptBillVO)t.getTableView().getItems().get(
                                  t.getTablePosition().getRow())
                                  ).setTotal(tmp);
                   }
            });

        tableMember.setCellFactory(cellFactoryChoice);
        tableMember.setOnEditCommit(
                (CellEditEvent<ReceiptBillVO, String> t) -> {
                	  String tmp = t.getOldValue();
                      ((ReceiptBillVO) t.getTableView().getItems().get(
                               t.getTablePosition().getRow())
                               ).setCustomerID(t.getNewValue());
                      ReceiptBillVO newVO = ((ReceiptBillVO) t.getTableView().getItems().get(
                               t.getTablePosition().getRow()));
                      if(!update(newVO)){
                          ((ReceiptBillVO)t.getTableView().getItems().get(
                                     t.getTablePosition().getRow())
                                     ).setCustomerID(tmp);
                      }
               });


        tableRemark.setCellFactory(cellFactory);
        tableRemark.setOnEditCommit(
            (CellEditEvent<ReceiptBillVO, String> t) -> {
            	  String tmp = t.getOldValue();
                  ((ReceiptBillVO) t.getTableView().getItems().get(
                           t.getTablePosition().getRow())
                           ).setNote(t.getNewValue());
                  ReceiptBillVO newVO = ((ReceiptBillVO) t.getTableView().getItems().get(
                           t.getTablePosition().getRow()));
                  if(!update(newVO)){
                      ((ReceiptBillVO)t.getTableView().getItems().get(
                                 t.getTablePosition().getRow())
                                 ).setNote(tmp);
                  }
        });

        ReceiptBillBLService accountService = new ReceiptBillController();
		ObservableList<String> accountList = FXCollections.observableArrayList();
        accountList.addAll(accountService.getAccountList());

		Callback<TableColumn<AccountListVO, String>,
            TableCell<AccountListVO, String>> cellFactoryAccount
                = (TableColumn<AccountListVO, String> p) -> new EditingCell<AccountListVO>();
        Callback<TableColumn<AccountListVO, String>,
            TableCell<AccountListVO, String>> cellFactoryAccountChoice
                = (TableColumn<AccountListVO, String> p) -> new EditingCellChoice<AccountListVO>(accountList);

        tableAccount.setCellFactory(cellFactoryAccountChoice);
        tableAccount.setOnEditCommit(
             (CellEditEvent<AccountListVO, String> t) -> {
            	 String tmp = t.getOldValue();
    	               ((AccountListVO) t.getTableView().getItems().get(
    	                        t.getTablePosition().getRow())
    	                        ).setAccountID(t.getNewValue());
    	        AccountListVO accountVO = ((AccountListVO) t.getTableView().getItems().get(
   	                        t.getTablePosition().getRow())
   	                        );
    	              accountVOList.set(t.getTablePosition().getRow(),accountVO);
    	              ReceiptBillVO newVO = bill;
    	              ArrayList<AccountListVO> accountListVO = new ArrayList<>();
    	              accountListVO.addAll(accountVOList);
    	              newVO.setAccountListVOs(accountListVO);
    	              if(!update(newVO)){
    	            	  ((AccountListVO) t.getTableView().getItems().get(
      	                        t.getTablePosition().getRow())
      	                        ).setAccountID(tmp);
                      }
            });


        tableDescription.setCellFactory(cellFactoryAccount);
        tableDescription.setOnEditCommit(
            (CellEditEvent<AccountListVO, String> t) -> {
            	 String tmp = t.getOldValue();
	               ((AccountListVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setNote(t.getNewValue());
	        AccountListVO accountVO = ((AccountListVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        );
	              accountVOList.set(t.getTablePosition().getRow(),accountVO);
	              ReceiptBillVO newVO = bill;
	              ArrayList<AccountListVO> accountListVO = new ArrayList<>();
	              accountListVO.addAll(accountVOList);
	              newVO.setAccountListVOs(accountListVO);
	              if(!update(newVO)){
	            	  ((AccountListVO) t.getTableView().getItems().get(
	                        t.getTablePosition().getRow())
	                        ).setNote(tmp);
                }
        });
	}

    public boolean update(ReceiptBillVO vo){
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
		tableAccount.setCellValueFactory(
                new PropertyValueFactory<AccountListVO,String>("accountID"));
        tableMoney.setCellValueFactory(
                new PropertyValueFactory<AccountListVO,String>("money"));
        tableDescription.setCellValueFactory(
                new PropertyValueFactory<AccountListVO,String>("note"));
	}


}
