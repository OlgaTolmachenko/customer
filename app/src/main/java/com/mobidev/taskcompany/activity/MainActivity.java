package com.mobidev.taskcompany.activity;

import android.content.Intent;
import android.os.Bundle;
<<<<<<< HEAD
<<<<<<< HEAD
import android.os.Handler;
=======
>>>>>>> 330f4ea... map ready
=======
import android.os.Handler;
>>>>>>> ce4de03... Add handler for pause
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
=======
import android.support.design.widget.Snackbar;
>>>>>>> 3bae9b8... NavView Image and Text plased.
=======
>>>>>>> d184d09... Task creation and DB saving added
=======
import android.support.design.widget.TabLayout;
<<<<<<< HEAD
import android.support.v4.app.Fragment;
>>>>>>> dabb3d3... Implement taskpager fragments
=======
>>>>>>> 1335be7... Refactor resources
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import android.support.v7.app.AppCompatActivity;
<<<<<<< HEAD
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
>>>>>>> d9e6e1c... Implmenting List
=======
>>>>>>> dabb3d3... Implement taskpager fragments
=======
>>>>>>> 64f37b7... Add progressBars
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ResultCodes;
import com.google.firebase.auth.FirebaseAuth;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
=======
>>>>>>> 8d3ad04... Fix SAVE menuitem in BaseMapActivity
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ResultCodes;
import com.google.firebase.auth.FirebaseAuth;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 1d51cc4... Models refactoring. Check DB data sent OK
=======
<<<<<<< HEAD
>>>>>>> dabb3d3... Implement taskpager fragments
import com.google.firebase.database.FirebaseDatabase;
=======
import com.google.firebase.database.ChildEventListener;
=======
>>>>>>> 3ead7f0... rawr
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> dabb3d3... Implement taskpager fragments
=======
=======
>>>>>>> 1c4249d... Fix comflict
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
<<<<<<< HEAD
<<<<<<< HEAD
import com.mobidev.taskcompany.R;
=======
>>>>>>> dabb3d3... Implement taskpager fragments
=======
import com.mobidev.taskcompany.R;
>>>>>>> 3497b4d... refactoring
import com.mobidev.taskcompany.TaskApp;
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 0c7b888... h
=======
import com.google.firebase.auth.FirebaseAuth;
>>>>>>> 330f4ea... map ready
=======
import com.mobidev.taskcompany.TaskApp;
>>>>>>> ad17e39... Implementing ListAdapter
import com.mobidev.taskcompany.company.R;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 3497b4d... refactoring
=======
>>>>>>> 5d7fc19... refactoring
=======
>>>>>>> 1c4249d... Fix comflict
import com.mobidev.taskcompany.fragment.TasksByCategoryFragment;
import com.mobidev.taskcompany.fragment.TasksByDateCreatedFragment;
import com.mobidev.taskcompany.fragment.TasksByDueDateFragment;
import com.mobidev.taskcompany.fragment.TasksByNameFragment;
import com.mobidev.taskcompany.model.Customer;
import com.mobidev.taskcompany.model.Task;
import com.mobidev.taskcompany.util.Constants;
<<<<<<< HEAD
import com.mobidev.taskcompany.util.FirebaseReferences;
<<<<<<< HEAD
=======
>>>>>>> 1335be7... Refactor resources
import com.mobidev.taskcompany.util.TaskPagerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import com.mobidev.taskcompany.model.Task;
=======
import com.mobidev.taskcompany.company.R;
>>>>>>> d00ba80... Implement DatePicker. Implement Category Spinner
=======
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mobidev.taskcompany.TaskApp;
>>>>>>> 0c7b888... h
import com.mobidev.taskcompany.company.R;
import com.mobidev.taskcompany.model.Customer;
import com.mobidev.taskcompany.model.Task;
>>>>>>> 1d51cc4... Models refactoring. Check DB data sent OK
import com.mobidev.taskcompany.util.TaskAdapter;
import com.mobidev.taskcompany.util.UserAuth;
>>>>>>> d184d09... Task creation and DB saving added
=======
import com.mobidev.taskcompany.fragment.TasksByCategoryFragment;
import com.mobidev.taskcompany.fragment.TasksByDateCreatedFragment;
import com.mobidev.taskcompany.fragment.TasksByDueDateFragment;
import com.mobidev.taskcompany.fragment.TasksByNameFragment;
import com.mobidev.taskcompany.model.Customer;
import com.mobidev.taskcompany.model.Task;
=======
>>>>>>> 9246afa... fix creating and sending task
import com.mobidev.taskcompany.util.TaskPagerAdapter;
>>>>>>> dabb3d3... Implement taskpager fragments

