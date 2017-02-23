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

    private String downloadedPhoto;
    private ImageView logoView;
    private EditText nameField;
    private FloatingActionButton photoFab;
    private TextView addressTV;
    private String currentPhotoPath;
    private LatLng location;

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

        photoFab = (FloatingActionButton) findViewById(R.id.photoFab);
        logoView = (ImageView) findViewById(R.id.editLogo);
        nameField = (EditText) findViewById(R.id.companyNameField);
        nameField.setBackgroundColor(Color.argb(70, 0, 0, 0));

        if (TaskApp.getInstance().getCurrentCustomer() != null && TaskApp.getInstance().getCurrentCustomer().getName() != null) {
            nameField.setText(TaskApp.getInstance().getCurrentCustomer().getName());
            nameField.setSelection(nameField.getText().length());
        }

        setScroll(nameField);

        if (TaskApp.getInstance().getCurrentCustomer() != null && TaskApp.getInstance().getCurrentCustomer().getLogo() != null) {
            setupGlide(this, TaskApp.getInstance().getCurrentCustomer().getLogo(), logoView);
        }

        photoFab.setOnClickListener(this);

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
        ActivityCompat.requestPermissions(EditProfileActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.MANAGE_DOCUMENTS}, Constants.RequestCodes.REQUEST_READ_STORAGE_PERMISSION);
    }

    private void requestCameraPermissions() {
        ActivityCompat.requestPermissions(EditProfileActivity.this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, Constants.RequestCodes.REQUEST_CAMERA_PERMISSION);
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
            Uri contentUri = Uri.fromFile(new File(currentPhotoPath));
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

        File imagesFolder = new File(Environment.getExternalStorageDirectory(), "TasksCustomer");
        imagesFolder.mkdirs();


        File image = File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir
        );

        http://stackoverflow.com/questions/12995185/android-taking-photos-and-saving-them-with-a-custom-name-to-a-custom-destinati
        currentPhotoPath = image.getAbsolutePath();
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
        File f = new File(currentPhotoPath);
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
            outState.putString(Constants.LOGO, downloadedPhoto);
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