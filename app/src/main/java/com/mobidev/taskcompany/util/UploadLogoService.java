package com.mobidev.taskcompany.util;

import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

<<<<<<< HEAD
<<<<<<< HEAD
=======
/**
 * Created by olga on 13.01.17.
 */

>>>>>>> 330f4ea... map ready
=======
>>>>>>> 3497b4d... refactoring
public class UploadLogoService extends IntentService {

    public UploadLogoService() {
        super("UploadLogoService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("LOG", "onHandleIntent: ");
        uploadLogoAndPostUser(intent.getData());
    }

    private void uploadLogoAndPostUser(Uri logo) {
//        final Uri[] logoUriInStorage = new Uri[1];
        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
        StorageReference myStorage = firebaseStorage.getReferenceFromUrl("gs://taskdispatcher-bb18b.appspot.com");
        //You cannot upload data with a reference to the root of your Google Cloud Storage bucket.
        // Your reference must point to a child URL.
        StorageReference logoRef = myStorage.child("images/logo.jpg");
        if (logo == null) {
            logo = Uri.parse("");
        }
        UploadTask uploadTask = logoRef.putFile(logo);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("LOG", "onFailure: " + e.getMessage());
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Uri downloadedPhoto = taskSnapshot.getDownloadUrl();
                Log.d("LOG", "onSuccess: " + downloadedPhoto);
//                sendUserDataToDB(downloadedPhoto);
                LocalBroadcastManager.getInstance(UploadLogoService.this).sendBroadcast((new Intent("com.mobidev.taskcompany.LOGO").setData( downloadedPhoto)));
            }
        });
    }
}