import java.util.ArrayList;
import java.util.Arrays;

<<<<<<< HEAD
import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

<<<<<<< HEAD
<<<<<<< HEAD
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
=======
import java.util.concurrent.TimeUnit;
>>>>>>> ce4de03... Add handler for pause
=======
>>>>>>> 3497b4d... refactoring

    private final int RC_SIGN_IN = 123;
=======
import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class MainActivity extends AppCompatActivity
=======
=======
>>>>>>> d95c681... Refactoring activities
public class MainActivity extends BaseActivity
>>>>>>> 64f37b7... Add progressBars
        implements NavigationView.OnNavigationItemSelectedListener {

    private final String TAG = this.getClass().getSimpleName();

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 330f4ea... map ready
=======
    private RecyclerView taskRecycler;
    private TaskAdapter taskAdapter;
    private RecyclerView.LayoutManager taskLM;
<<<<<<< HEAD
>>>>>>> d9e6e1c... Implmenting List
=======
    private DatabaseReference taskDBreference;
    private TaskChangeListener taskChangeListener;

    private Query myTopPostsQuery;
<<<<<<< HEAD
    private String customerId;
>>>>>>> 1d51cc4... Models refactoring. Check DB data sent OK
=======


    TextView navName;
    ImageView navLogo;
>>>>>>> 92f4cb1... filter tasks
=======
    private TaskAdapter taskAdapter;
=======
>>>>>>> dabb3d3... Implement taskpager fragments
    private ValueEventListener customerListener;
    private ValueEventListener taskListener;
    private ArrayList<Task> taskList;
    private TextView navName;
    private ImageView navLogo;
<<<<<<< HEAD
>>>>>>> f2858f9... temp
=======
    private String customerId;
>>>>>>> dabb3d3... Implement taskpager fragments



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        showProgress();
=======
//        showProgress();
>>>>>>> ce4de03... Add handler for pause
=======
        showProgress();
>>>>>>> 102aa24... architecture OK

        taskList = new ArrayList<>();
<<<<<<< HEAD
        mAuth = FirebaseAuth.getInstance();
=======
>>>>>>> 330f4ea... map ready

        Log.d("MY_LOG_TAG", "onCreate: ACTIVITY_MAIN");

        taskList = new ArrayList<>();
<<<<<<< HEAD
        RecyclerView taskRecycler = (RecyclerView) findViewById(R.id.taskRecycler);
        RecyclerView.LayoutManager taskLM = new LinearLayoutManager(this);
        taskRecycler.setLayoutManager(taskLM);
        taskAdapter = new TaskAdapter(taskList);
        taskRecycler.setAdapter(taskAdapter);

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
<<<<<<< HEAD
<<<<<<< HEAD
                FirebaseUser user = firebaseAuth.getCurrentUser();

                Log.d("MY_LOG_TAG", "onAuthStateChanged: " + user);

                showProgress();
                if (user != null) {
                    customerId = user.getUid();
                    TaskApp.getInstance().setCustomerId(customerId);
                    Log.d(TAG, "You are now signed in.");
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
                            RC_SIGN_IN);
=======
=======

>>>>>>> f2858f9... temp
                if (firebaseAuth.getCurrentUser() == null) {
<<<<<<< HEAD
                    startActivity(new Intent(MainActivity.this, SignInActivity.class).setFlags(FLAG_ACTIVITY_CLEAR_TASK | FLAG_ACTIVITY_NEW_TASK));
<<<<<<< HEAD
>>>>>>> 330f4ea... map ready
=======
                } else {
<<<<<<< HEAD
<<<<<<< HEAD
                    customerId = firebaseAuth.getCurrentUser().getUid();
>>>>>>> 1d51cc4... Models refactoring. Check DB data sent OK
=======

                    FirebaseDatabase.getInstance().getReference("customers").child(firebaseAuth.getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            Customer incomingCustomer = dataSnapshot.getValue(Customer.class);
                            TaskApp.getInstance().setCurrentCustomer(incomingCustomer);

                            Glide.with(MainActivity.this)
                                    .load(incomingCustomer.getLogo())
                                    .centerCrop()
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                                    .into(navLogo);

                            navName.setText(TaskApp.getInstance().getCurrentCustomer().getName());

                            FirebaseDatabase.getInstance().getReference("tasks").orderByChild("customerId").equalTo(incomingCustomer.getUid()).addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    Task incomingTask = dataSnapshot.getValue(Task.class);
//                                    TaskApp.getInstance().setTaskList(incomingTask);
//                                    taskAdapter.notifyDataSetChanged();

                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });


                    taskDBreference. addValueEventListener(setupDBlistener(firebaseAuth.getCurrentUser().getUid()));
>>>>>>> 92f4cb1... filter tasks
=======
=======

                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setProviders(Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                            new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build(),
                                            new AuthUI.IdpConfig.Builder(AuthUI.FACEBOOK_PROVIDER).build(),
                                            new AuthUI.IdpConfig.Builder(AuthUI.TWITTER_PROVIDER).build()))
                                    .build(),
                            RC_SIGN_IN);

                    Log.d("LOG", "onAuthStateChanged:  USER IS NULL ");

                } else {
                    Log.d("LOG", "onAuthStateChanged:  USER - EXISTS ");


>>>>>>> 6b47303... multiple login
                    customerListener = getCustomerEventListener();
                    taskListener = getTasksEventListener();
                    FirebaseDatabase.getInstance().getReference("customers").child(firebaseAuth.getCurrentUser().getUid()).addValueEventListener(customerListener);
                    FirebaseDatabase.getInstance().getReference("tasks").orderByChild("customerId").equalTo(firebaseAuth.getCurrentUser().getUid()).addValueEventListener(taskListener);
>>>>>>> f2858f9... temp
                }
            }
        };

        FirebaseAuth.getInstance().addAuthStateListener(authStateListener);
