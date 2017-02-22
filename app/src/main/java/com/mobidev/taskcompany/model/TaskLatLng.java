package com.mobidev.taskcompany.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TaskLatLng implements Parcelable {

    private double Latitude;
    private  double longitude;

    public TaskLatLng() {
    }

    public TaskLatLng(double latitude, double longitude) {
        Latitude = latitude;
        this.longitude = longitude;
    }

    protected TaskLatLng(Parcel in) {
        Latitude = in.readDouble();
        longitude = in.readDouble();
    }

    public static final Creator<TaskLatLng> CREATOR = new Creator<TaskLatLng>() {
        @Override
        public TaskLatLng createFromParcel(Parcel in) {
            return new TaskLatLng(in);
        }

        @Override
        public TaskLatLng[] newArray(int size) {
            return new TaskLatLng[size];
        }
    };

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(Latitude);
        dest.writeDouble(longitude);
    }
}