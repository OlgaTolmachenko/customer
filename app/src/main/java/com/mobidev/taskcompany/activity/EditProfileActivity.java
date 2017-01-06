package com.mobidev.taskcompany.activity;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import android.Manifest;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 1d51cc4... Models refactoring. Check DB data sent OK
=======
import android.Manifest;
>>>>>>> 4f5e128... Fix documents permission
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import android.content.pm.PackageManager;
=======
>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen
=======
import android.content.SharedPreferences;
>>>>>>> f8f400e... fixes
=======
>>>>>>> 8eef402... Fix CreateActivity sending tasks bug.
=======
import android.content.SharedPreferences;
>>>>>>> 071bcb0... temp
=======
import android.content.pm.PackageManager;
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 4f5e128... Fix documents permission
=======
import android.graphics.Bitmap;
>>>>>>> 35d04a3... Fix Camera. Fix Location
=======
>>>>>>> af65315... Add status to the Task
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 2a78416... temp
import android.os.Environment;
import android.provider.MediaStore;
=======
=======
=======
import android.content.BroadcastReceiver;
>>>>>>> 330f4ea... map ready
import android.content.Context;
>>>>>>> 13e53a9... loc saved
=======
import android.content.Context;
=======
>>>>>>> e54c81c... refactoring
import android.content.DialogInterface;
>>>>>>> 26ccd18... Back button action added. Sending logo to firebase
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
>>>>>>> cf08e23... map implemented
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import android.support.v4.app.ActivityCompat;
<<<<<<< HEAD
<<<<<<< HEAD
import android.support.v4.content.FileProvider;
<<<<<<< HEAD
=======
import android.support.v4.app.ActivityCompat;
>>>>>>> 4f5e128... Fix documents permission
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
=======
=======
import android.support.design.widget.Snackbar;
>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
<<<<<<< HEAD
import android.support.v7.app.AppCompatActivity;
<<<<<<< HEAD
>>>>>>> cf08e23... map implemented
=======
=======
>>>>>>> e54c81c... refactoring
=======
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
=======
>>>>>>> 2a78416... temp
=======
>>>>>>> 9830fd9... temp
=======
import android.support.v4.content.FileProvider;
>>>>>>> 35d04a3... Fix Camera. Fix Location
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
<<<<<<< HEAD
>>>>>>> 080411d... Capture photo from camera
import android.text.TextUtils;
<<<<<<< HEAD
>>>>>>> d184d09... Task creation and DB saving added
=======
=======
>>>>>>> 3497b4d... refactoring
import android.text.method.ScrollingMovementMethod;
>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import android.webkit.MimeTypeMap;
<<<<<<< HEAD
=======
>>>>>>> cf08e23... map implemented
import android.widget.EditText;
=======
>>>>>>> f64961d... setting up Storage
=======
import android.webkit.MimeTypeMap;
>>>>>>> 1d51cc4... Models refactoring. Check DB data sent OK
import android.widget.ImageView;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.mobidev.taskcompany.R;
import com.mobidev.taskcompany.TaskApp;
import com.mobidev.taskcompany.model.Customer;
import com.mobidev.taskcompany.util.Role;
import com.mobidev.taskcompany.model.TaskLatLng;
=======
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Scroller;
import android.widget.TextView;
<<<<<<< HEAD
>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen
=======
import android.widget.Toast;
>>>>>>> 080411d... Capture photo from camera

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
=======
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
=======
>>>>>>> e54c81c... refactoring
=======
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import com.firebase.ui.auth.AuthUI;
>>>>>>> dabb3d3... Implement taskpager fragments
=======
>>>>>>> 64f37b7... Add progressBars
=======
import com.firebase.ui.auth.AuthUI;
>>>>>>> ce4de03... Add handler for pause
=======
>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;
=======
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
>>>>>>> 080411d... Capture photo from camera
=======
>>>>>>> 3497b4d... refactoring
=======
>>>>>>> aee538b... bugfix
=======
import com.google.android.gms.maps.model.LatLng;
>>>>>>> 2a78416... temp
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.mobidev.taskcompany.R;
import com.mobidev.taskcompany.TaskApp;
import com.mobidev.taskcompany.model.Customer;
import com.mobidev.taskcompany.model.TaskLatLng;
import com.mobidev.taskcompany.util.Constants;
import com.mobidev.taskcompany.util.Role;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

<<<<<<< HEAD
<<<<<<< HEAD
import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import static com.mobidev.taskcompany.company.R.id.map;
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> cf08e23... map implemented

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
=======
>>>>>>> aee538b... bugfix
=======
import static android.provider.MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE;
import static android.provider.MediaStore.Files.FileColumns.MEDIA_TYPE_VIDEO;
>>>>>>> 2a78416... temp
=======
>>>>>>> 9830fd9... temp
import static com.mobidev.taskcompany.util.Constants.ADDRESS;
import static com.mobidev.taskcompany.util.Constants.IMAGE;
import static com.mobidev.taskcompany.util.Constants.IMG;
import static com.mobidev.taskcompany.util.Constants.LOCATION;
import static com.mobidev.taskcompany.util.Constants.LOGO;
import static com.mobidev.taskcompany.util.Constants.LOGO_PLACEHOLDER;
import static com.mobidev.taskcompany.util.Constants.NAME;
import static com.mobidev.taskcompany.util.Constants.STORAGE_REF;
<<<<<<< HEAD

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> d95c681... Refactoring activities
public class EditProfileActivity extends BaseActivity {

