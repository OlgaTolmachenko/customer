package com.mobidev.taskcompany;

import android.app.Application;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
import com.mobidev.taskcompany.activity.MainActivity;
>>>>>>> f2858f9... temp
=======
>>>>>>> 3497b4d... refactoring
import com.mobidev.taskcompany.model.Customer;
import com.mobidev.taskcompany.model.Task;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.List;

=======
=======
import com.mobidev.taskcompany.model.Customer;
>>>>>>> 1d51cc4... Models refactoring. Check DB data sent OK
import com.mobidev.taskcompany.model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by olga on 16.01.17.
 */

>>>>>>> ad17e39... Implementing ListAdapter
=======
import java.util.List;

>>>>>>> 3497b4d... refactoring
public class TaskApp extends Application {

    private static TaskApp instance;
    private List<Task> taskList = new ArrayList<>();
<<<<<<< HEAD
<<<<<<< HEAD
    private Customer currentCustomer;
    private String customerId;
<<<<<<< HEAD
<<<<<<< HEAD
    private int taskCount;
=======
    private String customerAddress;
    private TaskLatLng location;
<<<<<<< HEAD
>>>>>>> aee538b... bugfix
=======
=======
>>>>>>> 4f5e128... Fix documents permission
    private int taskCount;
>>>>>>> 3b9bd70... Bugfix

    public static TaskApp getInstance() {
        if (instance == null) {
=======
=======
    private Customer currentCustomer;
<<<<<<< HEAD
>>>>>>> 1d51cc4... Models refactoring. Check DB data sent OK
=======
    private String customerId;
>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen

    public static TaskApp getInstance() {
<<<<<<< HEAD
        if(instance == null){
>>>>>>> ad17e39... Implementing ListAdapter
=======
        if (instance == null) {
>>>>>>> 6b47303... multiple login
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 1d51cc4... Models refactoring. Check DB data sent OK

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
<<<<<<< HEAD
<<<<<<< HEAD

    public int getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(int taskCount) {
        this.taskCount = taskCount;
    }
=======
>>>>>>> ad17e39... Implementing ListAdapter
=======
>>>>>>> 1d51cc4... Models refactoring. Check DB data sent OK
=======
>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen
=======

<<<<<<< HEAD
    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public TaskLatLng getLocation() {
        return location;
    }

    public void setLocation(TaskLatLng location) {
        this.location = location;
    }
<<<<<<< HEAD
>>>>>>> aee538b... bugfix
=======

=======
>>>>>>> 4f5e128... Fix documents permission
    public int getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(int taskCount) {
        this.taskCount = taskCount;
    }
>>>>>>> 3b9bd70... Bugfix
}
