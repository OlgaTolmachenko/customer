package com.mobidev.taskcompany.model;

public enum Category {

    CATEGORY1("Category1"),
    CATEGORY2("Category2"),
    CATEGORY3("Category3");

    private final String value;

    Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}