    private final int REQUEST_LIBRARY = 0;
    private final int REQUEST_CAMERA = 1;
    private final int REQUEST_LOCATION = 2;
    private final int STORAGE_PERMISSION_REQUEST_CODE = 3;
<<<<<<< HEAD
    private final int DOCUMENTS_PERMISSION_REQUEST_CODE = 4;
<<<<<<< HEAD
<<<<<<< HEAD
    private final int CAMERA_PERMISSION = 5;
=======
public class EditProfileActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, GoogleMap.OnMapClickListener {
=======
import static com.mobidev.taskcompany.util.Constants.LAT;
import static com.mobidev.taskcompany.util.Constants.LNG;
import static com.mobidev.taskcompany.util.Constants.MAX_ZOOM;
import static com.mobidev.taskcompany.util.Constants.MY_MARKER_TITLE;

public class EditProfileActivity extends AppCompatActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        GoogleMap.OnMapClickListener,
        GoogleMap.OnMyLocationButtonClickListener,
        LocationListener {
>>>>>>> 330f4ea... map ready
=======
>>>>>>> aee538b... bugfix

<<<<<<< HEAD
    private final int REQUEST_CODE = 0;
    private final int LOC_REQUEST_CODE = 1;
>>>>>>> cf08e23... map implemented
=======
    private final int CAMERA_REQUEST_CODE = 5;
=======
=======
>>>>>>> d95c681... Refactoring activities
    private final int CAMERA_PERMISSION = 5;
>>>>>>> 9830fd9... temp

    private Uri file;
>>>>>>> 2a78416... temp

<<<<<<< HEAD
    private Uri file;

=======
public class EditProfileActivity extends BaseMapActivity {

    private final int REQUEST_LIBRARY = 0;
    private final int REQUEST_CAMERA = 1;
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 080411d... Capture photo from camera
=======
public class EditProfileActivity extends BaseActivity {

    private final int REQUEST_LIBRARY = 0;
    private final int REQUEST_CAMERA = 1;
    private final int REQUEST_LOCATION = 2;
    private final int STORAGE_PERMISSION_REQUEST_CODE = 3;
    private final int DOCUMENTS_PERMISSION_REQUEST_CODE = 4;

>>>>>>> 4f5e128... Fix documents permission

<<<<<<< HEAD
    private ImageView logoView;
    private EditText nameField;
    private FloatingActionButton photoFab;
<<<<<<< HEAD
    private TextView addressTV;
    private  Uri logo;
    private String mCurrentPhotoPath;
=======
public class EditProfileActivity extends BaseActivity implements View.OnClickListener {
>>>>>>> 3bc2a92... Extract REQUEST_CODES into static class

    private LatLng location;
    private boolean isDocumentsPermissionGranted;
    private boolean isStoragePermissionGranted;
=======
=======
>>>>>>> 330f4ea... map ready
    private ImageView logoView;
=======
=======
>>>>>>> 1d51cc4... Models refactoring. Check DB data sent OK
=======
import static android.util.Config.LOGD;
>>>>>>> dabb3d3... Implement taskpager fragments
=======
>>>>>>> 64f37b7... Add progressBars
=======
    private final String TAG = "MY_LOG_TAG";
>>>>>>> aee538b... bugfix

public class EditProfileActivity extends BaseActivity {
=======
>>>>>>> 3b9bd70... Bugfix

    private final int REQUEST_CODE = 0;

<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> e54c81c... refactoring
    private MapView mapView;
=======
>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen
=======
    private String downloadedPhoto;
>>>>>>> d95c681... Refactoring activities
    private ImageView logoView;
<<<<<<< HEAD
    private Uri logo;
<<<<<<< HEAD
<<<<<<< HEAD
    private GoogleApiClient mGoogleApiClient;
<<<<<<< HEAD
>>>>>>> cf08e23... map implemented
=======
=======
>>>>>>> e54c81c... refactoring
    private TextInputEditText nameField;
    private TextInputLayout nameLayout;
//    private String customerId;
    private Snackbar locationSnack;
=======
    private EditText nameField;
<<<<<<< HEAD
>>>>>>> 080411d... Capture photo from camera
    private TaskLatLng setLocation;
=======
    private TaskLatLng location;
<<<<<<< HEAD
>>>>>>> 7465fed... Catch and show address
    CollapsingToolbarLayout collapsingToolbar;
=======
    private String address;
=======
    private EditText nameField;
>>>>>>> 3b9bd70... Bugfix
    private FloatingActionButton photoFab;
<<<<<<< HEAD
>>>>>>> f8f400e... fixes

<<<<<<< HEAD
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
>>>>>>> 330f4ea... map ready
=======
    private TextView addressTV;
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> aee538b... bugfix

<<<<<<< HEAD
        @Override
        public void onReceive(Context context, Intent intent) {

<<<<<<< HEAD
            Log.d("LOG", "onReceive: ");

            if (intent.getAction().equals("com.mobidev.taskcompany.LOGO")) {
                sendUserDataToDB(intent.getData());
            }
        }
    };

=======
>>>>>>> 26ccd18... Back button action added. Sending logo to firebase
=======


=======
    private  Uri logo;
<<<<<<< HEAD
>>>>>>> 3b9bd70... Bugfix
=======
    private String mCurrentPhotoPath;
>>>>>>> 35d04a3... Fix Camera. Fix Location

>>>>>>> a04eacf... Fix profile saving to DB
=======
    private TaskLatLng location;
=======
    private LatLng location;
>>>>>>> 2a78416... temp
    private boolean isDocumentsPermissionGranted;
    private boolean isStoragePermissionGranted;
=======
    private String mCurrentPhotoPath;
    private LatLng location;

    private MenuItem saveMenuItem = null;
>>>>>>> d95c681... Refactoring activities

>>>>>>> 4f5e128... Fix documents permission
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        hideProgress();

<<<<<<< HEAD
        Toolbar toolbar = (Toolbar) findViewById(R.id.editProfileToolbar);
        setSupportActionBar(toolbar);
        if (TaskApp.getInstance().getCurrentCustomer() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.profileCollapsingToolbar);
        collapsingToolbar.setTitle("");
=======
        Log.d("MY_LOG_TAG", "onCreate: " + logo);
>>>>>>> dabb3d3... Implement taskpager fragments

<<<<<<< HEAD
        photoFab = (FloatingActionButton) findViewById(R.id.photoFab);
<<<<<<< HEAD
        logoView = (ImageView) findViewById(R.id.editLogo);
        nameField = (EditText) findViewById(R.id.companyNameField);
        nameField.setBackgroundColor(Color.argb(70, 0, 0, 0));
=======
        Log.d("LOG", "EDIT_PROF onCreate: " + logo);
=======
        Log.d("MY_LOG_TAG", "onCreate: EDIT_PROF " + logo);
>>>>>>> ce4de03... Add handler for pause

=======
>>>>>>> aee538b... bugfix
        hideProgress();
>>>>>>> 64f37b7... Add progressBars

<<<<<<< HEAD
<<<<<<< HEAD
        if (TaskApp.getInstance().getCurrentCustomer() != null && TaskApp.getInstance().getCurrentCustomer().getName() != null) {
            nameField.setText(TaskApp.getInstance().getCurrentCustomer().getName());
            nameField.setSelection(nameField.getText().length());
        }
=======
=======
=======
=======

        https://guides.codepath.com/android/Accessing-the-Camera-and-Stored-Media




>>>>>>> 9830fd9... temp
=======
>>>>>>> 35d04a3... Fix Camera. Fix Location
        Toolbar toolbar = (Toolbar) findViewById(R.id.editProfileToolbar);
        setSupportActionBar(toolbar);
        if (TaskApp.getInstance().getCurrentCustomer() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.profileCollapsingToolbar);
        collapsingToolbar.setTitle("");

<<<<<<< HEAD
>>>>>>> 080411d... Capture photo from camera
        FloatingActionButton photoFab = (FloatingActionButton) findViewById(R.id.photoFab);
<<<<<<< HEAD
>>>>>>> 330f4ea... map ready
        logoView = (ImageView) findViewById(R.id.logo);
        nameLayout = (TextInputLayout) findViewById(R.id.companyNameLayout);
        nameField = (TextInputEditText) findViewById(R.id.companyNameField);
<<<<<<< HEAD
        mapView = (MapView) findViewById(map);
>>>>>>> cf08e23... map implemented

        setScroll(nameField);

        if (TaskApp.getInstance().getCurrentCustomer() != null && TaskApp.getInstance().getCurrentCustomer().getLogo() != null) {
            setupGlide(this, TaskApp.getInstance().getCurrentCustomer().getLogo(), logoView);
        }
=======

        mapView = (MapView) findViewById(R.id.map);
        mapView.getMapAsync(this);
        mapView.onCreate(savedInstanceState);
>>>>>>> 330f4ea... map ready
=======
=======
        photoFab = (FloatingActionButton) findViewById(R.id.photoFab);
>>>>>>> f8f400e... fixes
        logoView = (ImageView) findViewById(R.id.editLogo);
        nameField = (EditText) findViewById(R.id.companyNameField);
        nameField.setBackgroundColor(Color.argb(70, 0, 0, 0));

        if (TaskApp.getInstance().getCurrentCustomer() != null && TaskApp.getInstance().getCurrentCustomer().getName() != null) {
            nameField.setText(TaskApp.getInstance().getCurrentCustomer().getName());
            nameField.setSelection(nameField.getText().length());
        }

        setScroll(nameField);

<<<<<<< HEAD
<<<<<<< HEAD
//        mapView = (MapView) findViewById(R.id.map);
//        mapView.getMapAsync(this);
//        mapView.onCreate(savedInstanceState);
>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen

=======
>>>>>>> 080411d... Capture photo from camera
        if (TaskApp.getInstance().getCurrentCustomer().getLogo() != null) {
=======
        if (TaskApp.getInstance().getCurrentCustomer() != null && TaskApp.getInstance().getCurrentCustomer().getLogo() != null) {
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 8eef402... Fix CreateActivity sending tasks bug.
            setupGlide(this, TaskApp.getInstance().getCurrentCustomer().getLogo(), logoView);
        }

        photoFab.setOnClickListener(new View.OnClickListener() {
<<<<<<< HEAD
<<<<<<< HEAD

            CharSequence[] items = {getString(R.string.text_take_from_gallery), getString(R.string.text_take_from_camera)};
            @Override
            public void onClick(View view) {

                    new AlertDialog.Builder(EditProfileActivity.this)
                            .setTitle(R.string.text_add_photo_title)
                            .setItems(items, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    switch (which) {
                                        case 0:
                                            if (ActivityCompat.checkSelfPermission(EditProfileActivity.this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                                                requestPermissions();
                                            } else {
                                                getLogoFromGallery();
                                            }
                                            break;
                                        case 1:
                                            if (ActivityCompat.checkSelfPermission(EditProfileActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                                                requestCameraPermissions();
                                            } else {
                                                dispatchTakePictureIntent();
                                            }
                                            break;
                                    }
                                }
                            }).create().show();
            }
        });

        addressTV = (TextView) findViewById(R.id.addressTV);
        addressTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditProfileActivity.this, BaseMapActivity.class);
                if (location != null) {
                    intent.putExtra(LOCATION, location);
                }
                startActivityForResult(intent, REQUEST_LOCATION);
=======
            CharSequence[] items = {"From gallery", "Take a photo"};
=======
=======
            setupGlide(this, Uri.parse(TaskApp.getInstance().getCurrentCustomer().getLogo()), logoView);
=======
            setupGlide(this, TaskApp.getInstance().getCurrentCustomer().getLogo(), logoView);
>>>>>>> 4d67dd1... Fix set logo on re-sign-in. Move Customer_ID to Owner
        }

<<<<<<< HEAD
<<<<<<< HEAD
        photoFab.setOnClickListener(new View.OnClickListener() {

>>>>>>> 4f5e128... Fix documents permission
            CharSequence[] items = {getString(R.string.text_take_from_gallery), getString(R.string.text_take_from_camera)};
>>>>>>> aee538b... bugfix
            @Override
            public void onClick(View view) {

                    new AlertDialog.Builder(EditProfileActivity.this)
                            .setTitle(R.string.text_add_photo_title)
                            .setItems(items, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    switch (which) {
                                        case 0:
                                            if (ActivityCompat.checkSelfPermission(EditProfileActivity.this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                                                requestPermissions();
                                            } else {
                                                getLogoFromGallery();
                                            }
                                            break;
                                        case 1:
                                            if (ActivityCompat.checkSelfPermission(EditProfileActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                                                requestCameraPermissions();
                                            } else {
                                                dispatchTakePictureIntent();
                                            }
                                            break;
                                    }
                                }
<<<<<<< HEAD
                            }
                        }).create().show();
>>>>>>> 080411d... Capture photo from camera
=======
                            }).create().show();
>>>>>>> 4f5e128... Fix documents permission
            }
        });
=======
        photoFab.setOnClickListener(setupPhotoFabClickListener());
>>>>>>> d95c681... Refactoring activities
=======
        photoFab.setOnClickListener(this);
>>>>>>> 3bc2a92... Extract REQUEST_CODES into static class

