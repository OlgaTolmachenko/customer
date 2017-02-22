package com.mobidev.taskcompany.model;

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

    public Task(String id, String title, String category, String body, String timeCreated, String dueDate, Customer owner, TaskStatus taskStatus) {
        this.id = id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getDueDate() {
        return dueDate;
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

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }
}