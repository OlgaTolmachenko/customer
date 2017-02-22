package com.mobidev.taskcompany.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ResultCodes;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.mobidev.taskcompany.R;
import com.mobidev.taskcompany.TaskApp;
import com.mobidev.taskcompany.fragment.TasksByCategoryFragment;
import com.mobidev.taskcompany.fragment.TasksByDateCreatedFragment;
import com.mobidev.taskcompany.fragment.TasksByDueDateFragment;
import com.mobidev.taskcompany.fragment.TasksByNameFragment;
import com.mobidev.taskcompany.model.Customer;
import com.mobidev.taskcompany.model.Task;
import com.mobidev.taskcompany.util.Constants;
import com.mobidev.taskcompany.util.TaskPagerAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private final String TAG = this.getClass().getSimpleName();

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private ValueEventListener customerListener;
    private ValueEventListener taskListener;
    private ArrayList<Task> taskList;
    private TextView navName;
    private ImageView navLogo;
    private String customerId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showProgress();

        taskList = new ArrayList<>();
        mAuth = FirebaseAuth.getInstance();

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                showProgress();
                if (user != null) {
                    customerId = user.getUid();
                    TaskApp.getInstance().setCustomerId(customerId);
                    onSignedInInitialize(customerId);

                } else {
                    onSignedOutCleanUp();
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setProviders(Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                                                new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build(),
                                                                new AuthUI.IdpConfig.Builder(AuthUI.FACEBOOK_PROVIDER).build(),
                                                                new AuthUI.IdpConfig.Builder(AuthUI.TWITTER_PROVIDER).build()))
                                    .build(),
                            Constants.RequestCodes.REQUEST_SIGN_IN);
                }
            }
        };

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CreateTaskActivity.class));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View navHeader = navigationView.getHeaderView(0);
        navName = (TextView) navHeader.findViewById(R.id.nav_name);
        navLogo = (ImageView) navHeader.findViewById(R.id.nav_logo);
    }

    private void onSignedInInitialize(String id) {
        showProgress();
        attachCustomerEventListener(id);
    }

    private void onSignedOutCleanUp() {
        taskList.clear();
        detachCustomerEventListener();
        detachTasksEventListener();
    }

    private void attachCustomerEventListener(final String customerId) {
        if (customerListener == null) {
            customerListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    showProgress();
                    if (dataSnapshot.getValue() == null) {
                        showProgress();
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable(){
                            @Override
                            public void run(){
                                startActivity(new Intent(MainActivity.this, EditProfileActivity.class).putExtra("id", customerId).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
                            }
                        }, 1000);
                    } else {

                        final Customer incomingCustomer = dataSnapshot.getValue(Customer.class);
                        TaskApp.getInstance().setCurrentCustomer(incomingCustomer);

                        setupGlide(MainActivity.this, incomingCustomer.getLogo(), navLogo);
                        navName.setText(incomingCustomer.getName());

                        attachTasksEventListener(incomingCustomer.getUid());
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.d(TAG, "onCancel: " + databaseError);
                }
            };
            FirebaseDatabase.getInstance().getReference(Constants.FirebaseReferences.CUSTOMERS).child(customerId).addValueEventListener(customerListener);
        }
    }

    private void attachTasksEventListener(String customerId) {

        if (taskListener == null) {
            taskListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    hideProgress();

                    for (DataSnapshot task : dataSnapshot.getChildren()) {
                        Task incomingTask = task.getValue(Task.class);
                        taskList.add(incomingTask);
                    }

                    ViewPager viewPager = (ViewPager) findViewById(R.id.taskViewPager);
                    addAllPages(viewPager);

                    TabLayout tabLayout = (TabLayout) findViewById(R.id.taskTab);
                    tabLayout.setupWithViewPager(viewPager);
                    tabLayout.addOnTabSelectedListener(tabListener(viewPager));

                    TaskApp.getInstance().setTaskCount(taskList.size());
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.d(TAG, "onCancel: " + databaseError);
                }
            };
            FirebaseDatabase.getInstance().getReference(Constants.FirebaseReferences.TASKS).orderByChild(Constants.FirebaseReferences.OWNER_UID).equalTo(customerId).addValueEventListener(taskListener);
        }
    }

    private void detachCustomerEventListener() {
        if (customerListener != null) {
            FirebaseDatabase.getInstance().getReference(Constants.FirebaseReferences.CUSTOMERS).child(customerId).removeEventListener(customerListener);
            customerListener = null;
        }
    }

    private void detachTasksEventListener() {
        if (taskListener != null) {
            FirebaseDatabase.getInstance().getReference(Constants.FirebaseReferences.TASKS).orderByChild(Constants.FirebaseReferences.OWNER_UID).equalTo(customerId).removeEventListener(taskListener);
            taskListener = null;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mAuth != null) {
            mAuth.removeAuthStateListener(authStateListener);
        }
        detachCustomerEventListener();
        detachTasksEventListener();
        taskList.clear();
        hideProgress();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                AuthUI.getInstance().signOut(this);
                return true;
            case R.id.action_profile:
                startActivity(new Intent(this, ProfileActivity.class));
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.RequestCodes.REQUEST_SIGN_IN) {
            if (resultCode == ResultCodes.OK) {
                TaskApp.getInstance().setCurrentCustomer(null);
            }
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
        } else if (id == R.id.nav_gallery) {
        } else if (id == R.id.nav_slideshow) {
        } else if (id == R.id.nav_manage) {
        } else if (id == R.id.nav_share) {
        } else if (id == R.id.nav_send) {
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void addAllPages(ViewPager pager) {
        TaskPagerAdapter pagerAdapter = new TaskPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addPage(TasksByCategoryFragment.newInstance(turnTasksListToJson(taskList)));
        pagerAdapter.addPage(TasksByDateCreatedFragment.newInstance(turnTasksListToJson(taskList)));
        pagerAdapter.addPage(TasksByDueDateFragment.newInstance(turnTasksListToJson(taskList)));
        pagerAdapter.addPage(TasksByNameFragment.newInstance(turnTasksListToJson(taskList)));
        pager.setAdapter(pagerAdapter);
    }

    private String turnTasksListToJson(ArrayList<Task> tasks) {
        Gson gson = new Gson();
        return gson.toJson(tasks);
    }

    private TabLayout.OnTabSelectedListener tabListener(final ViewPager pager) {
        return new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        };
    }
}