=======

=======
>>>>>>> ce4de03... Add handler for pause
        mAuth = FirebaseAuth.getInstance();
>>>>>>> dabb3d3... Implement taskpager fragments

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
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> f2858f9... temp
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CreateTaskActivity.class));
            }
        });
<<<<<<< HEAD
=======
        fab.setOnClickListener(goToCreateActivity());
>>>>>>> d184d09... Task creation and DB saving added
=======
>>>>>>> f2858f9... temp

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
<<<<<<< HEAD
<<<<<<< HEAD

        View navHeader = navigationView.getHeaderView(0);
        navName = (TextView) navHeader.findViewById(R.id.nav_name);
        navLogo = (ImageView) navHeader.findViewById(R.id.nav_logo);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> e507f6d... filter tasks
    }
=======
>>>>>>> 4a3619e... lol


        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                Log.d("LOG", "onAuthStateChanged: ");

<<<<<<< HEAD
                if (user != null) {
                    customerId = user.getUid();
                    //user signed in
                    Toast.makeText(MainActivity.this, "You are now signed in.", Toast.LENGTH_SHORT).show();
                    onSignedInInitialize(customerId);

                } else {
                    //user signed out
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
                        RC_SIGN_IN);
                }
            }
        };

//        if (TaskApp.getInstance().getCurrentCustomer() == null) {

            mAuth.addAuthStateListener(authStateListener);
