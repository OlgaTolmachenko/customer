package com.mobidev.taskcompany.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.provider.MediaStore;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by olga on 24.02.17.
 */

public class CameraHelper {

    private String photoPath;
    private Activity context;

    public CameraHelper(Activity context) {
        this.context = context;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String photoName = "LOGO_" + timeStamp + ".png";
        File imagesFolder = new File(Environment.getExternalStorageDirectory(), "TaskAppImages");
        imagesFolder.mkdirs();
        File image = new File(imagesFolder, photoName);
        photoPath = image.getAbsolutePath();
        return image;
    }


    public void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(context.getPackageManager()) != null) {
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
            }
            if (photoFile != null) {
                Uri uriSavedImage = Uri.fromFile(photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
                context.startActivityForResult(takePictureIntent, Constants.RequestCodes.REQUEST_CAMERA);
            }
        }
    }

    public void addPickToGallery() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(photoPath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        context.sendBroadcast(mediaScanIntent);
    }

    private long getInternalMemoryAvailable() {
        StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long bytesAvailable = stat.getFreeBytes();
        return bytesAvailable / 1048576;
    }

}
