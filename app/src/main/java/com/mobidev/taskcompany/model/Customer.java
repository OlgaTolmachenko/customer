package com.mobidev.taskcompany.model;

import android.support.annotation.Nullable;

import com.mobidev.taskcompany.util.Role;

public class Customer {

    private String name;
    private String uid;
    @Nullable
    private Role role;
    private String logo;
    private TaskLatLng location;
    private String address;

    public Customer() {
    }

    public Customer(String name, String uid, Role role, String logo, TaskLatLng location, String address) {
        this.name = name;
        this.uid = uid;
        this.role = role;
        this.logo = logo;
        this.location = location;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Nullable
    public Role getRole() {
        return role;
    }

    public void setRole(@Nullable Role role) {
        this.role = role;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public TaskLatLng getLocation() {
        return location;
    }

    public void setLocation(TaskLatLng location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