//        }
=======
>>>>>>> edb472c... handler
=======
>>>>>>> 1c4249d... Fix comflict
    }

    private void onSignedInInitialize(String id) {
        showProgress();
<<<<<<< HEAD
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
<<<<<<< HEAD
<<<<<<< HEAD

                        setupGlide(MainActivity.this, incomingCustomer.getLogo(), navLogo);
=======
                        Log.d("MY_LOG_TAG", "attachCustomerEventListener ---- getCurrentCustomer: " + TaskApp.getInstance().getCurrentCustomer());

                        setupGlide(MainActivity.this, Uri.parse(TaskApp.getInstance().getCurrentCustomer().getLogo()), navLogo);
>>>>>>> 8748201... fix
=======

                        setupGlide(MainActivity.this, incomingCustomer.getLogo(), navLogo);
>>>>>>> 4d67dd1... Fix set logo on re-sign-in. Move Customer_ID to Owner
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
            FirebaseDatabase.getInstance().getReference(FirebaseReferences.TASKS).orderByChild(FirebaseReferences.OWNER_UID).equalTo(customerId).addValueEventListener(taskListener);
=======
            FirebaseDatabase.getInstance().getReference("tasks").orderByChild("owner").equalTo(customerId, "uid").addValueEventListener(taskListener);
>>>>>>> 74fd957... Fix Role. Fix Task
=======
            FirebaseDatabase.getInstance().getReference("tasks").orderByChild("owner/uid").equalTo(customerId).addValueEventListener(taskListener);
>>>>>>> d15fe36... Add ordering child by owner/uid
=======
            FirebaseDatabase.getInstance().getReference(FirebaseReferences.TASKS).orderByChild(FirebaseReferences.OWNER_UID).equalTo(customerId).addValueEventListener(taskListener);
>>>>>>> 9246afa... fix creating and sending task
=======
            FirebaseDatabase.getInstance().getReference(Constants.FirebaseReferences.TASKS).orderByChild(Constants.FirebaseReferences.OWNER_UID).equalTo(customerId).addValueEventListener(taskListener);
>>>>>>> 1335be7... Refactor resources
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
            FirebaseDatabase.getInstance().getReference(FirebaseReferences.TASKS).orderByChild(FirebaseReferences.OWNER_UID).equalTo(customerId).removeEventListener(taskListener);
=======
            FirebaseDatabase.getInstance().getReference("tasks").orderByChild("owner").equalTo(customerId, "uid").removeEventListener(taskListener);
>>>>>>> 74fd957... Fix Role. Fix Task
=======
            FirebaseDatabase.getInstance().getReference("tasks").orderByChild("owner/uid").equalTo(customerId).removeEventListener(taskListener);
>>>>>>> d15fe36... Add ordering child by owner/uid
=======
            FirebaseDatabase.getInstance().getReference(FirebaseReferences.TASKS).orderByChild(FirebaseReferences.OWNER_UID).equalTo(customerId).removeEventListener(taskListener);
>>>>>>> 9246afa... fix creating and sending task
            taskListener = null;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MY_LOG_TAG", "onStart: ACTIVITY_MAIN ");
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
=======
        navigationView.setItemBackground(Drawable.createFromPath(getIntent().getStringExtra("logo")));
=======
>>>>>>> d184d09... Task creation and DB saving added

<<<<<<< HEAD


<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        setCustomerNameAndLogo(navigationView, getIntent());

    }

<<<<<<< HEAD
    private void setCustomerNameAndLogo(NavigationView navigationView, Intent intent) {
        if (intent.hasExtra("logo")) {
            View hView = navigationView.getHeaderView(0);
            TextView navUser = (TextView) hView.findViewById(R.id.nav_name);
            ImageView navLogo = (ImageView) hView.findViewById(R.id.nav_logo);
            navUser.setText(intent.getStringExtra("name"));
            navLogo.setImageURI(Uri.parse(intent.getStringExtra("logo")));
        }
=======
        taskDBreference = FirebaseDatabase.getInstance().getReference("tasks");
        myTopPostsQuery = taskDBreference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).orderByChild("timeCreated");
        myTopPostsQuery.addValueEventListener(setupDBlistener());

