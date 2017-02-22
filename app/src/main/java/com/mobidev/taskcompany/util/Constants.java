package com.mobidev.taskcompany.util;

public class Constants {
    public static final int MAX_ZOOM = 16;
    public static final String MY_MARKER_TITLE = "Me";
    public static final String ADDRESS = "address";
    public static final String NAME = "name";
    public static final String LOGO = "logo";
    public static final String LOGO_PLACEHOLDER = "android.resource://com.mobidev.taskcompany/drawable/ic_place";
    public static final String STORAGE_REF = "gs://taskdispatcher-bb18b.appspot.com";
    public static final String IMG = "img/";
    public static final String IMAGE = "image/*";
    public static final String LOCATION = "loc";
    public static final String TASKS = "tasks";
    public static final String DATE_TIME_FORMAT = "MM/dd/yyyy HH:mm:ss";
    public static final String DATE_FORMAT = "MM/dd/yyyy";
    public static final String TIME_FORMAT = "HH:mm";
    public static final String TAG = "MY_LOG_TAG";

    public static class RequestCodes {
        public static final int REQUEST_LIBRARY = 0;
        public static final int REQUEST_CAMERA = 1;
        public static final int REQUEST_LOCATION = 2;
        public static final int REQUEST_STORAGE_PERMISSION = 3;
        public static final int REQUEST_CAMERA_PERMISSION = 4;
        public static final int REQUEST_LOCATION_PERMISSION = 5;
        public static final int REQUEST_SIGN_IN = 6;

    }

    public static class FirebaseReferences {
        public static final String TASKS = "tasks";
        public static final String CUSTOMERS = "customers";
        public static final String OWNER_UID = "owner/uid";

    }
}