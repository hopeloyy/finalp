package com.example.finalp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Manages the list of to-do items.
 */
public class TodoList {

    private final ObservableList<String> items;

    public TodoList() {
        items = FXCollections.observableArrayList();
    }

    public ObservableList<String> getItems() {
        return items;
    }

    public void addItem(String item) {
        items.add(item);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public void editItem(String oldItem, String newItem) {
        int index = items.indexOf(oldItem);
        if (index >= 0) {
            items.set(index, newItem);
        }
    }
}
