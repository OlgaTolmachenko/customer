package com.mobidev.taskcompany.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobidev.taskcompany.R;
import com.mobidev.taskcompany.TaskApp;

public class ProfileActivity extends BaseActivity
        implements AppBarLayout.OnOffsetChangedListener {

    private FloatingActionButton fab;
    private MenuItem item;
    private CollapsingToolbarLayout collapsingToolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.profileToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.profileCollapsingToolbar);
        collapsingToolbar.setTitle(TaskApp.getInstance().getCurrentCustomer().getName());

        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.profileAppBar);
        appBarLayout.addOnOffsetChangedListener(this);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, EditProfileActivity.class));
            }
        });

        ImageView headerLogoView = (ImageView) findViewById(R.id.headerLogo);
        setupGlide(this, TaskApp.getInstance().getCurrentCustomer().getLogo(), headerLogoView);

        TextView tasksNumber = (TextView) findViewById(R.id.tasksNumber);
        tasksNumber.setText(getString(R.string.text_tasks_count, TaskApp.getInstance().getTaskCount()));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        item = menu.findItem(R.id.edit);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.edit:
                startActivity(new Intent(ProfileActivity.this, EditProfileActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (item != null) {
            if (collapsingToolbar.getHeight()
                    + verticalOffset < 2
                    * ViewCompat.getMinimumHeight(collapsingToolbar)) {
                invalidateOptionsMenu();
                item.setVisible(true);
            } else {
                invalidateOptionsMenu();
                item.setVisible(false);
            }
        }
    }
}