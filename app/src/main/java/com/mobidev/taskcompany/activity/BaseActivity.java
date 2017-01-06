package com.mobidev.taskcompany.activity;

<<<<<<< HEAD
<<<<<<< HEAD
import android.app.Activity;
import android.content.Context;
<<<<<<< HEAD
import android.net.Uri;
<<<<<<< HEAD
=======
import android.content.Context;
import android.os.Bundle;
>>>>>>> 64f37b7... Add progressBars
=======
import android.app.Activity;
import android.content.Context;
>>>>>>> 080411d... Capture photo from camera
=======
>>>>>>> 4f5e128... Fix documents permission
=======
>>>>>>> d95c681... Refactoring activities
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
<<<<<<< HEAD
<<<<<<< HEAD
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mobidev.taskcompany.R;
<<<<<<< HEAD

import java.io.File;

abstract class BaseActivity extends AppCompatActivity {

    public final String TAG = "MY_LOG_TAG";

=======
=======
import android.widget.ImageView;
>>>>>>> 080411d... Capture photo from camera
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mobidev.taskcompany.company.R;

/**
 * Created by olga on 23.01.17.
 */
=======
>>>>>>> 3497b4d... refactoring

abstract class BaseActivity extends AppCompatActivity {

<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 64f37b7... Add progressBars
=======
    public final String TAG = "MY_LOG_TAG";

>>>>>>> 4f5e128... Fix documents permission
=======
>>>>>>> d95c681... Refactoring activities
    private ProgressBar progress;
    private FrameLayout whiteScreen;

    @Override
<<<<<<< HEAD
<<<<<<< HEAD
=======
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("LOG", "BASE_ACT onCreate: ");
    }

    @Override
>>>>>>> 64f37b7... Add progressBars
=======
>>>>>>> ce4de03... Add handler for pause
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        progress = (ProgressBar) findViewById(R.id.taskProgressBar);
        whiteScreen = (FrameLayout) findViewById(R.id.whiteScreen);
    }

    protected void showProgress() {
        whiteScreen.setVisibility(View.VISIBLE);
        progress.setVisibility(View.VISIBLE);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        Log.d("MY_LOG_TAG", "showProgress: ");
=======
        Log.d("LOG", "showProgress: ");
>>>>>>> 64f37b7... Add progressBars
=======
        Log.d("MY_LOG_TAG", "showProgress: ");
>>>>>>> ce4de03... Add handler for pause
=======
>>>>>>> d95c681... Refactoring activities
    }

    protected void hideProgress() {
        whiteScreen.setVisibility(View.GONE);
<<<<<<< HEAD
<<<<<<< HEAD
        progress.setVisibility(View.GONE);
<<<<<<< HEAD
        Log.d("MY_LOG_TAG", "hideProgress: ");
=======
        progress.setVisibility(View.INVISIBLE);
<<<<<<< HEAD
        Log.d("LOG", "hideProgress: ");
>>>>>>> 64f37b7... Add progressBars
=======
=======
        progress.setVisibility(View.GONE);
>>>>>>> ee37b44... fix timepick
        Log.d("MY_LOG_TAG", "hideProgress: ");
>>>>>>> ce4de03... Add handler for pause
=======
>>>>>>> d95c681... Refactoring activities
    }

    protected void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
<<<<<<< HEAD
<<<<<<< HEAD
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

<<<<<<< HEAD
<<<<<<< HEAD
    public void setupGlide(Activity context, Uri logoUri, ImageView view) {
        Glide.with(context)
                .load(logoUri)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(view);
    }
<<<<<<< HEAD
=======
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
>>>>>>> 64f37b7... Add progressBars
=======
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void setupGlide(Activity context, String logoUri, ImageView view) {
=======

    public void setupGlide(Activity context, File logoUri, ImageView view) {
>>>>>>> 2a78416... temp
=======
//    public void setupGlide(Activity context, Uri logoUri, ImageView view) {
//        Glide.with(context)
//                .load(logoUri)
//                .centerCrop()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(view);
//    }

=======
>>>>>>> 762f2c5... Add status NEW when creating tasks. Add ItemDecorator to tasks recyclerview. Fix margins. Add task random title and body
    public void setupGlide(Activity context, String logoUri, ImageView view) {
>>>>>>> 4d67dd1... Fix set logo on re-sign-in. Move Customer_ID to Owner
        Glide.with(context)
                .load(logoUri)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(view);
    }
<<<<<<< HEAD
<<<<<<< HEAD

>>>>>>> 080411d... Capture photo from camera
=======
>>>>>>> 3497b4d... refactoring
=======
>>>>>>> 2a78416... temp
}
