package presentation.inventorymanagerui.controller;

import java.util.ArrayList;
import java.util.Optional;

import bussiness_stub.ClassificationBLService_Stub;
import bussinesslogic.classificationbl.ClassificationBL;
import bussinesslogicservice.commodityblservice.ClassificationBLService;
import dataenum.Remind;
import dataenum.ResultMessage;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
import javafx.util.Callback;
import po.ClassificationVPO;
import presentation.common.EditingCellTree;
import vo.uservo.UserVO;

public class ClassManageController extends InventoryManagerController{

	ClassificationBLService service = new ClassificationBL();
	public static final Remind remind = Remind.CLASSIFICATION;
	ObservableList<String> classList  = FXCollections.observableArrayList();

	@FXML
	TreeTableView<ClassificationVPO> tree;
	@FXML
	TreeTableColumn<ClassificationVPO,String> treeName;
	@FXML
	TreeTableColumn<ClassificationVPO,String> treeID;
	@FXML
	TreeTableColumn<ClassificationVPO,String> treeType;
	@FXML
	TreeTableColumn<ClassificationVPO,String> treeDelete;

	TreeItem<ClassificationVPO> root;

	@FXML
	TextField nameField;
	@FXML
	Label idLabel;
	@FXML
	ComboBox<String> classChoice;


	@FXML
	public void insert(){
		if(nameField.getText()==null||classChoice.getValue()==null){
			Alert warning = new Alert(Alert.AlertType.WARNING,"请填写好所有信息");
			warning.showAndWait();
		}
		else{
		ClassificationVPO vo = new ClassificationVPO(idLabel.getText(),nameField.getText(),true,
				  service.getClass(classChoice.getValue()),null);
	        ResultMessage message = service.insert(vo);
	        Platform.runLater(new Runnable() {
	    	    public void run() {
	    	        try {
	    	        switch(message){
	    	        case EXISTED:Alert existed = new Alert(Alert.AlertType.WARNING,"该分类已存在");
                                    existed.showAndWait();break;
	    	        case SUCCESS:fresh();break;
	    	        default:Alert error = new Alert(Alert.AlertType.ERROR,message.value);
                    error.showAndWait();break;
	    	        }
					} catch (Exception e) {
						e.printStackTrace();
					}
	    	    }
	    	});
	    }
	}

	public void initInsert(){
		idLabel.setText(service.getID());
		classChoice.setValue(null);
		nameField.setText(null);
	}

	public void initData(UserVO user) throws Exception {
		this.user = user;
        root = new TreeItem<>(service.getRoot());

        addAllChildren(root);
        tree.setRoot(root);
		classList.addAll(service.showName());
		classChoice.setItems(classList);
		initInsert();

		edit();
		manageInit();
	}
	/**
	 * 加入所有子节点
	 * @param item
	 */
	public void addAllChildren(TreeItem<ClassificationVPO> item){
		ArrayList<ClassificationVPO> tmpList = item.getValue().getChildren();
		  if(tmpList!=null){
		     ObservableList<TreeItem<ClassificationVPO>> list = FXCollections.observableArrayList();
		     for(int i=0;i<tmpList.size();i++){
			    TreeItem<ClassificationVPO> tmpItem = new TreeItem<>(tmpList.get(i));
			    list.add(tmpItem);
		     }
		     item.getChildren().addAll(list);

		     for(int i=0;i<item.getChildren().size();i++){
			      addAllChildren(item.getChildren().get(i));
		     }
		 }

	}



	public void edit(){
		Callback<TreeTableColumn<ClassificationVPO, String>,
	        TreeTableCell<ClassificationVPO, String>> cellFactory
	            = (TreeTableColumn<ClassificationVPO, String> p) -> new EditingCellTree<ClassificationVPO>();

	    treeName.setCellFactory(cellFactory);
	    treeName.setOnEditCommit(
	            (CellEditEvent<ClassificationVPO, String> t) -> {
	                ((TreeItem<ClassificationVPO>) t.getTreeTableView().getTreeItem(
	                        t.getTreeTablePosition().getRow())
	                        ).getValue().setName(t.getNewValue());
	                try {
						service.update (((TreeItem<ClassificationVPO>) t.getTreeTableView().getTreeItem(
		                        t.getTreeTablePosition().getRow())
		                        ).getValue());
					} catch ( Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

	        });


	}


	public void manageInit(){
		treeID.setCellValueFactory(
			    (TreeTableColumn.CellDataFeatures<ClassificationVPO, String> param) ->
			    new ReadOnlyStringWrapper(param.getValue().getValue().getId())
			);
	    treeName.setCellValueFactory(
			    (TreeTableColumn.CellDataFeatures<ClassificationVPO, String> param) ->
			    new ReadOnlyStringWrapper(param.getValue().getValue().getName())
			);
	    treeType.setCellValueFactory(
			    (TreeTableColumn.CellDataFeatures<ClassificationVPO, String> param) ->
			    new ReadOnlyStringWrapper(param.getValue().getValue().getType())
			);

        deleteInit();

	}

	public void deleteInit(){
		treeDelete.setCellFactory((col) -> {
            TreeTableCell<ClassificationVPO, String> cell = new TreeTableCell<ClassificationVPO, String>() {

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        Button delBtn = new Button("删除");
                        this.setGraphic(delBtn);
                        delBtn.setOnMouseClicked((me) -> {
                        	ClassificationVPO clickedUser = this.getTreeTableView().getTreeItem(this.getIndex()).getValue();
                            try {
                            	if(clickedUser.getB()==true){
                            		Alert alert = new Alert(AlertType.CONFIRMATION);
	                            	alert.setContentText("确认删除？");
	                            	Optional<ButtonType> result = alert.showAndWait();
	                            	if (result.get() == ButtonType.OK){
	                            		service.delete(clickedUser);
	                            		fresh();
	                            	}
								}
                            	else{
                            		Alert warning = new Alert(Alert.AlertType.WARNING,"请在商品管理界面进行操作");
                            		warning.showAndWait();
                            	}
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                        });
                    }
                }

            };
            return cell;
        });
	}
}