        addressTV = (TextView) findViewById(R.id.addressTV);
        addressTV.setOnClickListener(this);

        setAddressTV(null);

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hideSpinner();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(EditProfileActivity.this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.MANAGE_DOCUMENTS}, Constants.RequestCodes.REQUEST_STORAGE_PERMISSION);
    }

    private void requestCameraPermissions() {
        ActivityCompat.requestPermissions(EditProfileActivity.this, new String[]{Manifest.permission.CAMERA}, Constants.RequestCodes.REQUEST_CAMERA_PERMISSION);
    }

    private void setAddressTV(String address) {

        if (address != null) {
            addressTV.setText(address);
            if (TaskApp.getInstance().getCurrentCustomer() != null) {
                TaskApp.getInstance().getCurrentCustomer().setAddress(address);
            }
        } else {
            if (TaskApp.getInstance().getCurrentCustomer() != null) {
                addressTV.setText(TaskApp.getInstance().getCurrentCustomer().getAddress());
            } else {
                addressTV.setText(R.string.text_choose_location);
            }
        }

    }

    private void setScroll(EditText field) {
        field.setScroller(new Scroller(this));
        field.setMovementMethod(new ScrollingMovementMethod());
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        saveMenuItem = menu.findItem(R.id.action_save);
        saveMenuItem.setEnabled(false);
        return true;
    }

