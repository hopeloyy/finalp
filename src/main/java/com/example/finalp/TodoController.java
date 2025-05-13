package com.example.finalp;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.Optional;

/**
 * Final Project: To Do List Application
 * Launches a To Do List, to add, edit, or remove items. Displays and updated list
 * TodoController.java handles user interactions from the GUI (buttons, list selection, input field)
 * @author Hope Loy
 * @since 05/13/2025
 /*
 *
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
     * Uses exception handling to prevent crashes from unexpected errors.
     */
    @FXML
    private void onAddClick() {
        try {
            String item = itemInput.getText().trim();
            if (item.isEmpty()) {
                throw new IllegalArgumentException("Please enter a task before adding.");
            }
            todoList.addItem(item);
            itemInput.clear();
        } catch (Exception e) {
            showAlert(e.getMessage());
        }
    }

    /**
     * Handles the remove item action when the "Remove" button is clicked.
     * Uses exception handling to catch null selections.
     */
    @FXML
    private void onRemoveClick() {
        try {
            String selected = itemList.getSelectionModel().getSelectedItem();
            if (selected == null) {
                throw new IllegalArgumentException("Please select an item to remove.");
            }
            todoList.removeItem(selected);
        } catch (Exception e) {
            showAlert(e.getMessage());
        }
    }

    /**
     * Handles the edit item action when the "Edit" button is clicked.
     * Uses exception handling to manage empty or null edits.
     */
    @FXML
    private void onEditClick() {
        try {
            String selected = itemList.getSelectionModel().getSelectedItem();
            if (selected == null) {
                throw new IllegalArgumentException("Please select an item to edit.");
            }

            TextInputDialog dialog = new TextInputDialog(selected);
            dialog.setTitle("Edit Task");
            dialog.setHeaderText("Edit selected task:");
            dialog.setContentText("New value:");

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(newValue -> {
                try {
                    if (newValue.trim().isEmpty()) {
                        throw new IllegalArgumentException("Task cannot be empty.");
                    }
                    todoList.editItem(selected, newValue.trim());
                } catch (Exception innerEx) {
                    showAlert(innerEx.getMessage());
                }
            });

        } catch (Exception e) {
            showAlert(e.getMessage());
        }
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