////        if (getIntent().hasExtra("name") && getIntent().hasExtra("logo")) {
//            View hView =  navigationView.getHeaderView(0);
//            TextView navUser = (TextView)hView.findViewById(R.id.nav_name);
//            ImageView navLogo = (ImageView) hView.findViewById(R.id.nav_logo);
//            navUser.setText("blah");
//            hView.setBackground(getDrawable(R.drawable.cast_abc_scrubber_control_off_mtrl_alpha));
////            navigationView.setItemBackground(Drawable.createFromPath(TaskApp.getInstance().getCurrentCustomer().getLogo()));
////        }
>>>>>>> 0c7b888... h
=======
        taskDBreference = FirebaseDatabase.getInstance().getReference();
//        myTopPostsQuery = taskDBreference.child(customerId).orderByChild("timeCreated");


            View hView = navigationView.getHeaderView(0);
            TextView navUser = (TextView) hView.findViewById(R.id.nav_name);
            ImageView navLogo = (ImageView) hView.findViewById(R.id.nav_logo);
//
//        Glide
//                .with(this)
//                .load(TaskApp.getInstance().getCurrentCustomer().getLogo())
//                .centerCrop()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(navLogo);
//
//        navUser.setText(TaskApp.getInstance().getCurrentCustomer().getName());
>>>>>>> 3ead7f0... rawr
=======


=======
>>>>>>> f6a1ad0... lol
        View navHeader = navigationView.getHeaderView(0);
        navName = (TextView) navHeader.findViewById(R.id.nav_name);
        navLogo = (ImageView) navHeader.findViewById(R.id.nav_logo);
<<<<<<< HEAD
>>>>>>> e507f6d... filter tasks
    }
=======
>>>>>>> 4a3619e... lol

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 3bae9b8... NavView Image and Text plased.
=======
=======
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // RC_SIGN_IN is the request code you passed into startActivityForResult(...) when starting the sign in flow.
        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            // Successfully signed in
            if (resultCode == ResultCodes.OK) {
                Log.d("LOG", "onActivityResult:  reqCode = OK");

                if (TaskApp.getInstance().getCurrentCustomer() == null) {
                    Log.d("LOG", "onActivityResult ---- getCurrentCustomer: " +TaskApp.getInstance().getCurrentCustomer() );
                    FirebaseDatabase.getInstance().getReference("customers").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addValueEventListener(customerListener);
=======
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
>>>>>>> dabb3d3... Implement taskpager fragments

=======
>>>>>>> 64f37b7... Add progressBars
                if (user != null) {
                    customerId = user.getUid();
                    //user signed in
                    Toast.makeText(MainActivity.this, "You are now signed in.", Toast.LENGTH_SHORT).show();
                    onSignedInInitialize(customerId);

                } else {
                    //user signed out
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
                        RC_SIGN_IN);
                }
            }
        };

//        if (TaskApp.getInstance().getCurrentCustomer() == null) {

            mAuth.addAuthStateListener(authStateListener);
//        }
    }

<<<<<<< HEAD
>>>>>>> 6b47303... multiple login
    @NonNull
    private ValueEventListener getCustomerEventListener() {
        return new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
=======
    private void onSignedInInitialize(String id) {
=======
>>>>>>> 102aa24... architecture OK
        attachCustomerEventListener(id);
    }
>>>>>>> dabb3d3... Implement taskpager fragments

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

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG, "onCancel: " + databaseError);
            }
        };
>>>>>>> d184d09... Task creation and DB saving added
=======
=======
                    Log.d("LOG", "attachCustomerEventListener: ");
=======
                    Log.d("MY_LOG_TAG", "attachCustomerEventListener: " + dataSnapshot.getValue());