<<<<<<< HEAD
<<<<<<< HEAD
        setAddressTV(null);
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(EditProfileActivity.this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.MANAGE_DOCUMENTS}, STORAGE_PERMISSION_REQUEST_CODE);
    }

    private void requestDocumentsPermissions() {
        ActivityCompat.requestPermissions(EditProfileActivity.this, new String[]{Manifest.permission.MANAGE_DOCUMENTS}, STORAGE_PERMISSION_REQUEST_CODE);
    }

    private void requestCameraPermissions() {
        ActivityCompat.requestPermissions(EditProfileActivity.this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION);
    }

    private void setAddressTV(String address) {
        if (address != null) {
            addressTV.setText(address);
            if (TaskApp.getInstance().getCurrentCustomer() != null) {
                TaskApp.getInstance().getCurrentCustomer().setAddress(address);
            }
        } else {
            if (TaskApp.getInstance().getCurrentCustomer() != null) {
                addressTV.setText(TaskApp.getInstance().getCurrentCustomer().getAddress());
            }  else {
                addressTV.setText(R.string.text_choose_location);
            }
        }
    }

    private void setScroll(EditText field) {
        field.setScroller(new Scroller(this));
        field.setMovementMethod(new ScrollingMovementMethod());
=======
        firebaseStorage = FirebaseStorage.getInstance();
        StorageReference myStorage = firebaseStorage.getReferenceFromUrl("gs://taskdispatcher-bb18b.appspot.com");
        StorageReference logoRef = myStorage.child("images");
>>>>>>> f64961d... setting up Storage
=======
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_edit_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                showSpinner();

                if (downloadedPhoto != null) {
                    saveCustomerDataInDB(downloadedPhoto);
                } else {
                    saveCustomerDataInDB(TaskApp.getInstance().getCurrentCustomer().getLogo());
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
<<<<<<< HEAD
        return super.onOptionsItemSelected(item);
>>>>>>> 330f4ea... map ready
=======
>>>>>>> dabb3d3... Implement taskpager fragments
    }

    private void showSpinner() {
        showProgress();
        photoFab.setVisibility(View.GONE);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.editProfileAppBar);
        appBarLayout.setVisibility(View.GONE);
    }

    private void hideSpinner() {
        hideProgress();
        hideKeyboard();
        photoFab.setVisibility(View.VISIBLE);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.editProfileAppBar);
        appBarLayout.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constants.RequestCodes.REQUEST_LIBRARY && resultCode == RESULT_OK) {
            setupGlide(this, data.getData().toString(), logoView);
            sendLogoToStorage(data.getData());

        }
        if (requestCode == Constants.RequestCodes.REQUEST_CAMERA && resultCode == RESULT_OK) {
            galleryAddPic();
            Uri contentUri = Uri.fromFile(new File(mCurrentPhotoPath));
            setupGlide(this, contentUri.toString(), logoView);
            sendLogoToStorage(contentUri);
        }

        if (requestCode == Constants.RequestCodes.REQUEST_LOCATION && resultCode == RESULT_OK) {
            location = data.getParcelableExtra(Constants.LOCATION);
            setAddressTV(data.getStringExtra(Constants.ADDRESS));
        }
    }

    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir
        );

        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }


    private void dispatchTakePictureIntent() {
        String authority = "com.mobidev.taskcompany.fileprovider";

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this, authority, photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, Constants.RequestCodes.REQUEST_CAMERA);
            }
        }
    }

    private void galleryAddPic() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(mCurrentPhotoPath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
    }

    private void sendLogoToStorage(Uri logo) {
        if (logo != null) {
            showSpinner();
            saveMenuItem.setEnabled(false);
            FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();

            MimeTypeMap mime = MimeTypeMap.getSingleton();
            ContentResolver cR = this.getContentResolver();
            mime.getExtensionFromMimeType(cR.getType(logo));

            StorageReference myStorage = firebaseStorage.getReferenceFromUrl(Constants.STORAGE_REF);
            StorageReference logoRef = myStorage.child(Constants.IMG + System.currentTimeMillis() + "." + mime.getExtensionFromMimeType(cR.getType(logo)));

            UploadTask uploadTask = logoRef.putFile(logo);

            uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    if (taskSnapshot != null) {
                        downloadedPhoto = taskSnapshot.getDownloadUrl().toString();
                    }
                    hideSpinner();
                    saveMenuItem.setEnabled(true);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d(Constants.TAG, "onFailure: " + e.getMessage());
                }
            });
        }
    }

    private void saveCustomerDataInDB(String logo) {
        Customer customer;
        if (TaskApp.getInstance().getCurrentCustomer() == null) {
            customer = new Customer(
                    nameField.getText().toString(),
                    TaskApp.getInstance().getCustomerId(),
                    Role.CUSTOMER,
                    logo,
                    new TaskLatLng(location.latitude, location.longitude),
                    getIntent().getStringExtra(Constants.ADDRESS)
            );
            TaskApp.getInstance().setCurrentCustomer(customer);
        } else {
            TaskApp.getInstance().getCurrentCustomer().setName(nameField.getText().toString());

            if (location != null) {
                TaskApp.getInstance().getCurrentCustomer().setLocation(new TaskLatLng(location.latitude, location.longitude));
            }
            TaskApp.getInstance().getCurrentCustomer().setLogo(logo);

            TaskApp.getInstance().getCurrentCustomer().setAddress(addressTV.getText().toString());
            customer = TaskApp.getInstance().getCurrentCustomer();
        }

        FirebaseDatabase.getInstance().getReference(Constants.FirebaseReferences.CUSTOMERS).child(TaskApp.getInstance().getCustomerId()).setValue(customer).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                startActivity(new Intent(EditProfileActivity.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
    }

    @Override
<<<<<<< HEAD
    protected void onPause() {
        Log.d(TAG, "onPause: ");
        super.onPause();
    }

    @Override
<<<<<<< HEAD
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
=======
    protected void onResume() {
        mapView.onResume();
        mGoogleApiClient.connect();
        super.onResume();
>>>>>>> 330f4ea... map ready
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mGoogleApiClient != null && mGoogleApiClient.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
            mGoogleApiClient.disconnect();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
        hideSpinner();
    }

    @Override
<<<<<<< HEAD
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

<<<<<<< HEAD
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_edit_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                showSpinner();
                uploadLogoAndPostUserToDB(logo);
                if (TaskApp.getInstance().getCurrentCustomer() != null && logo == null) {
                    saveCustomerDataInDB(TaskApp.getInstance().getCurrentCustomer().getLogo());
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showSpinner() {
        showProgress();
        photoFab.setVisibility(View.GONE);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.editProfileAppBar);
        appBarLayout.setVisibility(View.GONE);
=======
=======
>>>>>>> e54c81c... refactoring
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.alert_title_back_button))
                .setMessage(getString(R.string.alert_text_back_button))
                .setPositiveButton(getString(R.string.alert_positive), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        EditProfileActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton(getString(R.string.alert_negative), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                }).create().show();
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    @Override
    public void onLowMemory() {
        mapView.onLowMemory();
        super.onLowMemory();
>>>>>>> 26ccd18... Back button action added. Sending logo to firebase
    }

    private void hideSpinner() {
        hideProgress();
        hideKeyboard();
        photoFab.setVisibility(View.VISIBLE);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.editProfileAppBar);
        appBarLayout.setVisibility(View.VISIBLE);
=======
=======
>>>>>>> e54c81c... refactoring
    private void getImgFromGallery() {
=======
    private void getLogoFromGallery() {
>>>>>>> 080411d... Capture photo from camera
        final String chooserTitle = getString(R.string.chooser_title);
        Intent intent = new Intent();
        intent.setType(IMAGE);
        intent.setAction(Intent.ACTION_GET_CONTENT);
<<<<<<< HEAD
<<<<<<< HEAD
        startActivityForResult(Intent.createChooser(intent, "Select logoView"), REQUEST_CODE);
>>>>>>> cf08e23... map implemented
=======
        startActivityForResult(Intent.createChooser(intent, chooserTitle), REQUEST_CODE);
>>>>>>> 330f4ea... map ready
    }

<<<<<<< HEAD
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
<<<<<<< HEAD

<<<<<<< HEAD
        if (requestCode == REQUEST_LIBRARY && resultCode == RESULT_OK) {
            setImageOnResult(data);
        }
        if (requestCode == REQUEST_CAMERA && resultCode == RESULT_OK) {

            //TODO set image in imageView here

            galleryAddPic();

            File f = new File(mCurrentPhotoPath);
            Uri contentUri = Uri.fromFile(f);

            setImageOnResult(contentUri);
        }

        if (requestCode == REQUEST_LOCATION && resultCode == RESULT_OK) {
            location = data.getParcelableExtra(LOCATION);
            setAddressTV(data.getStringExtra(ADDRESS));
        }
    }


    private void setImageOnResult(Intent data) {

        if (TaskApp.getInstance().getCurrentCustomer() != null) {
            TaskApp.getInstance().getCurrentCustomer().setLogo(String.valueOf(data.getData()));
            setupGlide(this, TaskApp.getInstance().getCurrentCustomer().getLogo(), logoView);
        } else {
            logo = data.getData();
            setupGlide(this, String.valueOf(logo), logoView);
        }
    }

    private void setImageOnResult(Uri content) {

        if (TaskApp.getInstance().getCurrentCustomer() != null) {
            TaskApp.getInstance().getCurrentCustomer().setLogo(String.valueOf(content));
            setupGlide(this, TaskApp.getInstance().getCurrentCustomer().getLogo(), logoView);
        } else {
            setupGlide(this, String.valueOf(content), logoView);
        }
    }

    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir
        );

        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }



    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.mobidev.taskcompany.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_CAMERA);
            }
        }
    }

    private void galleryAddPic() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(mCurrentPhotoPath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
    }

    private void uploadLogoAndPostUserToDB(Uri logo) {
        if (logo != null) {
            if (ActivityCompat.checkSelfPermission(EditProfileActivity.this, android.Manifest.permission.MANAGE_DOCUMENTS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(EditProfileActivity.this, new String[]{android.Manifest.permission.MANAGE_DOCUMENTS}, DOCUMENTS_PERMISSION_REQUEST_CODE);
            } else {
                sendUriToStorage(logo);
            }
        } else {
            if (TaskApp.getInstance().getCurrentCustomer() != null) {
                saveCustomerDataInDB(TaskApp.getInstance().getCurrentCustomer().getLogo());
            } else {
                saveCustomerDataInDB(LOGO_PLACEHOLDER);
            }
        }
    }

    private void sendUriToStorage(Uri logo) {
        if (logo != null) {
            FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();

            MimeTypeMap mime = MimeTypeMap.getSingleton();
            ContentResolver cR = this.getContentResolver();
            mime.getExtensionFromMimeType(cR.getType(logo));

            StorageReference myStorage = firebaseStorage.getReferenceFromUrl(STORAGE_REF);
            StorageReference logoRef = myStorage.child(IMG + System.currentTimeMillis() + "." + mime.getExtensionFromMimeType(cR.getType(logo)));

            UploadTask uploadTask = logoRef.putFile(logo);

            uploadTask.addOnFailureListener(onStorageFailure()).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    String downloadedPhoto = taskSnapshot.getDownloadUrl().toString();
                    if (downloadedPhoto != null) {
                        Log.d(TAG, "onStorageSuccess ON_SUCCESS: " + downloadedPhoto);
                        saveCustomerDataInDB(downloadedPhoto);
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d(TAG, "onFailure: " + e.getMessage());
                }
            });
        }
    }

    private void saveCustomerDataInDB(String logo) {
        Customer customer;

        if (TaskApp.getInstance().getCurrentCustomer() == null && logo != null) {
            customer = new Customer(
                    nameField.getText().toString(),
                    TaskApp.getInstance().getCustomerId(),
                    Role.CUSTOMER,
                    logo,
                    new TaskLatLng(location.latitude, location.longitude),
                    getIntent().getStringExtra(ADDRESS)
            );
            Log.d(TAG, "saveCustomerDataInDB: location ==== " +  (TaskLatLng) getIntent().getParcelableExtra(LOCATION));
            TaskApp.getInstance().setCurrentCustomer(customer);
        } else {
            TaskApp.getInstance().getCurrentCustomer().setName(nameField.getText().toString());

            if (location != null) {
                TaskApp.getInstance().getCurrentCustomer().setLocation(new TaskLatLng(location.latitude, location.longitude));
            }
            TaskApp.getInstance().getCurrentCustomer().setAddress(addressTV.getText().toString());
            customer = TaskApp.getInstance().getCurrentCustomer();
        }

        FirebaseDatabase.getInstance().getReference("customers").child(TaskApp.getInstance().getCustomerId()).setValue(customer).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                startActivity(new Intent(EditProfileActivity.this, MainActivity.class).setFlags(FLAG_ACTIVITY_CLEAR_TASK | FLAG_ACTIVITY_NEW_TASK));
            }
        });
    }

    @NonNull
    private OnFailureListener onStorageFailure() {
        return new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, "onStorageSuccess ON_FAILURE: " + e.getMessage());
