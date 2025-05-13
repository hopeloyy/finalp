package com.example.finalp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Final Project: To Do List Application
 * Launches a To Do List, to add, edit, or remove items. Displays and updated list
 * @author Hope Loy
 * @since 05/13/2025


/*
 * Manages the list of to-do items.
 */
public class TodoList {

    private final ObservableList<String> items;

    /**
     * Constructor for initializing the TodoList with an empty list of items.
     */
    public TodoList() {
        items = FXCollections.observableArrayList();
    }

    /**
     * Retrieves the list of items in the to-do list.
     * @return The observable list of to-do items.
     */
    public ObservableList<String> getItems() {
        return items;
    }

    /**
     * Adds a new item to the to-do list.
     * @param item The item to be added.
     */
    public void addItem(String item) {
        items.add(item);
    }

    /**
     * Removes an item from the to-do list.
     * @param item The item to be removed.
     */
    public void removeItem(String item) {
        items.remove(item);
    }

    /**
     * Edits an existing item in the to-do list.
     * @param oldItem The item to be edited.
     * @param newItem The new value for the item.
     */
    public void editItem(String oldItem, String newItem) {
        int index = items.indexOf(oldItem);
        if (index >= 0) {
            items.set(index, newItem);
        }
    }
}
