package com.mobidev.taskcompany;

import android.app.Application;

import com.mobidev.taskcompany.model.Customer;
import com.mobidev.taskcompany.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskApp extends Application {

    private static TaskApp instance;
    private List<Task> taskList = new ArrayList<>();
    private Customer currentCustomer;
    private String customerId;
    private int taskCount;

    public static TaskApp getInstance() {
        if (instance == null) {
            instance = new TaskApp();
        }
        return instance;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(Task task) {
        taskList.add(task);
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(int taskCount) {
        this.taskCount = taskCount;
    }
}