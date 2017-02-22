package com.mobidev.taskcompany.activity;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mobidev.taskcompany.R;

abstract class BaseActivity  extends AppCompatActivity {

    private ProgressBar progress;
    private FrameLayout whiteScreen;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        progress = (ProgressBar) findViewById(R.id.taskProgressBar);
        whiteScreen = (FrameLayout) findViewById(R.id.whiteScreen);
    }

    protected void showProgress() {
        whiteScreen.setVisibility(View.VISIBLE);
        progress.setVisibility(View.VISIBLE);
    }

    protected void hideProgress() {
        whiteScreen.setVisibility(View.GONE);
        progress.setVisibility(View.GONE);
    }

    protected void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void setupGlide(Activity context, String logoUri, ImageView view) {
        Glide.with(context)
                .load(logoUri)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(view);
    }
}