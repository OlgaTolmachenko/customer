package com.mobidev.taskcompany.activity;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
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

    private ProgressBar progressBar;
    private FrameLayout progressBarBackground;
    private FloatingActionButton photoFab;
    private AppBarLayout appBarLayout;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        initViews();
    }

    private void initViews() {
        progressBar = (ProgressBar) findViewById(R.id.taskProgressBar);
        progressBarBackground = (FrameLayout) findViewById(R.id.whiteScreen);
        photoFab = (FloatingActionButton) findViewById(R.id.photoFab);
        appBarLayout = (AppBarLayout) findViewById(R.id.editProfileAppBar);
    }

    protected void showProgress() {
        progressBarBackground.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);
    }

    protected void hideProgress() {
        progressBarBackground.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
    }

    protected void showProgressWithFabAndAppbar() {
        showProgress();
        photoFab.setVisibility(View.GONE);
        appBarLayout.setVisibility(View.GONE);
    }

    protected void hideProgressWithFabAndAppbar() {
        hideProgress();
        hideKeyboard();
        photoFab.setVisibility(View.VISIBLE);
        appBarLayout.setVisibility(View.VISIBLE);
    }

    protected void hideKeyboard() {
        View focusedView = getCurrentFocus();
        if (focusedView == null) {
            return;
        }
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(focusedView.getWindowToken(), 0);
    }

    public static void setupGlide(Activity context, String logoUri, ImageView view) {
        Glide.with(context)
                .load(logoUri)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(view);
    }
}