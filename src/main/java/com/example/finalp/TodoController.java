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

    /**
     * Initializes the controller by setting the item list.
     */
    @FXML
    public void initialize() {
        itemList.setItems(todoList.getItems());
    }

    /**
     * Handles the add item action when the "Add" button is clicked.
     * It retrieves the text from the input field, checks if it is empty,
     * and adds it to the todo list.
     */
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

    /**
     * Handles the remove item action when the "Remove" button is clicked.
     * It removes the selected item from the todo list if an item is selected.
     */
    @FXML
    private void onRemoveClick() {
        String selected = itemList.getSelectionModel().getSelectedItem();
        if (selected != null) {
            todoList.removeItem(selected);
        } else {
            showAlert("Please select an item to remove.");
        }
    }

    /**
     * Handles the edit item action when the "Edit" button is clicked.
     * It allows the user to input a new value for the selected task.
     * If the task is empty, it shows an alert.
     */
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

    /**
     * Displays an alert with a warning message.
     * @param message The message to display in the alert.
     */
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