=======
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                logo = data.getData();
                Log.d("LOG", "onActivityResult: " + logo);
                logoView.setImageURI(logo);
>>>>>>> cf08e23... map implemented
            }
        };
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.alert_title_back_button))
                .setMessage(getString(R.string.alert_text_back_button))
                .setPositiveButton(getString(R.string.alert_positive), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        EditProfileActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton(getString(R.string.alert_negative), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                }).create().show();
    }

    private void getLogoFromGallery() {
        final String chooserTitle = getString(R.string.chooser_title);
        Intent intent = new Intent();
        intent.setType(IMAGE);
=======
    private void getLogoFromGallery() {
        final String chooserTitle = getString(R.string.chooser_title);
        Intent intent = new Intent();
        intent.setType(Constants.IMAGE);
>>>>>>> d95c681... Refactoring activities
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, chooserTitle), Constants.RequestCodes.REQUEST_LIBRARY);
    }

<<<<<<< HEAD
<<<<<<< HEAD
    @Override
    protected void onSaveInstanceState(Bundle outState) {
<<<<<<< HEAD
        Log.d(TAG, "onSaveInstanceState: ");
        if (logo != null) {
            outState.putString(LOGO, logo.toString());
=======
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            logo = data.getData();
<<<<<<< HEAD
            logoView.setImageURI(logo);
>>>>>>> 330f4ea... map ready
=======
            Glide.with(EditProfileActivity.this)
                    .load(logo)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(logoView);
        }
    }
