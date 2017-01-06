package com.mobidev.taskcompany.model;

<<<<<<< HEAD
<<<<<<< HEAD
import android.os.Parcel;
import android.os.Parcelable;

<<<<<<< HEAD
public class TaskLatLng implements Parcelable {
=======
=======
import android.os.Parcel;
import android.os.Parcelable;

>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen
/**
 * Created by olga on 18.01.17.
 */

<<<<<<< HEAD
public class TaskLatLng {
>>>>>>> 1d51cc4... Models refactoring. Check DB data sent OK
=======
=======
>>>>>>> 3497b4d... refactoring
public class TaskLatLng implements Parcelable {
>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen

    private double Latitude;
    private  double longitude;

    public TaskLatLng() {
    }

    public TaskLatLng(double latitude, double longitude) {
        Latitude = latitude;
        this.longitude = longitude;
    }

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen
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

<<<<<<< HEAD
=======
>>>>>>> 1d51cc4... Models refactoring. Check DB data sent OK
=======
>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(Latitude);
        dest.writeDouble(longitude);
    }
<<<<<<< HEAD
=======
>>>>>>> 1d51cc4... Models refactoring. Check DB data sent OK
=======
>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen
}
