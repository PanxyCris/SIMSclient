package presentation.inventorymanagerui.controller;

import java.util.ArrayList;
import java.util.Optional;

import bussinesslogic.classificationbl.ClassificationController;
import bussinesslogicservice.commodityblservice.ClassificationBLService;
import dataenum.ResultMessage;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
import javafx.scene.control.TreeTableView;
import javafx.util.Callback;
import po.ClassificationVPO;
import presentation.common.EditingCellTree;
import vo.uservo.UserVO;

public class ClassManageController extends InventoryManagerController {

	ClassificationBLService service = new ClassificationController();
	ObservableList<String> classList = FXCollections.observableArrayList();

	@FXML
	TreeTableView<ClassificationVPO> tree;
	@FXML
	TreeTableColumn<ClassificationVPO, String> treeName;
	@FXML
	TreeTableColumn<ClassificationVPO, String> treeID;
	@FXML
	TreeTableColumn<ClassificationVPO, String> treeType;
	@FXML
	TreeTableColumn<ClassificationVPO, String> treeDelete;

	TreeItem<ClassificationVPO> root;

	@FXML
	TextField nameField;
	@FXML
	Label idLabel;
	@FXML
	ComboBox<String> classChoice;

	@FXML
	public void insert() throws Exception {
		if (nameField.getText() == null || classChoice.getValue() == null) {// ����Ϣ�ж�
			Alert warning = new Alert(Alert.AlertType.WARNING, "����д��������Ϣ");
			warning.showAndWait();
		} else {
			ClassificationVPO vo = new ClassificationVPO(idLabel.getText(), nameField.getText(), true,
					classChoice.getValue(), null, null);
			ResultMessage message = service.insert(vo);

			switch (message) {
			case EXISTED:
				Alert existed = new Alert(Alert.AlertType.WARNING, "�÷����Ѵ���");
				existed.showAndWait();
				break;
			case SUCCESS:
				initData(user);
				break;
			default:
				Alert error = new Alert(Alert.AlertType.ERROR, message.value);
				error.showAndWait();
				break;
			}
		}

	}

	/**
	 * ���ӷ����ĳ�ʼ��
	 */

	public void initInsert() {
		idLabel.setText(service.getID());
		classChoice.setValue(null);
		nameField.setText(null);
	}

	public void initData(UserVO user) throws Exception {
		this.user = user;
		root = new TreeItem<>(service.getRoot());
		judgeMessage();
		addAllChildren(root);
		tree.setRoot(root);
		classList.clear();
		classList.addAll(service.showName());
		classChoice.setItems(classList);
		initInsert();
		edit();
		manageInit();

	}

	/**
	 * ���������ӽڵ�
	 *
	 * @param item
	 *            �ӽڵ�
	 */
	public void addAllChildren(TreeItem<ClassificationVPO> item) {
		if (item.getValue() != null) {
			item.setExpanded(true);
			ArrayList<ClassificationVPO> tmpList = item.getValue().getChildren();
			if (tmpList != null) {
				ObservableList<TreeItem<ClassificationVPO>> list = FXCollections.observableArrayList();
				for (int i = 0; i < tmpList.size(); i++) {
					TreeItem<ClassificationVPO> tmpItem = new TreeItem<>(tmpList.get(i));
					list.add(tmpItem);
				}
				item.getChildren().addAll(list);

				for (int i = 0; i < item.getChildren().size(); i++) {
					addAllChildren(item.getChildren().get(i));
				}
			}
		}
	}

	/**
	 * �ڵ����ƿɱ༭
	 */

	public void edit() {
		Callback<TreeTableColumn<ClassificationVPO, String>, TreeTableCell<ClassificationVPO, String>> cellFactory = (
				TreeTableColumn<ClassificationVPO, String> p) -> new EditingCellTree<ClassificationVPO>();

		treeName.setCellFactory(cellFactory);
		treeName.setOnEditCommit((CellEditEvent<ClassificationVPO, String> t) -> {
			if (((TreeItem<ClassificationVPO>) t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()))
					.getValue().getB()) {
				((TreeItem<ClassificationVPO>) t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()))
						.getValue().setName(t.getNewValue());
				try {
					ClassificationVPO vpo = ((TreeItem<ClassificationVPO>) t.getTreeTableView()
							.getTreeItem(t.getTreeTablePosition().getRow())).getValue();
					vpo.setName(t.getNewValue());
					ResultMessage message = service.update(vpo);
					if (message == ResultMessage.SUCCESS)
						initData(user);
					else
						printWrong(message);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}

	public void manageInit() {
		treeID.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<ClassificationVPO, String> param) -> new ReadOnlyStringWrapper(
						param.getValue().getValue().getId()));
		treeName.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<ClassificationVPO, String> param) -> new ReadOnlyStringWrapper(
						param.getValue().getValue().getName()));
		treeType.setCellValueFactory(
				(TreeTableColumn.CellDataFeatures<ClassificationVPO, String> param) -> new ReadOnlyStringWrapper(
						param.getValue().getValue().getType()));

		deleteInit();

	}

	public void deleteInit() {
		treeDelete.setCellFactory((col) -> {
			TreeTableCell<ClassificationVPO, String> cell = new TreeTableCell<ClassificationVPO, String>() {

				@Override
				public void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					this.setText(null);
					this.setGraphic(null);
					if (!empty && (this.getTreeTableView().getTreeItem(this.getIndex())).getValue().getB()
							&& (this.getTreeTableView().getTreeItem(this.getIndex())).getValue().getFather() != null
							&& (this.getTreeTableView().getTreeItem(this.getIndex())).getValue()
									.getChildrenPointer() == null) { // �շ����Ҳ�Ϊ���ڵ㷽���ṩɾ����ť
						Button delBtn = new Button("ɾ��");
						this.setGraphic(delBtn);
						delBtn.setOnMouseClicked((me) -> {
							ClassificationVPO clickedUser = this.getTreeTableView().getTreeItem(this.getIndex())
									.getValue();
							try {
								if (clickedUser.getB()) {
									Alert alert = new Alert(AlertType.CONFIRMATION);
									alert.setContentText("ȷ��ɾ����");
									Optional<ButtonType> result = alert.showAndWait();
									if (result.get() == ButtonType.OK) {
										service.delete(clickedUser);
										initData(user);
									}
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