>>>>>>> ce4de03... Add handler for pause

<<<<<<< HEAD
>>>>>>> 64f37b7... Add progressBars
=======
                    showProgress();
>>>>>>> 102aa24... architecture OK
                    if (dataSnapshot.getValue() == null) {
                        showProgress();
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable(){
                            @Override
                            public void run(){
                                startActivity(new Intent(MainActivity.this, EditProfileActivity.class).putExtra("id", customerId).setFlags(FLAG_ACTIVITY_CLEAR_TASK | FLAG_ACTIVITY_NEW_TASK));
                            }
                        }, 1000);
                    } else {

                        final Customer incomingCustomer = dataSnapshot.getValue(Customer.class);
                        TaskApp.getInstance().setCurrentCustomer(incomingCustomer);
                        Log.d("MY_LOG_TAG", "attachCustomerEventListener ---- getCurrentCustomer: " + TaskApp.getInstance().getCurrentCustomer());

                        Glide.with(MainActivity.this)
                                .load(incomingCustomer.getLogo())
                                .centerCrop()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(navLogo);

                        navName.setText(incomingCustomer.getName());

                        attachTasksEventListener(incomingCustomer.getUid());
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.d(TAG, "onCancel: " + databaseError);
                }
            };
            FirebaseDatabase.getInstance().getReference("customers").child(customerId).addValueEventListener(customerListener);
        }
>>>>>>> dabb3d3... Implement taskpager fragments
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
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.d(TAG, "onCancel: " + databaseError);
                }
            };
            FirebaseDatabase.getInstance().getReference("tasks").orderByChild("customerId").equalTo(customerId).addValueEventListener(taskListener);
        }
    }

    private void detachCustomerEventListener() {
        if (customerListener != null) {
            FirebaseDatabase.getInstance().getReference("customers").child(customerId).removeEventListener(customerListener);
            customerListener = null;
        }
    }

    private void detachTasksEventListener() {
        if (taskListener != null) {
            FirebaseDatabase.getInstance().getReference("tasks").orderByChild("customerId").equalTo(customerId).removeEventListener(taskListener);
=======
            FirebaseDatabase.getInstance().getReference(Constants.FirebaseReferences.TASKS).orderByChild(Constants.FirebaseReferences.OWNER_UID).equalTo(customerId).removeEventListener(taskListener);
>>>>>>> 1335be7... Refactor resources
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
<<<<<<< HEAD
<<<<<<< HEAD
        getMenuInflater().inflate(R.menu.menu_main, menu);
=======
        getMenuInflater().inflate(R.menu.main, menu);
>>>>>>> d184d09... Task creation and DB saving added
=======
        getMenuInflater().inflate(R.menu.menu_main, menu);
>>>>>>> aee538b... bugfix
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
<<<<<<< HEAD
<<<<<<< HEAD
=======
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
>>>>>>> 3b9bd70... Bugfix
            case R.id.action_logout:
                AuthUI.getInstance().signOut(this);
                return true;
            case R.id.action_profile:
                startActivity(new Intent(this, ProfileActivity.class));
                return true;
<<<<<<< HEAD
            default: return super.onOptionsItemSelected(item);
=======
            case R.id.action_settings:
                return true;
=======
>>>>>>> aee538b... bugfix
            case R.id.action_logout:
                AuthUI.getInstance().signOut(this);
                return true;
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> d184d09... Task creation and DB saving added
        }
    }

<<<<<<< HEAD
<<<<<<< HEAD
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == ResultCodes.OK) {
                TaskApp.getInstance().setCurrentCustomer(null);
            }
        }
=======

=======
>>>>>>> 1d51cc4... Models refactoring. Check DB data sent OK
        return super.onOptionsItemSelected(item);
>>>>>>> d184d09... Task creation and DB saving added
=======
=======
            case R.id.action_profile:
                startActivity(new Intent(this, ProfileActivity.class).putExtra("size", taskList.size()));
                return true;
