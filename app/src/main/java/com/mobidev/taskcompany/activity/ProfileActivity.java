package com.mobidev.taskcompany.activity;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
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

<<<<<<< HEAD
import java.io.File;

<<<<<<< HEAD
=======
>>>>>>> d95c681... Refactoring activities
public class ProfileActivity extends BaseActivity
        implements AppBarLayout.OnOffsetChangedListener {

    private FloatingActionButton fab;
    private MenuItem item;
    private CollapsingToolbarLayout collapsingToolbar;
=======
=======
import android.graphics.Color;
>>>>>>> e0a7c7b... ready
import android.net.Uri;
=======
import android.content.Intent;
>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen
=======
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
<<<<<<< HEAD
>>>>>>> a04eacf... Fix profile saving to DB
=======
=======
import android.content.Intent;
>>>>>>> 35d04a3... Fix Camera. Fix Location
import android.net.Uri;
>>>>>>> 4f5e128... Fix documents permission
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
<<<<<<< HEAD

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
public class ProfileActivity extends AppCompatActivity {
>>>>>>> 8eeaa9a... add collapsing layout
=======
public class ProfileActivity extends AppCompatActivity
        implements AppBarLayout.OnOffsetChangedListener
{
=======
=======
import static com.mobidev.taskcompany.R.id.addressTV;
import static com.mobidev.taskcompany.util.Constants.ADDRESS;
import static com.mobidev.taskcompany.util.Constants.LOGO;
import static com.mobidev.taskcompany.util.Constants.NAME;
=======
import com.mobidev.taskcompany.TaskApp;
>>>>>>> 8eef402... Fix CreateActivity sending tasks bug.

>>>>>>> a04eacf... Fix profile saving to DB
=======
>>>>>>> 8748201... fix
public class ProfileActivity extends BaseActivity
        implements AppBarLayout.OnOffsetChangedListener {
>>>>>>> 080411d... Capture photo from camera

<<<<<<< HEAD
    FloatingActionButton fab;
    boolean isCollapsed;
    MenuItem item;
    CollapsingToolbarLayout collapsingToolbar;
>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen
=======
    private FloatingActionButton fab;
    private MenuItem item;
    private CollapsingToolbarLayout collapsingToolbar;
>>>>>>> a04eacf... Fix profile saving to DB

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
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
        tasksNumber.setText("Tasks count: " + TaskApp.getInstance().getTaskCount());


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
=======
=======

<<<<<<< HEAD
=======
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("size", getIntent().getIntExtra("size", 0));
        editor.apply();

>>>>>>> a04eacf... Fix profile saving to DB

>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
=======
=======
>>>>>>> 3b9bd70... Bugfix
        Toolbar toolbar = (Toolbar) findViewById(R.id.profileToolbar);
>>>>>>> 080411d... Capture photo from camera
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

<<<<<<< HEAD
>>>>>>> 8eeaa9a... add collapsing layout
=======
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
>>>>>>> 2198a3f... Change EditProfile UI/UX. Push Map to a new Screen
}