=======
=======
        startActivityForResult(Intent.createChooser(intent, chooserTitle), REQUEST_LIBRARY);
    }

    private void getLogoFromCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_CAMERA);
        }
    }
<<<<<<< HEAD
>>>>>>> 080411d... Capture photo from camera

<<<<<<< HEAD
>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen
=======
//    private void getLogoFromCamera() {
//        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivityForResult(intent, REQUEST_CAMERA);
//        }
//    }
>>>>>>> 2a78416... temp
=======
>>>>>>> 9830fd9... temp

=======
>>>>>>> 8eef402... Fix CreateActivity sending tasks bug.
=======
>>>>>>> 35d04a3... Fix Camera. Fix Location
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: ");
        if (logo != null) {
            outState.putString(LOGO, logo.toString());
        }
        outState.putString(NAME, nameField.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState: ");
        if (savedInstanceState != null) {
            nameField.setText(savedInstanceState.getString(NAME));
            setupGlide(this, savedInstanceState.getString(LOGO), logoView);
        }
        super.onRestoreInstanceState(savedInstanceState);
<<<<<<< HEAD
        Log.d(TAG, "onRestoreInstanceState: EDIT_PROF " + savedInstanceState.getParcelable("logo"));
        if (!savedInstanceState.isEmpty()) {
<<<<<<< HEAD
<<<<<<< HEAD
//            Glide.with(EditProfileActivity.this)
//                    .load((Uri) savedInstanceState.getParcelable("logo"))
//                    .diskCacheStrategy(DiskCacheStrategy.ALL)
//                    .into(logoView);
<<<<<<< HEAD
            savedInstanceState.getString("name");
>>>>>>> dabb3d3... Implement taskpager fragments
=======
=======
>>>>>>> aee538b... bugfix
            nameField.setText(savedInstanceState.getString("name"));
>>>>>>> f8f400e... fixes
=======
        if (downloadedPhoto != null) {
            outState.putString(Constants.LOGO, downloadedPhoto);
>>>>>>> d95c681... Refactoring activities
        }
        outState.putString(Constants.NAME, nameField.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            nameField.setText(savedInstanceState.getString(Constants.NAME));
            setupGlide(this, savedInstanceState.getString(Constants.LOGO), logoView);
        }
        super.onRestoreInstanceState(savedInstanceState);
    }
<<<<<<< HEAD

    @Override
<<<<<<< HEAD
=======
    }

    @Override
