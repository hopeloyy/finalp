package com.example.finalp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Final Project: To Do List Application
 * Launches a To Do List, to add, edit, or remove items. Displays and updated list
 * @author Hope Loy
 * @since 05/13/2025
 */
public class TodoApp extends Application {

    /**
     * Initializes the main stage and scene for the To-Do List application.
     * @param stage The primary stage for the application.
     * @throws IOException If an error occurs loading the FXML file.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TodoApp.class.getResource("todo-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        stage.setTitle("To-Do List");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main entry point for the JavaFX application.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        launch();
    }
}
