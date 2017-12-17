package presentation.common;


import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;

public class EditingCellDouble<T> extends TableCell<T, Double> {

    private TextField textField;

    public EditingCellDouble() {
    	System.out.println(getString());
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
        setText(String.valueOf((Double) getItem()));
        setGraphic(null);
    }

    @Override
    public void updateItem(Double item, boolean empty) {
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
                    commitEdit(Double.parseDouble(textField.getText()));
                }
        });
    }

    private String getString() {
        return getItem() == null ? "" : getItem().toString();
    }

}