>>>>>>> 4f5e128... Fix documents permission
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case Constants.RequestCodes.REQUEST_STORAGE_PERMISSION: {
                if (grantResults.length > 0
                        && Objects.equals(permissions[0], android.Manifest.permission.READ_EXTERNAL_STORAGE)
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                    isStoragePermissionGranted = true;
                    getLogoFromGallery();
=======
                    getLogoFromGallery();

>>>>>>> 4f5e128... Fix documents permission
=======
                    isStoragePermissionGranted = true;
=======
>>>>>>> d95c681... Refactoring activities
                    getLogoFromGallery();
>>>>>>> 2a78416... temp
                }
            }
<<<<<<< HEAD
            case DOCUMENTS_PERMISSION_REQUEST_CODE: {
                if (grantResults.length > 0
                        && Objects.equals(permissions[0], Manifest.permission.MANAGE_DOCUMENTS)
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    isDocumentsPermissionGranted = true;
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 2a78416... temp
                    sendUriToStorage(logo);
                }
            }
=======
>>>>>>> d95c681... Refactoring activities

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
            case CAMERA_PERMISSION: {
=======
            case CAMERA_REQUEST_CODE: {
>>>>>>> 2a78416... temp
=======
            case CAMERA_PERMISSION: {
>>>>>>> 9830fd9... temp
=======
            case Constants.RequestCodes.REQUEST_CAMERA_PERMISSION: {
>>>>>>> 3bc2a92... Extract REQUEST_CODES into static class
                if (grantResults.length > 0
                        && Objects.equals(permissions[0], Manifest.permission.CAMERA)
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

<<<<<<< HEAD
                    isDocumentsPermissionGranted = true;
<<<<<<< HEAD
<<<<<<< HEAD

                    //TODO capture photo from Camera here
=======
>>>>>>> d95c681... Refactoring activities
                    dispatchTakePictureIntent();
<<<<<<< HEAD
=======
//                    takePicture();
//                    getLogoFromCamera();
//                    dispatchTakePictureIntent();
                    captureImage();
>>>>>>> 2a78416... temp
                }
            }
        }
=======
    public void onMapReady(GoogleMap googleMap) {

        if (googleMap == null) {
            return;
        }

        mGoogleMap = googleMap;

        googleMap.setOnMapClickListener(this);
        googleMap.setOnMyLocationButtonClickListener(this);
        googleMap.getUiSettings().setCompassEnabled(false);
        googleMap.getUiSettings().setMapToolbarEnabled(false);
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);
        googleMap.getUiSettings().setZoomControlsEnabled(true);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case LOC_REQUEST_CODE: {
                if (grantResults.length > 0
                        && Objects.equals(permissions[0], Manifest.permission.ACCESS_FINE_LOCATION)
                        && Objects.equals(permissions[1], Manifest.permission.ACCESS_COARSE_LOCATION)
                        && Objects.equals(permissions[2], Manifest.permission.READ_EXTERNAL_STORAGE)
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                            && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                            && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions();
                    }
                    currentLocation = getLastLocation();
                    showMarker(CameraUpdateFactory.newLatLngZoom(currentLocation, MAX_ZOOM), new MarkerOptions().position(currentLocation).title(MY_MARKER_TITLE));
                }
            }
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions();
        } else {

            mGoogleMap.setMyLocationEnabled(true);

            LocationServices.FusedLocationApi.requestLocationUpdates(
                    mGoogleApiClient,
                    LocationRequest.create(),
                    this
            );
            currentLocation = getLastLocation();

            if (currentLocation == null) {
                return;
            }

            SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit()
                    .putFloat(LAT, (float) currentLocation.latitude)
                    .putFloat(LNG, (float) currentLocation.longitude);
            editor.commit();

            showMarker(CameraUpdateFactory.newLatLngZoom(currentLocation, MAX_ZOOM), new MarkerOptions().position(currentLocation).title(MY_MARKER_TITLE));
        }
    }

