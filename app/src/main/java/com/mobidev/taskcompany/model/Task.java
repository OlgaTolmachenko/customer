package com.mobidev.taskcompany.model;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import com.mobidev.taskcompany.util.TaskStatus;

public class Task {

    private String id;
    private String title;
    private String category;
    private String body;
    private String timeCreated;
    private String dueDate;
    private Customer owner;
    private TaskStatus taskStatus;

    public Task() {
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 74fd957... Fix Role. Fix Task
=======
>>>>>>> 9246afa... fix creating and sending task
    public Task(String title, String category, String body, String timeCreated, String dueDate, Customer owner, String customerId, Status status) {
<<<<<<< HEAD
=======
    public Task(String title, String category, String body, String timeCreated, String dueDate, Customer owner) {
>>>>>>> 1036a9d... Fix set logo on re-sign-in. Move Customer_ID to Owner
=======
>>>>>>> 338725e... fix
=======
    public Task(String title, String category, String body, String timeCreated, String dueDate, Customer owner, String customerId, TaskStatus taskStatus) {
>>>>>>> 1e1bfe8... Add status NEW when creating tasks. Add ItemDecorator to tasks recyclerview. Fix margins. Add task random title and body
=======
    public Task(String title, String category, String body, String timeCreated, String dueDate, Customer owner, TaskStatus taskStatus) {
>>>>>>> 2b9ce43... Fix Role. Fix Task
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 9246afa... fix creating and sending task
=======
    public Task(String id, String title, String category, String body, String timeCreated, String dueDate, Customer owner, TaskStatus taskStatus) {
        this.id = id;
>>>>>>> 5ab786c... fix creating and sending task
<<<<<<< HEAD
=======
>>>>>>> 74fd957... Fix Role. Fix Task
=======
>>>>>>> 9246afa... fix creating and sending task
=======
    public Task(String id, String title, String category, String body, String timeCreated, String dueDate, Customer owner, TaskStatus taskStatus) {
        this.id = id;
>>>>>>> 1c4249d... Fix comflict
        this.title = title;
        this.category = category;
        this.body = body;
        this.timeCreated = timeCreated;
        this.dueDate = dueDate;
        this.owner = owner;
        this.taskStatus = taskStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
<<<<<<< HEAD
=======
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by olga on 16.01.17.
 */

=======
>>>>>>> 3497b4d... refactoring
=======
import com.mobidev.taskcompany.util.Status;
=======
import com.mobidev.taskcompany.util.TaskStatus;
>>>>>>> 762f2c5... Add status NEW when creating tasks. Add ItemDecorator to tasks recyclerview. Fix margins. Add task random title and body

>>>>>>> af65315... Add status to the Task
public class Task {

    private String title;
    private String category;
    private String body;
    private String timeCreated;
    private String dueDate;
    private Customer owner;
    private String customerId;
<<<<<<< HEAD
    private Status status;
<<<<<<< HEAD
=======
>>>>>>> 1036a9d... Fix set logo on re-sign-in. Move Customer_ID to Owner
=======
>>>>>>> 338725e... fix
=======
    private TaskStatus taskStatus;
>>>>>>> 1e1bfe8... Add status NEW when creating tasks. Add ItemDecorator to tasks recyclerview. Fix margins. Add task random title and body

    public Task() {
    }

<<<<<<< HEAD
    public Task(String title, String category, String body, String timeCreated, String dueDate, Customer owner, String customerId, Status status) {
<<<<<<< HEAD
=======
    public Task(String title, String category, String body, String timeCreated, String dueDate, Customer owner) {
>>>>>>> 1036a9d... Fix set logo on re-sign-in. Move Customer_ID to Owner
=======
>>>>>>> 338725e... fix
=======
    public Task(String title, String category, String body, String timeCreated, String dueDate, Customer owner, String customerId, TaskStatus taskStatus) {
>>>>>>> 1e1bfe8... Add status NEW when creating tasks. Add ItemDecorator to tasks recyclerview. Fix margins. Add task random title and body
        this.title = title;
        this.category = category;
        this.body = body;
        this.timeCreated = timeCreated;
        this.dueDate = dueDate;
        this.owner = owner;
        this.customerId = customerId;
<<<<<<< HEAD
        this.status = status;
<<<<<<< HEAD
=======
>>>>>>> 1036a9d... Fix set logo on re-sign-in. Move Customer_ID to Owner
=======
>>>>>>> 338725e... fix
=======
        this.taskStatus = taskStatus;
>>>>>>> 1e1bfe8... Add status NEW when creating tasks. Add ItemDecorator to tasks recyclerview. Fix margins. Add task random title and body
    }

<<<<<<< HEAD
    protected Task(Parcel in) {
        title = in.readString();
        category = in.readString();
        body = in.readString();
        timeCreated = in.readString();
        dueDate = in.readString();
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };
>>>>>>> d184d09... Task creation and DB saving added

=======
>>>>>>> 1d51cc4... Models refactoring. Check DB data sent OK
=======

>>>>>>> 9246afa... fix creating and sending task
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 966923f... restructuring
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

<<<<<<< HEAD
=======
>>>>>>> d184d09... Task creation and DB saving added
=======
>>>>>>> 966923f... restructuring
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 966923f... restructuring
    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getDueDate() {
        return dueDate;
<<<<<<< HEAD
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }
<<<<<<< HEAD

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }
<<<<<<< HEAD
=======
>>>>>>> 1036a9d... Fix set logo on re-sign-in. Move Customer_ID to Owner
=======
>>>>>>> 338725e... fix
=======
    public String getTime() {
        return time;
=======
>>>>>>> 966923f... restructuring
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> d184d09... Task creation and DB saving added
=======
=======
>>>>>>> 4d67dd1... Fix set logo on re-sign-in. Move Customer_ID to Owner
=======
>>>>>>> ee37b44... fix timepick

<<<<<<< HEAD
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
<<<<<<< HEAD
>>>>>>> 92f4cb1... filter tasks
=======

=======
>>>>>>> 043e2f2... Fix Task model
    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> af65315... Add status to the Task
=======
=======
>>>>>>> 1036a9d... Fix set logo on re-sign-in. Move Customer_ID to Owner
>>>>>>> 4d67dd1... Fix set logo on re-sign-in. Move Customer_ID to Owner
=======
=======
>>>>>>> 1036a9d... Fix set logo on re-sign-in. Move Customer_ID to Owner
=======
>>>>>>> 338725e... fix
>>>>>>> ee37b44... fix timepick
=======
>>>>>>> 1c4249d... Fix comflict
}
