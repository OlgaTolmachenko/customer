package com.mobidev.taskcompany.activity;

import android.Manifest;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;

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
import com.mobidev.taskcompany.model.TaskLatLng;
import com.mobidev.taskcompany.util.Constants;
import com.mobidev.taskcompany.util.Role;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class EditProfileActivity extends BaseActivity implements View.OnClickListener {

    private Uri downloadedPhoto;
    private ImageView logoView;
    private EditText nameField;
    private FloatingActionButton photoFab;
    private TextView addressField;
    private String currentPhotoPath;
    private LatLng location;
    private boolean isFirstTime;
    private String address;
    private Uri logo;

    private MenuItem saveMenuItem = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        hideProgress();

        Toolbar toolbar = (Toolbar) findViewById(R.id.editProfileToolbar);
        setSupportActionBar(toolbar);
        if (TaskApp.getInstance().getCurrentCustomer() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.profileCollapsingToolbar);
        collapsingToolbar.setTitle("");

        mapWidgets();
        setUpNameFiled();

        if (TaskApp.getInstance().getCurrentCustomer() == null) {
            isFirstTime = true;
        }

        if (!isFirstTime) {
            setupGlide(this, TaskApp.getInstance().getCurrentCustomer().getLogo(), logoView);
            nameField.setText(TaskApp.getInstance().getCurrentCustomer().getName());
            nameField.setSelection(nameField.getText().length());
        }

        nameField.addTextChangedListener(getTextWatcher());
        photoFab.setOnClickListener(this);
        addressField.setOnClickListener(this);

        setAddressField(null);
    }

    private void setUpNameFiled() {
        nameField.setBackgroundColor(Color.argb(70, 0, 0, 0));
        setScroll(nameField);
    }

    private void mapWidgets() {
        photoFab = (FloatingActionButton) findViewById(R.id.photoFab);
        logoView = (ImageView) findViewById(R.id.editLogo);
        nameField = (EditText) findViewById(R.id.companyNameField);
        addressField = (TextView) findViewById(R.id.addressTV);
    }

    @NonNull
    private TextWatcher getTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                setOnRegistrationMenuItemVisibility(s.toString(), logo);
                setOnLoginMenuItemVisibility(s.toString());
            }
        };
    }

    @Override
    protected void onPause() {
        super.onPause();
        hideSpinner();
    }

    private void setAddressField(String address) {
        if (address == null) {
            if (isFirstTime) {
                addressField.setText(R.string.text_choose_location);
            } else {
                addressField.setText(TaskApp.getInstance().getCurrentCustomer().getAddress());
            }
        } else {
            addressField.setText(address);
        }
    }

    private void setScroll(EditText field) {
        field.setScroller(new Scroller(this));
        field.setMovementMethod(new ScrollingMovementMethod());
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        saveMenuItem = menu.findItem(R.id.action_save);
        setOnLoginMenuItemVisibility(nameField.getText().toString());
        return true;
    }

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
                if (logo != null) {
                    sendLogoToStorage(logo);
                }
                if (downloadedPhoto == null) {
                    saveCustomerDataInDB(null);
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
            logo = data.getData();
            setupGlide(this, logo.toString(), logoView);

        }
        if (requestCode == Constants.RequestCodes.REQUEST_CAMERA && resultCode == RESULT_OK) {
            galleryAddPic();
            logo = Uri.fromFile(new File(currentPhotoPath));
            setupGlide(this, logo.toString(), logoView);
        }

        if (requestCode == Constants.RequestCodes.REQUEST_LOCATION && resultCode == RESULT_OK) {
            location = data.getParcelableExtra(Constants.LOCATION);
            address = data.getStringExtra(Constants.ADDRESS);
            setAddressField(address);
            setOnRegistrationMenuItemVisibility(nameField.getText().toString(), logo);
            setOnLoginMenuItemVisibility(nameField.getText().toString());
        }
    }

    private File createImageFile() throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        File imagesFolder = new File(Environment.getExternalStorageDirectory(), "TaskAppImages");
        imagesFolder.mkdirs();

        File image = new File(imagesFolder, "LOGO_" + timeStamp + ".png");

        currentPhotoPath = image.getAbsolutePath();
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
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri uriSavedImage = Uri.fromFile(photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
                startActivityForResult(takePictureIntent, Constants.RequestCodes.REQUEST_CAMERA);
            }
        }
    }

    private void galleryAddPic() {

        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(currentPhotoPath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
    }

    long getInternalMemoryAvailable() {
        StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long bytesAvailable = stat.getFreeBytes();
        return bytesAvailable / 1048576;
    }

    private void sendLogoToStorage(Uri logo) {
        if (logo != null) {
            showSpinner();
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
                        downloadedPhoto = taskSnapshot.getDownloadUrl();
                    }
                    saveCustomerDataInDB(downloadedPhoto.toString());
                    setOnRegistrationMenuItemVisibility(nameField.getText().toString(), downloadedPhoto);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d(Constants.TAG, "onFailure: " + e.getMessage());
                }
            });
        }
    }

    private void saveCustomerDataInDB(@Nullable String logo) {
        if (isFirstTime) {
            Customer customer = new Customer(
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
            if (logo != null) {
                TaskApp.getInstance().getCurrentCustomer().setLogo(logo);
            }

            TaskApp.getInstance().getCurrentCustomer().setAddress(addressField.getText().toString());
        }

        FirebaseDatabase.getInstance().getReference(Constants.FirebaseReferences.CUSTOMERS).child(TaskApp.getInstance().getCustomerId()).setValue(TaskApp.getInstance().getCurrentCustomer()).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                hideSpinner();
                startActivity(new Intent(EditProfileActivity.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(EditProfileActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
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
        intent.setType(Constants.IMAGE);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, chooserTitle), Constants.RequestCodes.REQUEST_LIBRARY);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (downloadedPhoto != null) {
            outState.putString(Constants.LOGO, downloadedPhoto.toString());
        }
        outState.putString(Constants.NAME, nameField.getText().toString());
        outState.putString(Constants.ADDRESS, addressField.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            nameField.setText(savedInstanceState.getString(Constants.NAME));
            setupGlide(this, savedInstanceState.getString(Constants.LOGO), logoView);
            setAddressField(savedInstanceState.getString(Constants.ADDRESS));
        }
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case Constants.RequestCodes.REQUEST_READ_STORAGE_PERMISSION: {
                if (grantResults.length > 0
                        && Objects.equals(permissions[0], android.Manifest.permission.READ_EXTERNAL_STORAGE)
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    getLogoFromGallery();
                }
            }

            case Constants.RequestCodes.REQUEST_CAMERA_PERMISSION: {
                if (grantResults.length > 0
                        && Objects.equals(permissions[0], Manifest.permission.CAMERA)
                        && Objects.equals(permissions[1], Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    dispatchTakePictureIntent();
                }
            }
        }
    }

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

    private AlertDialog getAlertDialog(CharSequence[] items) {
        return new AlertDialog.Builder(EditProfileActivity.this)
                .setTitle(R.string.text_add_photo_title)
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                if (ActivityCompat.checkSelfPermission(EditProfileActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                                    requestDocumentsPermissions();
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

    private void setOnRegistrationMenuItemVisibility(String name, Uri logo) {
        if (checkSaveMenuItemExistance()) return;
        if (isFirstTime) {
            if (name.length() >= 3 && !Objects.equals(addressField.getText().toString(), getString(R.string.text_choose_location)) && logo != null) {
                saveMenuItem.setEnabled(true);
            }
        }
    }

    private void setOnLoginMenuItemVisibility(String name) {
        if (checkSaveMenuItemExistance()) return;
        if (name.length() >= 3
                    && !Objects.equals(addressField.getText().toString(), getString(R.string.text_choose_location))
                    && !addressField.getText().toString().isEmpty()) {
                saveMenuItem.setEnabled(true);
            } else {
                saveMenuItem.setEnabled(false);
        }
    }

    private boolean checkSaveMenuItemExistance() {
        return saveMenuItem == null;
    }

    private void requestDocumentsPermissions() {
        ActivityCompat.requestPermissions(EditProfileActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.MANAGE_DOCUMENTS}, Constants.RequestCodes.REQUEST_READ_STORAGE_PERMISSION);
    }

    private void requestCameraPermissions() {
        ActivityCompat.requestPermissions(EditProfileActivity.this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, Constants.RequestCodes.REQUEST_CAMERA_PERMISSION);
    }
}