<<<<<<< HEAD
    private LatLng getLastLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return null;
=======
            nameField.setText(savedInstanceState.getString(NAME));
            setupGlide(this, LOGO, logoView);
>>>>>>> 071bcb0... temp
=======
=======

                    //TODO capture photo from Camera here
<<<<<<< HEAD
>>>>>>> f01beab... prepare to capture photos from camera
=======
//                    getLogoFromCamera();
                    takePicture();
>>>>>>> 9830fd9... temp
=======
>>>>>>> 35d04a3... Fix Camera. Fix Location
                }
            }
>>>>>>> 4f5e128... Fix documents permission
        }
        return currentLocation = new LatLng(
                LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient).getLatitude(),
                LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient).getLongitude()
        );
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                },
                LOC_REQUEST_CODE);
    }

    @Override
    public void onConnectionSuspended(int i) {
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    @Override
    public void onMapClick(LatLng latLng) {
        currentLocation = latLng;
        showMarker(CameraUpdateFactory.newLatLng(latLng), new MarkerOptions().position(latLng).title(MY_MARKER_TITLE));
    }


    @Override
    public boolean onMyLocationButtonClick() {
        showMarker(CameraUpdateFactory.newLatLng(currentLocation),
                new MarkerOptions().position(currentLocation).title(MY_MARKER_TITLE));
        return true;
    }
<<<<<<< HEAD

    private void showMarker(CameraUpdate cameraUpdate, MarkerOptions me) {
        mGoogleMap.clear();
<<<<<<< HEAD
        mGoogleMap.animateCamera(CameraUpdateFactory.newLatLng(
                latLng));
        mGoogleMap.addMarker(new MarkerOptions().position(
                latLng)
                .title("Me"));
>>>>>>> cf08e23... map implemented
=======
        mGoogleMap.animateCamera(cameraUpdate);
        mGoogleMap.addMarker(me);
    }

    @Override
    public void onLocationChanged(Location location) {
>>>>>>> 330f4ea... map ready
    }

=======
>>>>>>> e54c81c... refactoring
}


=======
}
>>>>>>> 8eef402... Fix CreateActivity sending tasks bug.
=======
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addressTV:
                Intent intent = new Intent(EditProfileActivity.this, BaseMapActivity.class);
                if (location != null) {
                    intent.putExtra(Constants.LOCATION, location);
                }
                startActivityForResult(intent, Constants.RequestCodes.REQUEST_LOCATION);
                break;
            case R.id.photoFab:
                CharSequence[] items = {getString(R.string.text_take_from_gallery), getString(R.string.text_take_from_camera)};
                getAlertDialog(items).show();
                break;
        }
    }
<<<<<<< HEAD
}
>>>>>>> 3bc2a92... Extract REQUEST_CODES into static class
=======

    private AlertDialog getAlertDialog(CharSequence[] items) {
        return new AlertDialog.Builder(EditProfileActivity.this)
                .setTitle(R.string.text_add_photo_title)
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                if (ActivityCompat.checkSelfPermission(EditProfileActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                                    requestPermissions();
                                } else {
                                    getLogoFromGallery();
                                }
                                break;
                            case 1:
                                if (ActivityCompat.checkSelfPermission(EditProfileActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                                    requestCameraPermissions();
                                } else {
                                    dispatchTakePictureIntent();
                                }
                                break;
                        }
                    }
                }).create();
    }
}
>>>>>>> 1335be7... Refactor resources
