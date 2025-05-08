package com.example.finalp;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.util.Optional;

/**
 * Controller for handling user actions in the To-Do List UI.
 */
public class TodoController {

    @FXML
    private TextField itemInput;

    @FXML
    private ListView<String> itemList;

    private final TodoList todoList = new TodoList();


    @FXML
    public void initialize() {
        itemList.setItems(todoList.getItems());
    }

    @FXML
    private void onAddClick() {
        String item = itemInput.getText().trim();
        if (item.isEmpty()) {
            showAlert("Please enter a task before adding.");
        } else {
            todoList.addItem(item);
            itemInput.clear();
        }
    }

    @FXML
    private void onRemoveClick() {
        String selected = itemList.getSelectionModel().getSelectedItem();
        if (selected != null) {
            todoList.removeItem(selected);
        } else {
            showAlert("Please select an item to remove.");
        }
    }

    @FXML
    private void onEditClick() {
        String selected = itemList.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Please select an item to edit.");
            return;
        }

        TextInputDialog dialog = new TextInputDialog(selected);
        dialog.setTitle("Edit Task");
        dialog.setHeaderText("Edit selected task:");
        dialog.setContentText("New value:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(newValue -> {
            if (!newValue.trim().isEmpty()) {
                todoList.editItem(selected, newValue.trim());
            } else {
                showAlert("Task cannot be empty.");
            }
        });
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