>>>>>>> 8eeaa9a... add collapsing layout
=======
>>>>>>> 3b9bd70... Bugfix
            default: return super.onOptionsItemSelected(item);
        }
>>>>>>> dabb3d3... Implement taskpager fragments
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

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> dabb3d3... Implement taskpager fragments
    private void addAllPages(ViewPager pager) {
        TaskPagerAdapter pagerAdapter = new TaskPagerAdapter(getSupportFragmentManager());
<<<<<<< HEAD
        pagerAdapter.addPage(setUpFragment(new TasksByCategoryFragment(), taskList));
        pagerAdapter.addPage(setUpFragment(new TasksByDateCreatedFragment(), taskList));
        pagerAdapter.addPage(setUpFragment(new TasksByDueDateFragment(), taskList));
<<<<<<< HEAD
<<<<<<< HEAD
        pagerAdapter.addPage(setUpFragment(new TasksByNameFragment(), taskList));
=======
>>>>>>> dabb3d3... Implement taskpager fragments
=======
        pagerAdapter.addPage(setUpFragment(new TasksByNameFragment(), taskList));
>>>>>>> 64f37b7... Add progressBars
=======
        pagerAdapter.addPage(TasksByCategoryFragment.newInstance(turnTasksListToJson(taskList)));
        pagerAdapter.addPage(TasksByDateCreatedFragment.newInstance(turnTasksListToJson(taskList)));
        pagerAdapter.addPage(TasksByDueDateFragment.newInstance(turnTasksListToJson(taskList)));
        pagerAdapter.addPage(TasksByNameFragment.newInstance(turnTasksListToJson(taskList)));
>>>>>>> 1335be7... Refactor resources
        pager.setAdapter(pagerAdapter);
    }

    private String turnTasksListToJson(ArrayList<Task> tasks) {
        Gson gson = new Gson();
<<<<<<< HEAD
        String tasksJson = gson.toJson(tasks);
        Bundle bundle = new Bundle();
<<<<<<< HEAD
<<<<<<< HEAD
        bundle.putString(Constants.TASKS, tasksJson);
=======
        bundle.putString("tasks", tasksJson);
>>>>>>> dabb3d3... Implement taskpager fragments
=======
        bundle.putString(Constants.TASKS, tasksJson);
>>>>>>> 9246afa... fix creating and sending task
        fragment.setArguments(bundle);
        return fragment;
=======
        return gson.toJson(tasks);
>>>>>>> 1335be7... Refactor resources
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
    class TaskChangeListener implements ValueEventListener {

        String customerId;

        public TaskChangeListener(String customerId) {
            this.customerId = customerId;
        }

        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {


//            Customer incomingCustomer = null;
//            if (customerId != null) {
//                incomingCustomer = dataSnapshot.child("customers").child(customerId).getValue(Customer.class);
//                TaskApp.getInstance().setCurrentCustomer(incomingCustomer);
//            }
//
//            TaskApp.getInstance().getTaskList().clear();
//            taskAdapter.notifyDataSetChanged();
//
//            for (DataSnapshot taskSnapshot : dataSnapshot.child("tasks").getChildren()) {
//                Task incomingTask = taskSnapshot.getValue(Task.class);
//                if (customerId != null && incomingTask.getOwner().getUid().equals(customerId)) {
//                    TaskApp.getInstance().setTaskList(incomingTask);
//                    taskAdapter.notifyDataSetChanged();
//                }
//
//            }
//            Glide.with(MainActivity.this)
//                    .load(incomingCustomer.getLogo())
//                    .centerCrop()
//                    .diskCacheStrategy(DiskCacheStrategy.ALL)
//                    .into(navLogo);
//
//            navName.setText(TaskApp.getInstance().getCurrentCustomer().getName());
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    }



>>>>>>> 92f4cb1... filter tasks
=======
>>>>>>> f2858f9... temp
=======
>>>>>>> dabb3d3... Implement taskpager fragments
}
=======
}
>>>>>>> 1c4249d... Fix comflict
