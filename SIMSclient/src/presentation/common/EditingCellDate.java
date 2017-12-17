package presentation.common;


import java.time.LocalDate;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;

public class EditingCellDate<T> extends TableCell<T, LocalDate> {

    private DatePicker datePicker;

    public EditingCellDate() {
    }

    @Override
    public void startEdit() {
        if (!isEmpty()) {
            super.startEdit();
            createLocalDate();
            setText(null);
            setGraphic(datePicker);
        }
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        setValue((LocalDate) getItem());
        setGraphic(null);
    }

    @Override
    public void updateItem(LocalDate item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            if (isEditing()) {
                if (datePicker != null) {
                    datePicker.setValue(getLocalDate());
                }
                setValue(null);
                setGraphic(datePicker);
            } else {
                setValue(getLocalDate());
                setGraphic(null);
            }
        }
    }

    private void createLocalDate() {
        datePicker = new DatePicker(getLocalDate());
        datePicker.setMinWidth(this.getWidth() - this.getGraphicTextGap()* 2);
        datePicker.focusedProperty().addListener(
            (ObservableValue<? extends Boolean> arg0,
            Boolean arg1, Boolean arg2) -> {
                if (!arg2) {
                    commitEdit(datePicker.getValue());
                }
        });
    }

    private LocalDate getLocalDate() {
        return getItem() == null ? LocalDate.now() : getItem();
    }

    private void setValue(LocalDate date){
    	datePicker.setValue(date);
    }

}
