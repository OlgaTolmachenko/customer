package com.mobidev.taskcompany.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Scroller;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;
import com.mobidev.taskcompany.R;
import com.mobidev.taskcompany.TaskApp;
import com.mobidev.taskcompany.model.Customer;
import com.mobidev.taskcompany.model.TaskLatLng;
import com.mobidev.taskcompany.util.CameraHelper;
import com.mobidev.taskcompany.util.Constants;
import com.mobidev.taskcompany.util.Role;

import java.io.File;
import java.util.Objects;

public class EditProfileActivity extends SaveDataToCloudActivity implements View.OnClickListener {

    private ImageView logoView;
    private EditText nameField;
    private FloatingActionButton photoFab;
    private TextView addressField;
    private LatLng location;
    private boolean isFirstTime;
    private Uri logo;
    private CollapsingToolbarLayout collapsingToolbar;
    private Toolbar toolbar;
    private AppBarLayout appBarLayout;
    private MenuItem saveMenuItem;
    private CameraHelper cameraHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        mapWidgets();
        hideProgress();
        setSupportActionBar(toolbar);
        showUpButton();
        setUpActionBarTitle();
        collapsingToolbar.setTitle("");
        setUpNameFiled();

        if (TaskApp.getInstance().getCurrentCustomer() == null) {
            isFirstTime = true;
        } else {
            setupGlide(this, TaskApp.getInstance().getCurrentCustomer().getLogo(), logoView);
            nameField.setText(TaskApp.getInstance().getCurrentCustomer().getName());
            nameField.setSelection(nameField.getText().length());
            setSaveItemEnabled();
            setAddressField(TaskApp.getInstance().getCurrentCustomer().getAddress());
        }

        nameField.addTextChangedListener(getTextWatcher());
        photoFab.setOnClickListener(this);
        addressField.setOnClickListener(this);
        cameraHelper = new CameraHelper(this);
        setAddressField(null);
    }

    private void setUpActionBarTitle() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    private void showUpButton() {
        if (TaskApp.getInstance().getCurrentCustomer() != null && getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setUpNameFiled() {
        nameField.setBackgroundColor(Color.argb(70, 0, 0, 0));
    }

    private void mapWidgets() {
        photoFab = (FloatingActionButton) findViewById(R.id.photoFab);
        logoView = (ImageView) findViewById(R.id.editLogo);
        nameField = (EditText) findViewById(R.id.companyNameField);
        addressField = (TextView) findViewById(R.id.addressTV);
        toolbar = (Toolbar) findViewById(R.id.editProfileToolbar);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.profileCollapsingToolbar);
        appBarLayout = (AppBarLayout) findViewById(R.id.editProfileAppBar);
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
                setSaveItemEnabled();
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

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        saveMenuItem = menu.findItem(R.id.action_save);
        setSaveItemEnabled();
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

                if (!isFirstTime) {
                    TaskApp.getInstance().getCurrentCustomer().setName(nameField.getText().toString());
                }

                if (isEveryFieldFilledIn()) {

                    if (isFirstTime) {
                        prepareCustomer(logo.toString());
                    }

                    if (logo != null) {
                        sendLogoToStorage(logo);
                    } else {
                        sendCustomerToDatabase();
                    }
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case Constants.RequestCodes.REQUEST_LIBRARY:
                    logo = data.getData();
                    setupGlide(this, logo.toString(), logoView);
                    if (!isFirstTime) TaskApp.getInstance().getCurrentCustomer().setLogo(logo.toString());
                    setSaveItemEnabled();
                    break;
                case Constants.RequestCodes.REQUEST_CAMERA:
                    cameraHelper.addPickToGallery();
                    logo = Uri.fromFile(new File(cameraHelper.getPhotoPath()));
                    setupGlide(this, logo.toString(), logoView);
                    setSaveItemEnabled();
                    break;
                case Constants.RequestCodes.REQUEST_LOCATION:
                    location = data.getParcelableExtra(Constants.LOCATION);
                    String address = data.getStringExtra(Constants.ADDRESS);
                    setAddressField(address);
                    if (!isFirstTime) {
                        TaskApp.getInstance().getCurrentCustomer().setLocation(new TaskLatLng(location.latitude, location.longitude));
                        TaskApp.getInstance().getCurrentCustomer().setAddress(address);
                    }
                    setSaveItemEnabled();
                    break;
            }
        }
    }

    private void prepareCustomer(@Nullable String logo) {
        if (isFirstTime) {
            Customer customer = new Customer(
                    nameField.getText().toString(),
                    TaskApp.getInstance().getCustomerId(),
                    Role.CUSTOMER,
                    logo,
                    new TaskLatLng(location.latitude, location.longitude),
                    addressField.getText().toString()
            );
            TaskApp.getInstance().setCurrentCustomer(customer);
        }
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

                    cameraHelper.dispatchTakePictureIntent();
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
                                    cameraHelper.dispatchTakePictureIntent();
                                }
                                break;
                        }
                    }
                }).create();
    }

    private void setSaveItemEnabled() {
        if (isSaveItemNull()) return;
        if (isFirstTime) {
            saveMenuItem.setEnabled(false);
        }
        if (isEveryFieldFilledIn()) {
            saveMenuItem.setEnabled(true);
        } else {
            saveMenuItem.setEnabled(false);
        }
    }

    private boolean isEveryFieldFilledIn() {
        return nameField.getText().toString().length() >= 3
                && !Objects.equals(addressField.getText().toString(), getString(R.string.text_choose_location))
                && !Objects.equals(addressField.getText().toString(), "")
                && (logo != null || (TaskApp.getInstance().getCurrentCustomer() != null && TaskApp.getInstance().getCurrentCustomer().getLogo() != null));
    }

    private boolean isSaveItemNull() {
        return saveMenuItem == null;
    }

    private void requestDocumentsPermissions() {
        ActivityCompat.requestPermissions(EditProfileActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.MANAGE_DOCUMENTS}, Constants.RequestCodes.REQUEST_READ_STORAGE_PERMISSION);
    }

    private void requestCameraPermissions() {
        ActivityCompat.requestPermissions(EditProfileActivity.this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, Constants.RequestCodes.REQUEST_CAMERA_PERMISSION);
    }
}