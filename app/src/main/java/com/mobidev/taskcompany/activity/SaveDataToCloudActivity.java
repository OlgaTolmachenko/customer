package com.mobidev.taskcompany.activity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.mobidev.taskcompany.R;
import com.mobidev.taskcompany.TaskApp;
import com.mobidev.taskcompany.util.Constants;

/**
 * Created by olga on 27.02.17.
 */

public class SaveDataToCloudActivity extends BaseActivity {

    private Uri downloadedPhoto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_data_to_cloud);
    }

    protected Uri sendLogoToStorage(final Uri logo) {
            showProgressWithFabAndAppbar();
            FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();

            MimeTypeMap mime = MimeTypeMap.getSingleton();
            ContentResolver contentResolver = this.getContentResolver();
            mime.getExtensionFromMimeType(contentResolver.getType(logo));

            StorageReference logoRef = getStorageReference(logo, firebaseStorage, mime, contentResolver);

            UploadTask uploadTask = logoRef.putFile(logo);
            uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    if (taskSnapshot != null) {
                        downloadedPhoto = taskSnapshot.getDownloadUrl();
                    }
                    sendCustomerToDatabase();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d(Constants.TAG, "onFailure: " + e.getMessage());
                }
            });
        return downloadedPhoto;
    }

    private StorageReference getStorageReference(Uri logo, FirebaseStorage firebaseStorage, MimeTypeMap mime, ContentResolver cR) {
        return firebaseStorage.getReferenceFromUrl(Constants.STORAGE_REF).child(Constants.IMG + System.currentTimeMillis() + "." + mime.getExtensionFromMimeType(cR.getType(logo)));
    }

    protected void sendCustomerToDatabase() {
        FirebaseDatabase.getInstance().getReference(Constants.FirebaseReferences.CUSTOMERS).child(TaskApp.getInstance().getCustomerId()).setValue(TaskApp.getInstance().getCurrentCustomer())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        hideProgressWithFabAndAppbar();
                        startActivity(new Intent(SaveDataToCloudActivity.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SaveDataToCloudActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }


}
